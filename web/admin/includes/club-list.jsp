<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.Admin.MemberDao" %>
<%@ page import="dao.Admin.UserDao" %>
<div class="activity-card">
    <form action="ClubControllerServlet" method="GET">
        <h3>Clubs List</h3>
        <div class="table-responsive">
            <table border="1">
                <thead>
                    <tr>
                        <th>Club Code</th>
                        <th>Club Name</th>
                        <th>Number of member</th>
                        <th>Manager</th>
                        <th>Join Request</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cl}">
                        <c:url var="tempLink" value="ClubControllerServlet">
                            <c:param name="command" value="LOAD"></c:param>
                            <c:param name="clubId" value="${item.clubId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.clubCode}</td>
                            <td>${item.clubName}</td>
                            <td><c:out value="${MemberDao.countMemberOfClub(item.clubId)}" /></td>
                            <td>${UserDao.getUserName(item.clubCreatorId)}</td>
                            <td>${item.joinRequest == false ? "Not required" : "Required"}</td>
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