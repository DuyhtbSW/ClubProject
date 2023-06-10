<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${manager == null}">
        <h3>No manager yet</h3>
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
                <c:forEach var="m" items="${manager}">
                    <tr>
                        <td>${m.name}</td>
                        <td>${m.DOB}</td>
                        <td>${m.gender}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=SetToMember&mID=${m.ID}">Set to member</a>
                        </td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=KickManager&cID=${clubID}&mID=${m.ID}">Kick</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
