<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <!--    <h3>Club Manage</h3>-->
    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th>Club Code</th>
                    <th>Club Name</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${sessionScope.IsCreator != null}">
                    <tr>
                        <td>${club.code}</td>
                        <td>${club.name}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=ViewClubDetails">View detail</a>
                        </td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=JoinClubRequestList&clubID=${club.ID}">Join club request</a>
                        </td>
                        <td>
                            <a href="#">Remove</a>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${sessionScope.IsManager != null}">
                    <tr>
                        <td>${club.code}</td>
                        <td>${club.name}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=ViewClubDetails">View detail</a>
                        </td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=JoinClubRequestList&clubID=${club.ID}">Join club request</a>
                        </td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>