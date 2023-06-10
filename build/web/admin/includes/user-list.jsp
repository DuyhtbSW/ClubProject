<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="activity-card">
    <form action="UserControllerServlet" method="GET">
        <h3>Users List</h3>
        <div class="table-responsive">
            <table border="1" id="table">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>User Name</th>
                        <th>User Gender</th>
                        <th>REMOVE</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${user}">
                        <c:url var="tempLink" value="UserControllerServlet">
                            <c:param name="command" value="LOAD"></c:param>
                            <c:param name="userId" value="${item.userId}"></c:param>    
                        </c:url>
                        <c:url var="deleteLink" value="UserControllerServlet">
                            <c:param name="command" value="DELETE"></c:param>
                            <c:param name="userId" value="${item.userId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.userId}</td>
                            <td>${item.userName}</td>
                            <td>${item.userGender}</td>
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