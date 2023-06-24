<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${rating == null}">
        <h3>No rating yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
    <div class="table-responsive">
        <center>
            <table>
                <thead>
                    <tr>
                        <th></th>
                        <th>Vote</th>
                        <th>Note</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="pageSize" value="5" />
                    <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                    <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                    <c:forEach var="r" items="${rating}" begin="${startIndex}" end="${endIndex}">
                        <tr>
                            <c:if test="${thisRating.ID == r.ID}">
                                <td>
                                    <form action="<%=request.getContextPath()%>/user" method="get">
                                        <input type="hidden" name="command" value="EditRating">
                                        <input type="hidden" name="rID" value="${r.ID}">
                                        <td>
                                            <c:if test="${thisRating.vote == 1}">
                                                Old vote:<br><textarea rows="1" cols="7" name="ovote" readonly=""> ${thisRating.vote} star</textarea><br>
                                            </c:if>
                                            <c:if test="${thisRating.vote != 1}">
                                                Old vote:<br><textarea rows="1" cols="7" name="ovote" readonly=""> ${thisRating.vote} stars</textarea><br>
                                            </c:if>
                                            New vote:<br>
                                            <select name="nvote">
                                                <option></option>
                                                <option>1 star</option>
                                                <option>2 stars</option>
                                                <option>3 stars</option>
                                                <option>4 stars</option>
                                                <option>5 stars</option>
                                            </select>
                                        </td>
                                        <c:if test="${comments == null}">
                                            <td>
                                                <textarea rows="2" cols="30" name="note">${thisRating.note}</textarea>
                                            </td>
                                        </c:if>
                                        <c:if test="${comments != null}">
                                            <td>
                                                <textarea rows="2" cols="30" name="note"></textarea>
                                            </td>
                                        </c:if>
                                        <td>
                                            <input type="submit" value="Save">
                                        </td>
                                    </form>
                                </td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=ClubRating">Cancel</a>
                                </td>
                            </c:if>
                            <c:if test="${thisRating.ID != r.ID}">
                                <td></td>
                                <c:if test="${r.vote == 1}">
                                    <td>${r.vote} star</td>
                                </c:if>
                                <c:if test="${r.vote != 1}">
                                    <td>${r.vote} stars</td>
                                </c:if>
                                <td>${r.note}</td>
                                <c:if test="${sessionScope.IsManager != null && myRating.ID == r.ID}">
                                    <td>
                                        <a href="<%=request.getContextPath()%>/user?command=LoadEditRating&rID=${r.ID}">Edit</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/user?command=DeleteRating&rID=${r.ID}">Remove</a>
                                    </td>
                                </c:if>
                                <c:if test="${sessionScope.IsMember != null && myRating.ID == r.ID}">
                                    <td>
                                        <a href="<%=request.getContextPath()%>/user?command=LoadEditRating&rID=${r.ID}">Edit</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/user?command=DeleteRating&rID=${r.ID}">Remove</a>
                                    </td>
                                </c:if>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table><br>
            <c:set var="totalPages" value="${ratings div pageSize}" />
            <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
            <c:set var="previousPage" value="${currentPage - 1}" />
            <c:set var="nextPage" value="${currentPage + 1}" />

            <c:choose>
                <c:when test="${currentPage > 1}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${previousPage}"><</a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${currentPage}"><</a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                <c:choose>
                    <c:when test="${page == currentPage}">
                        <b>${page}</b>
                    </c:when>
                    <c:otherwise>
                        <!--<a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${page}">${page}</a>-->
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${currentPage < totalPages}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${nextPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${totalPagess + 1}">>></a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${currentPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubRating&page=${totalPagess + 1}">>></a>
                </c:otherwise>
            </c:choose>
        </center>
    </div>
</div>
