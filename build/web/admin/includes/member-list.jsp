<%-- 
    Document   : admin-member
    Created on : May 23, 2023, 2:30:57 PM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.ClubDao" %>

<!DOCTYPE html>
<div class="activity-card">
    <form action="MemberControllerServlet" method="GET">
        <h3>Members List</h3>
        <div class="table-responsive">
            <table border="1">
                <thead>
                    <tr>
                        <th>Member ID</th>
                        <th>Member Name</th>
                        <th>Club Name</th>
                        <th>REMOVE</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${mb}">
                        <c:url var="tempLink" value="MemberControllerServlet">
                            <c:param name="command" value="LOAD"></c:param>
                            <c:param name="userId" value="${item.userId}"></c:param>    
                        </c:url>
                        <c:url var="deleteLink" value="UserControllerServlet">
                            <c:param name="command" value="DELETE"></c:param>
                            <c:param name="userId" value="${item.userId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.userId}</td>
                            <td>${UserDao.getUserName(item.userId)}</td>
                            <td>${ClubDao.getClubName(item.clubId)}</td>
                            <td>
                                <a href="${deleteLink}" onclick="if(!(confirm('Sure?'))) return false">Remove</a>
                            </td>
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
