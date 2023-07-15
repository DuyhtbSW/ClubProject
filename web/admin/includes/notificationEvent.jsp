<%-- 
    Document   : notificationEvent
    Created on : Jun 18, 2023, 10:45:05 AM
    Author     : acer
--%>
<%@ page import="dao.Admin.ClubDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="activity-notification">
    <div class="table-responsive">
        <h3>Notification Detail</h3><br>
        <form action="NotificationControllerServlet" method="GET">
            <input type="hidden" name="command" value="SENTEVENT">
            <input type="hidden" name="eventId" value="${The_Event.eventId}">
            <input type="hidden" name="userId" value="${ClubDao.getManagerId(The_Event.clubId)}">
            <input type="hidden" name="notificationId" value="${noti.notificationId}">
            <table border="1">
                <tbody>
                    <tr>
                        <th>User ID</th><td>${ClubDao.getManagerId(The_Event.clubId)}</td>
                    <tr>    
                        <th>Title</th><td>${noti.title}</td>
                    <tr>    
                        <th>Note</th><td><textarea type="text" name="Note" style="width: 400px; height: 30px;"></textarea></td>
                    <tr> 
                        <th>Accept/Decline</th>
                        <td><input type="radio" name="accept" value="Accept" onclick="document.notification.decline.checked = false;">Accept
                            <input type="radio" name="accept" value="Decline" onclick="document.notification.accept.checked = false;">Decline</td>
                    <tr>
                        <th><a href="javascript:history.back()" onclick="if (!(confirm('Sure?')))
                                    return false">Cancel</a></th>
                        <td>
                            <p style="color: red; font-style: italic;"><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></p>
                            <input type="submit" value="Send" class="save" onclick="if (!(confirm('Feedback this request?'))) return false"/>
                        </td>
                </tbody>
            </table>
        </form>
    </div>
</div>