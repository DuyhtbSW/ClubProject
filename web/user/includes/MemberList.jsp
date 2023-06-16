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
                <c:if test="${sessionScope.IsCreator != null}">
                    <tr>
                        <th>Name</th>
                        <th>Join Date</th>
                        <th>Gender</th>
                        <th></th>
                        <th></th>
                    </tr>
                </c:if>
                <c:if test="${sessionScope.IsManager != null}">
                    <tr>
                        <th>Name</th>
                        <th>Join Date</th>
                        <th>Gender</th>
                        <th></th>
                    </tr>
                </c:if>
            </thead>
            <tbody>
                <c:if test="${sessionScope.IsCreator != null}">
                    <c:forEach var="m" items="${member}">
                        <tr>
                            <td>${m.name}</td>
                            <td>${m.DOB}</td>
                            <td>${m.gender}</td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=SetToManager&mID=${m.ID}">Set to manager</a>
                            </td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=KickMember&cID=${clubID}&mID=${m.ID}">Kick</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${sessionScope.IsManager != null}">
                    <c:forEach var="m" items="${member}">
                        <tr>
                            <td>${m.name}</td>
                            <td>${m.DOB}</td>
                            <td>${m.gender}</td>
                            <!--                            <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=SetToManager&mID=${m.ID}">Set to manager</a>
                                                        </td>-->
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=KickMember&cID=${clubID}&mID=${m.ID}">Kick</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
