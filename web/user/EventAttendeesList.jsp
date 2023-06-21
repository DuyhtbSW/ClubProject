<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Event Attendees List</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            th, td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Event Attendees List</h2>
                <section class="recent">
                    <h4><a href="<%=request.getContextPath()%>/user?command=ClubEvent">Back</a></h4>
                    <div class="activity-grid">
                        <div class="activity-card">
                            <c:if test="${eventAttendees == null}">
                                <h3>No attendees this event</h3>
                                <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
                            </c:if>
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Event Name</th>
                                            <th>Date</th>
                                            <th>Description</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${event.name}</td>
                                            <td>${event.date}</td>
                                            <td>${event.description}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div><br>
                            <div class="table-responsive">
                                <center>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="pageSize" value="5" />
                                            <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                                            <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                                            <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                                            <c:forEach var="ea" items="${eventAttendees}" begin="${startIndex}" end="${endIndex}">
                                                <tr>
                                                    <td>${ea.name}</td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table><br>
                                    <c:set var="totalPages" value="${eventAttendeess div pageSize}" />
                                    <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
                                    <c:set var="previousPage" value="${currentPage - 1}" />
                                    <c:set var="nextPage" value="${currentPage + 1}" />

                                    <c:choose>
                                        <c:when test="${currentPage > 1}">
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=1"><<</a>
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=${previousPage}"><</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=1"><<</a>
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=${currentPage}"><</a>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                                        <c:choose>
                                            <c:when test="${page == currentPage}">
                                                <b>${page}</b>
                                            </c:when>
                                            <c:otherwise>
                                                <!--<a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&page=${page}">${page}</a>-->
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:choose>
                                        <c:when test="${currentPage < totalPages}">
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=${nextPage}">></a>
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=${totalPagess + 1}">>></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=${currentPage}">></a>
                                            <a href="<%=request.getContextPath()%>/user?command=EventAttendeesList&eID=${eventID}&page=${totalPagess + 1}">>></a>
                                        </c:otherwise>
                                    </c:choose>
                                </center>
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>
