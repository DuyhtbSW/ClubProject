<%-- 
    Document   : notification
    Created on : Jun 15, 2023, 4:29:26 PM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="activity-notification">
    <div class="table-responsive">
        <h3>Notification Detail</h3><br>
        <form action="NotificationControllerServlet" method="GET">
            <input type="hidden" name="command" value="SENT">
            <input type="hidden" name="clubId" value="${The_Club.clubId}">
            <input type="hidden" name="userId" value="${The_Club.clubCreatorId}">
            <input type="hidden" name="notificationId" value="${noti.notificationId}">
            <table border="1">
                <tbody>
                    <tr>
                        <th>Club ID</th><td>${The_Club.clubId}</td>
                    <tr>    
                        <th>Title</th><td>${noti.title}</td>
                    <tr>   
                        <th>Note</th><td><textarea type="text" name="Note" style="width: 400px; height: 30px;"></textarea></td>
                    <tr> 
                        <th>Accept/Decline</th>
                        <td><input type="radio" name="accept" value="Accept" >Accept
                            <input type="radio" name="accept" value="Decline" >Decline</td>
                    <tr>
                        <th><a href="javascript:history.back()" onclick="if (!(confirm('Sure?')))
                                    return false">Cancel</a></th>
                        <td>
                            <%
                                                        String warning = (String) request.getSession().getAttribute("warning");
                                                        if (warning != null && !warning.isEmpty()) {
                            %>
                        <div class="warning-message" style="margin-bottom: 10px; color: red; font-style: italic; ">
                                <%=warning%>
                        </div>
                            <%
                                request.getSession().removeAttribute("warning");
                            }
                            %>
                            <input type="submit" value="Sent" class="save" onclick="alert('Sent Notification')"/>
                        </td>
                </tbody>
            </table>
        </form>
    </div>
</div>
