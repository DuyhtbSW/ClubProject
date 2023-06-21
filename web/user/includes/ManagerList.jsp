<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${manager == null}">
        <h3>No manager yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
    <div class="table-responsive">
        <center>
            <table>
                <thead>
                    <c:if test="${sessionScope.IsCreator != null}">
                        <tr>
                            <th>Name</th>
                            <th>Join Date</th>
                            <th>Gender</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                    </c:if>
                    <c:if test="${sessionScope.IsManager != null}">
                        <tr>
                            <th>Name</th>
                            <th>Join Date</th>
                            <th>Gender</th>
                            <th></th>
                        </tr>
                    </c:if>
                    <c:if test="${sessionScope.IsMember != null}">
                        <tr>
                            <th>Name</th>
                            <th>Join Date</th>
                            <th>Gender</th>
                            <th></th>
                        </tr>
                    </c:if>
                </thead>
                <tbody>
                    <c:set var="pageSize" value="5" />
                    <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                    <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                    <c:forEach var="m" items="${manager}" begin="${startIndex}" end="${endIndex}">
                        <tr>
                            <c:if test="${sessionScope.IsCreator != null}">
                                <td>${m.clubID}</td>
                                <td>${m.joinDate}</td>
                                <td>${m.isClubManager}</td>
                                <c:if test="${m.isClubManager == 'Male'}">
                                    <td>
                                        <a href="#">Chat with him</a>
                                    </td>
                                </c:if>
                                <c:if test="${m.isClubManager == 'Female'}">
                                    <td>
                                        <a href="#">Chat with her</a>
                                    </td>
                                </c:if>
                                <c:if test="${m.isClubManager != 'Male' && m.isClubManager != 'Female'}">
                                    <td>
                                        <a href="#">Chat with ...</a>
                                    </td>
                                </c:if>
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=SetToMember&mID=${m.ID}">Set to member</a>
                                </td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=KickManager&cID=${clubID}&mID=${m.ID}">Kick</a>
                                </td>
                            </c:if>
                            <c:if test="${sessionScope.IsManager != null}">
                                <td>${m.clubID}</td>
                                <td>${m.joinDate}</td>
                                <td>${m.isClubManager}</td>
                                <c:if test="${m.isClubManager == 'Male'}">
                                    <td>
                                        <a href="#">Chat with him</a>
                                    </td>
                                </c:if>
                                <c:if test="${m.isClubManager == 'Female'}">
                                    <td>
                                        <a href="#">Chat with her</a>
                                    </td>
                                </c:if>
                                <c:if test="${m.isClubManager != 'Male' && m.isClubManager != 'Female'}">
                                    <td>
                                        <a href="#">Chat with ...</a>
                                    </td>
                                </c:if>
                            </c:if>
                            <c:if test="${sessionScope.IsMember != null}">
                                <td>${m.clubID}</td>
                                <td>${m.joinDate}</td>
                                <td>${m.isClubManager}</td>
                                <c:if test="${m.isClubManager == 'Male'}">
                                    <td>
                                        <a href="#">Chat with him</a>
                                    </td>
                                </c:if>
                                <c:if test="${m.isClubManager == 'Female'}">
                                    <td>
                                        <a href="#">Chat with her</a>
                                    </td>
                                </c:if>
                                <c:if test="${m.isClubManager != 'Male' && m.isClubManager != 'Female'}">
                                    <td>
                                        <a href="#">Chat with ...</a>
                                    </td>
                                </c:if>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table><br>
            <c:set var="totalPages" value="${managers div pageSize}" />
            <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
            <c:set var="previousPage" value="${currentPage - 1}" />
            <c:set var="nextPage" value="${currentPage + 1}" />

            <c:choose>
                <c:when test="${currentPage > 1}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${previousPage}"><</a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${currentPage}"><</a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                <c:choose>
                    <c:when test="${page == currentPage}">
                        <b>${page}</b>
                    </c:when>
                    <c:otherwise>
                        <!--<a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${page}">${page}</a>-->
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${currentPage < totalPages}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${nextPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${totalPagess + 1}">>></a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${currentPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManager&page=${totalPagess + 1}">>></a>
                </c:otherwise>
            </c:choose>
        </center>
    </div>
</div>
