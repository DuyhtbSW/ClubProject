<%@ page import="dao.Admin.EventDao" %>

<section id="detail">
    <h3>Event detail</h3>
    <form action="EventControllerServlet" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="eventId" value="${The_Event.eventId}">
        <Table>
            <tbody>
                <tr>
                    <TH>Event ID</TH><TD>${The_Event.eventId}</TD><TD>${The_Event.eventId}</TD>
                <tr>
                    <TH>Event Name</TH><TD>${The_Event.eventName}</TD><TD> <input type="text" name="eventName" value="${The_Event.eventName}"></TD>
                <tr>
                    <TH>Event Description</TH><TD>${The_Event.eventDescription}</TD><TD> <input type="text" name="eventDescription" value="${The_Event.eventDescription}"></TD>
                <tr>
                    <TH>Event Date</TH><TD>${The_Event.eventDate}</TD><TD> <input type="text" name="eventDate" value="${The_Event.eventDate}"></TD>
                <tr>
                    <TH>Event Status</TH><TD>${The_Event.eventStatus == 1 ? "Accepted" : "Waiting to accept"}</TD><TD><input type="text" name="eventStatus" value="${The_Event.eventStatus}" placeholder="0: Waiting, 1: Accepted"></TD>
                <tr>
                    <TH></TH><TH><a href="EventControllerServlet"> Back to the List</a></TH>
                    <TH>
                        <input type="submit" value="UPDATE" class="save" onclick="alert('Update success')"/>
                    </TH>
            </tbody>
        </table>    
        </table>
</section>
