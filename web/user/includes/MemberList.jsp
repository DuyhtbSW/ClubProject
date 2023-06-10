<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${member == null}">
        <h3>No member yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
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
                            <a href="<%=request.getContextPath()%>/user?command=SetToManager&mID=${m.ID}">Set to manager</a>
                        </td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=KickMember&cID=${clubID}&mID=${m.ID}">Kick</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
