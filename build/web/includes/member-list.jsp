<%-- 
    Document   : admin-member
    Created on : May 23, 2023, 2:30:57 PM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <th>REMOVE</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${mb}">
                        <tr>
                            <td>${item.userId}</td>
                            <td>Do later - Not Yet</td>
                            <td>Remove</td>
                            <td>
                                <a href="#">View detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
