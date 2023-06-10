<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th>Poster</th>
                    <th>Post Dated</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${post}">
                    <tr>
                        <td>${p.userID}</td>
                        <td>${p.dated}</td>
                        <td>${p.title}</td>
                        <td>${p.description}</td>
                        <td>
                            <a href="#">View comment</a>
                        </td>
                        <td>
                            <a href="#">Manage post</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
