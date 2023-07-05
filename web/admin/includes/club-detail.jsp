<%@ page import="dao.Admin.MemberDao" %>
<%@ page import="dao.Admin.UserDao" %>
<section id="detail">
    <h3>Club detail</h3>
    <form action="ClubControllerServlet" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="clubId" value="${The_Club.clubId}">
        <table>
            <tbody>
                <tr>
                    <TH>Club ID</TH><TD>${The_Club.clubId}</TD><TD>${The_Club.clubId}</TD>
                <tr>
                    <TH>Club Code</TH><TD>${The_Club.clubCode}</TD><TD> <input type="text" name="clubCode" value="${The_Club.clubCode}"></TD>
                <tr>
                    <TH>Club Name</TH><TD>${The_Club.clubName}</TD><TD> <input type="text" name="clubName" value="${The_Club.clubName}"></TD>
                <tr>
                    <TH>Club Description</TH><TD>${The_Club.clubDescription}</TD><TD> <input type="text" name="clubDesription" value="${The_Club.clubDescription}"></TD>
                <tr>
                    <TH>Manager</TH><TD>${UserDao.getUserName(The_Club.clubCreatorId)}</TD><TD>${UserDao.getUserName(The_Club.clubCreatorId)}</TD>
                <tr>
                    <TH>Date Created</TH><TD>${The_Club.dateCreated}</TD><TD> <input type="text" name="dateCreated" value="${The_Club.dateCreated}"></TD>
                <tr>
                    <TH>Club Status</TH><TD>${The_Club.clubStatus == true ? "Accepted":"Waiting"}</TD>
                    <TD>
                        <select class="js-select" name="clubStatus">
                            <option value="${The_Club.clubStatus}">
                            <span class="option-text">Select an option</span>
                            </option>
                            <option value="true">
                            <span class="option-text">Accepted</span>
                            </option>
                            <option value="false" >
                            <span class="option-text">Waiting</span>
                            </option>
                        </select>
                    </TD>
                <tr>
                    <TH>Join Request</TH><TD>${The_Club.joinRequest == false ? "Not required" : "Required"}</TD>
                    <TD>
                        <select class="js-select" name="joinRequest">
                            <option value="${The_Club.joinRequest}">
                            <span class="option-text">Select an option</span>
                            </option>
                            <option value="true">
                            <span class="option-text">Required</span>
                            </option>
                            <option value="false" >
                            <span class="option-text">Not required</span>
                            </option>
                        </select>
                    </TD>
                <tr>
                    <TH></TH><TH><a href="ClubControllerServlet"> Back to the List</a></TH>
                    <TH>
                        <input type="submit" value="UPDATE" class="save" onclick="alert('Update success')"/>
                    </TH>
            </tbody>
        </table>
</section>
