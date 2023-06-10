<%@ page import="dao.Admin.MemberDao" %>

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
                    <TH>Club Description</TH><TD>${The_Club.clubDiscription}</TD><TD> <input type="text" name="clubDesription" value="${The_Club.clubDiscription}"></TD>
                <tr>
                    <TH>Club Creator ID</TH><TD>${The_Club.clubCreatorId}</TD><TD> <input type="text" name="clubCreatorID" value="${The_Club.clubCreatorId}"></TD>
                <tr>
                    <TH>Date Created</TH><TD>${The_Club.dateCreated}</TD><TD> <input type="text" name="dateCreated" value="${The_Club.dateCreated}"></TD>
                <tr>
                    <TH>Number Of Member</TH><TD><c:out value="${MemberDao.countMemberOfClub(The_Club.clubId)}" /></TD><TD><c:out value="${MemberDao.countMemberOfClub(The_Club.clubId)}" /></TD>
                <tr>
                    <TH></TH><TH><a href="ClubControllerServlet"> Back to the List</a></TH>
                    <TH>
                        <input type="submit" value="UPDATE" class="save" onclick="alert('Update success')"/>
                    </TH>
            </tbody>
        </table>
</section>
