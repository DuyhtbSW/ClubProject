<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${post == null}">
        <h3>No post yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
    <div class="table-responsive">
        <center>
            <table>
                <thead>
                    <tr>
                        <th></th>
                        <th>Poster</th>
                        <th>Date</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="pageSize" value="5" />
                    <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                    <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                    <c:forEach var="p" items="${post}" begin="${startIndex}" end="${endIndex}">
                        <tr>
                            <td><img src="images/${p.img}" width="80" height="50" alt="image"/></td>
                            <td>${p.memberID}</td>
                            <td>${p.date}</td>
                            <td>${p.title}</td>
                            <td>${p.description}</td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${p.ID}">View comment</a>
                            </td>
                            <c:if test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=PostManage&pID=${p.ID}">Manage post</a>
                                </td>
                            </c:if>
                            <%--<c:if test="${sessionScope.IsMember != null && myPost.ID == p.ID}">--%>
                            <c:if test="${sessionScope.IsMember != null}">
                                <c:forEach var="mp" items="${myPost}">
                                    <c:if test="${mp.ID == p.ID}">
                                        <td>
                                            <a href="<%=request.getContextPath()%>/user?command=PostManage&pID=${p.ID}">Manage post</a>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table><br>
            <c:set var="totalPages" value="${posts div pageSize}" />
            <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
            <c:set var="previousPage" value="${currentPage - 1}" />
            <c:set var="nextPage" value="${currentPage + 1}" />

            <c:choose>
                <c:when test="${currentPage > 1}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${previousPage}"><</a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${currentPage}"><</a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                <c:choose>
                    <c:when test="${page == currentPage}">
                        <b>${page}</b>
                    </c:when>
                    <c:otherwise>
                        <!--<a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${page}">${page}</a>-->
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${currentPage < totalPages}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${nextPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${totalPagess + 1}">>></a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${currentPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubPost&page=${totalPagess + 1}">>></a>
                </c:otherwise>
            </c:choose>
        </center>
    </div>
</div>
