<%-- 
    Document   : event-request
    Created on : Jun 11, 2023, 10:25:14 AM
    Author     : acer
--%>

<div class="activity-card">
    <form action="EventControllerServlet" method="GET">
        <h3>Event Request List</h3>
        <div class="table-responsive">
            <table border="1" id="table">
                <thead>
                    <tr>
                        <th>Event ID</th>
                        <th>Event Name</th>
                        <th>Date</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${evRe}">
                        <c:url var="tempLink" value="NotificationControllerServlet">
                            <c:param name="command" value="LOADEVENT"></c:param>
                            <c:param name="eventId" value="${item.eventId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.eventId}</td>
                            <td>${item.eventName}</td>
                            <td>${item.eventDate}</td>
                            <td>
                                <a href="${tempLink}">Feedback</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
