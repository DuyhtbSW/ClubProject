<%-- 
    Document   : event-list
    Created on : May 23, 2023, 2:44:41 PM
    Author     : acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="activity-card">
    <form action="EventControllerServlet" method="GET">
        <h3>Event List</h3>
        <div class="table-responsive">
            <table border="1" id="table">
                <thead>
                    <tr>
                        <th>Event ID</th>
                        <th>Event Name</th>
                        <th>Date</th>
                        <th>REMOVE</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${event}">
                        <c:url var="tempLink" value="EventControllerServlet">
                            <c:param name="command" value="LOAD"></c:param>
                            <c:param name="eventId" value="${item.eventId}"></c:param>    
                        </c:url>
                        <c:url var="deleteLink" value="EventControllerServlet">
                            <c:param name="command" value="DELETE"></c:param>
                            <c:param name="eventId" value="${item.eventId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.eventId}</td>
                            <td>${item.eventName}</td>
                            <td>${item.eventDate}</td>
                            <td>
                                <a href="${deleteLink}" onclick="if(!(confirm('Sure?'))) return false">Remove</a>
                            </td>
                            <td>
                                <a href="${tempLink}">View detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>