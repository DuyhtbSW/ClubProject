<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="activity-card">
    <c:if test="${post == null}">
        <h3>No post yet</h3>
        <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
    </c:if>
    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th>Poster</th>
                    <th>Date</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${post}">
                    <tr>
                        <td>${p.memberID}</td>
                        <td>${p.date}</td>
                        <td>${p.title}</td>
                        <td>${p.description}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${p.ID}">View comment</a>
                        </td>
                        <c:if test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=PostManage&pID=${p.ID}">Manage post</a>
                            </td>
                        </c:if>
                        <c:if test="${sessionScope.IsMember != null && myPost != null}">
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=PostManage&pID=${p.ID}">Manage post</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
