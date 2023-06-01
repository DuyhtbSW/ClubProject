<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <!--<h3>Members List</h3>-->
    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Gender</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="m" items="${member}">
                    <tr>
                        <td>${m.name}</td>
                        <td>${m.DOB}</td>
                        <td>${m.gender}</td>
                        <!--<td>${m.ID}</td>-->
                        <td>
                            <a href="#">Set to manager</a>
                        </td>
                        <td>
                            <a href="#">Kick</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
