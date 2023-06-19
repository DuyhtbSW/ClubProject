<%-- 
    Document   : notificationEvent
    Created on : Jun 18, 2023, 10:45:05 AM
    Author     : acer
--%>
<%@ page import="dao.Admin.ClubDao" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="activity-notification">
    <div class="table-responsive">
        <h3>Notification Detail</h3>
        <form action="NotificationControllerServlet" method="GET">
            <input type="hidden" name="command" value="SENTEVENT">
            <input type="hidden" name="eventId" value="${The_Event.eventId}">
            <input type="hidden" name="userId" value="${ClubDao.getManagerId(The_Event.clubId)}">
            <table border="1">
                <tbody>
                    <tr>
                        <th>User ID</th><td>${ClubDao.getManagerId(The_Event.clubId)}</td>
                    <tr>    
                        <th>Title</th><td><input type="text" name="Title"></td>
                    <tr>    
                        <th>Note</th><td><input type="text" name="Note"></td>
                    <tr> 
                        <th>Accept/Decline</th>
                        <td><input type="checkbox" name="accept" value="Accept" onclick="document.notification.decline.checked = false;">Accept
                            <input type="checkbox" name="accept" value="Decline" onclick="document.notification.accept.checked = false;">Decline</td>
                    <tr>
                        <th><a href="javascript:history.back()" onclick="if (!(confirm('Sure?')))
                                    return false">Cancel</a></th>
                        <td>
                            <input type="submit" value="Sent" class="save" onclick="alert('Sent Notification')"/>
                        </td>
                </tbody>
            </table>
        </form>
    </div>
</div>
