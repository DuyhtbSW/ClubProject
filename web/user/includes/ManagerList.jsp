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
                <c:if test="${sessionScope.IsCreator != null}">
                    <tr>
                        <th>Name</th>
                        <th>Join Date</th>
                        <th>Gender</th>
                        <th></th>
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
                <c:if test="${sessionScope.IsMember != null}">
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
                    <c:forEach var="m" items="${manager}">
                        <tr>
                            <td>${m.clubID}</td>
                            <td>${m.joinDate}</td>
                            <td>${m.isClubManager}</td>
                            <c:if test="${m.isClubManager == 'Male'}">
                                <td>
                                    <a href="#">Chat with him</a>
                                </td>
                            </c:if>
                            <c:if test="${m.isClubManager == 'Female'}">
                                <td>
                                    <a href="#">Chat with her</a>
                                </td>
                            </c:if>
                            <c:if test="${m.isClubManager != 'Male' && m.isClubManager != 'Female'}">
                                <td>
                                    <a href="#">Chat with ...</a>
                                </td>
                            </c:if>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=SetToMember&mID=${m.ID}">Set to member</a>
                            </td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=KickManager&cID=${clubID}&mID=${m.ID}">Kick</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${sessionScope.IsManager != null}">
                    <c:forEach var="m" items="${manager}">
                        <tr>
                            <td>${m.clubID}</td>
                            <td>${m.joinDate}</td>
                            <td>${m.isClubManager}</td>
                            <c:if test="${m.isClubManager == 'Male'}">
                                <td>
                                    <a href="#">Chat with him</a>
                                </td>
                            </c:if>
                            <c:if test="${m.isClubManager == 'Female'}">
                                <td>
                                    <a href="#">Chat with her</a>
                                </td>
                            </c:if>
                            <c:if test="${m.isClubManager != 'Male' && m.isClubManager != 'Female'}">
                                <td>
                                    <a href="#">Chat with ...</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${sessionScope.IsMember != null}">
                    <c:forEach var="m" items="${manager}">
                        <tr>
                            <td>${m.clubID}</td>
                            <td>${m.joinDate}</td>
                            <td>${m.isClubManager}</td>
                            <c:if test="${m.isClubManager == 'Male'}">
                                <td>
                                    <a href="#">Chat with him</a>
                                </td>
                            </c:if>
                            <c:if test="${m.isClubManager == 'Female'}">
                                <td>
                                    <a href="#">Chat with her</a>
                                </td>
                            </c:if>
                            <c:if test="${m.isClubManager != 'Male' && m.isClubManager != 'Female'}">
                                <td>
                                    <a href="#">Chat with ...</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
