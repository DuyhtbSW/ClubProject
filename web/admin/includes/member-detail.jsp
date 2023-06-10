<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.Admin.UserDao" %>
<%@ page import="dao.Admin.ClubDao" %>
<section id="detail">
    <h3>Member detail</h3>
    <form action="MemberControllerServlet" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="userId" value="${The_Member.userId}">
        <table>
            <c:url var="tempLink" value="UserControllerServlet">
                <c:param name="command" value="LOAD"></c:param>
                <c:param name="userId" value="${The_Member.userId}"></c:param>    
            </c:url>
            <tbody>
                <tr>
                    <TH>Member ID</TH><TD>${The_Member.userId}</TD><TD>${The_Member.userId}</TD>
                    <TH>
                        <a href="${tempLink}">Edit this member</a>
                    </TH>
                <tr>
                    <TH>Member Name</TH><TD>${UserDao.getUserName(The_Member.userId)}</TD><TD>${UserDao.getUserName(The_Member.userId)}</TD>
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
