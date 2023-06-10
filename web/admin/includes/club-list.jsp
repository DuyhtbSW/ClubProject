<%-- 
    Document   : club-list
    Created on : May 23, 2023, 2:13:38 PM
    Author     : acer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.Admin.MemberDao" %>

<!DOCTYPE html>
<div class="activity-card">
    <form action="ClubControllerServlet" method="GET">
        <h3>Clubs List</h3>
        <div class="table-responsive">
            <table border="1">
                <thead>
                    <tr>
                        <th>CLub ID</th>
                        <th>Club Name</th>
                        <th>Number of member</th>
                        <th>Manager</th>
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
                            <td>${item.clubId}</td>
                            <td>${item.clubName}</td>
                            <td><c:out value="${MemberDao.countMemberOfClub(item.clubId)}" /></td>
                            <td>${item.clubCreatorId}</td>
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