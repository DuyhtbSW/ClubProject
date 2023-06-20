<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${event == null}">
        <h3>No event yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
    <div class="table-responsive">
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
                <c:forEach var="e" items="${event}">
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
                            <c:when test="${e.clubID != joinEvent && e.status == 'Upcoming'}">
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
        </table>
    </div>
</div>
