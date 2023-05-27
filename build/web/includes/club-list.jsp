<%-- 
    Document   : club-list
    Created on : May 23, 2023, 2:13:38 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <tr>
                            <td>${item.clubId}</td>
                            <td>${item.clubName}</td>
                            <td>Number I don't know how to do</td>
                            <td>${item.clubCreatorId}</td>
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