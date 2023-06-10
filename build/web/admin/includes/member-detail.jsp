<%-- 
    Document   : member-detail
    Created on : May 26, 2023, 9:46:36 PM
    Author     : acer
--%>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.ClubDao" %>
<section id="detail">
    <h3>Member detail</h3>
    <form action="MemberControllerServlet" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="userId" value="${The_Member.userId}">
        <table>
            <tbody>
                <tr>
                    <TH>Member ID</TH><TD>${The_Member.userId}</TD><TD>${The_Member.userId}</TD>
                <tr>
                    <TH>Member Name</TH><TD>${UserDao.getUserName(The_Member.userId)}</TD><TD> <input type="text" name="clubId" value="${UserDao.getUserName(The_Member.userId)}"></TD>
                <tr>
                    <TH>Club Name</TH><TD>${ClubDao.getClubName(The_Member.clubId)}</TD><TD>${ClubDao.getClubName(The_Member.clubId)}</TD>
                <tr>
                    <TH>Is Club Manager</TH><TD>${The_Member.isClubManager}</TD><TD>${The_Member.isClubManager}</TD>
                <tr>
                    <TH>Join Date</TH><TD>${The_Member.joinDate}</TD><TD> <input type="text" name="joinDate" value="${The_Member.joinDate}"></TD>
                <tr>
                    <TH></TH><TH><a href="MemberControllerServlet"> Back to the List</a></TH>
                    <TH>
                        <input type="submit" value="UPDATE" class="save" onclick="alert('Update success')"/>
                    </TH>
            </tbody>
        </table>    
    </form>
</section>
