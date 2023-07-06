<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${event == null}">
        <h3>No event yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
    <div class="table-responsive">
        <center>
            <table>
                <thead>
                    <tr>
                        <th>Event Name</th>
                        <th>Date</th>
                        <th>Description</th>
                        <th>Status</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="pageSize" value="5" />
                    <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                    <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                    <c:forEach var="e" items="${event}" begin="${startIndex}" end="${endIndex}">
                        <tr>
                            <td>${e.name}</td>
                            <td>${e.date}</td>
                            <td>${e.description}</td>
                            <td>${e.status}</td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${e.ID}">Event attendees</a>
                            </td>
                            <c:if test="${sessionScope.IsCreator != null}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=EventManage&eID=${e.ID}">Manage event</a>
                                </td>
                            </c:if>
                            <c:choose>
                                <%--<c:when test="${e.clubID != joinEvent && e.status == 'Upcoming'}">--%>
                                <c:when test="${e.removeStatus == 1 && e.status == 'Upcoming'}">
                                    <c:if test="${sessionScope.IsManager != null || sessionScope.IsMember != null}">
                                        <td>
                                            <a href="<%=request.getContextPath()%>/user?command=JoinEvent&eID=${e.ID}">Join event</a>
                                        </td>
                                    </c:if>
                                </c:when>
                                <c:when test="${e.clubID != joinEvent && e.status == 'Ongoing'}">
                                    <c:if test="${sessionScope.IsManager != null || sessionScope.IsMember != null}">
                                        <!--                                    <td>
                                                                                <a href="<%=request.getContextPath()%>/user?command=JoinEvent&eID=${e.ID}">Join event</a>
                                                                            </td>-->
                                    </c:if>
                                </c:when>
                                <c:when test="${e.clubID != joinEvent && e.status == 'Completed'}">
                                    <c:if test="${sessionScope.IsManager != null || sessionScope.IsMember != null}">
                                        <!--                                    <td>
                                                                                <a href="<%=request.getContextPath()%>/user?command=JoinEvent&eID=${e.ID}">Join event</a>
                                                                            </td>-->
                                    </c:if>
                                </c:when>
                                <c:when test="${e.clubID == joinEvent && e.status == 'Ongoing' || e.status == 'Completed'}">
                                    <c:if test="${sessionScope.IsManager != null || sessionScope.IsMember != null}">
                                        <!--                                    <td>
                                                                                <a href="<%=request.getContextPath()%>/user?command=JoinEvent&eID=${e.ID}">Join event</a>
                                                                            </td>-->
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${sessionScope.IsManager != null || sessionScope.IsMember != null}">
                                        <td>
                                            <a href="<%=request.getContextPath()%>/user?command=CancelEvent&eID=${e.ID}">Cancel join event</a>
                                        </td>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table><br>
            <c:set var="totalPages" value="${events div pageSize}" />
            <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
            <c:set var="previousPage" value="${currentPage - 1}" />
            <c:set var="nextPage" value="${currentPage + 1}" />

            <c:choose>
                <c:when test="${currentPage > 1}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${previousPage}"><</a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${currentPage}"><</a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                <c:choose>
                    <c:when test="${page == currentPage}">
                        <b>${page}</b>
                    </c:when>
                    <c:otherwise>
                        <!--<a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${page}">${page}</a>-->
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${currentPage < totalPages}">
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${nextPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${totalPagess + 1}">>></a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${currentPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=ClubEvent&page=${totalPagess + 1}">>></a>
                </c:otherwise>
            </c:choose>
        </center>
    </div>
</div>
