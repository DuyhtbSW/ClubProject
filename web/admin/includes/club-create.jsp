<%@ page import="dao.Admin.UserDao" %>

<div class="activity-card">
    <form action="ClubControllerServlet" method="GET">
        <h3>Clubs Request List</h3>
        <div class="table-responsive">
            <table border="1">
                <thead>
                    <tr>
                        <th>Club ID</th>
                        <th>Club Name</th>
                        <th>Club Description</th>
                        <th>Manager</th>
                        <th>Date Created</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${clRe}">
                        <c:url var="tempLink" value="ClubControllerServlet">
                            <c:param name="command" value="CREATE"></c:param>
                            <c:param name="clubId" value="${item.clubId}"></c:param>    
                        </c:url>
                        <c:url var="deleteLink" value="ClubControllerServlet">
                            <c:param name="command" value="DELETE"></c:param>
                            <c:param name="clubId" value="${item.clubId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.clubId}</td>
                            <td>${item.clubName}</td>
                            <td>${item.clubDescription}</td>
                            <td>${UserDao.getUserName(item.clubCreatorId)}</td>
                            <td>${item.dateCreated}</td>
                            <td>
                                <a href="${tempLink}" onclick="if(!(confirm('Sure?'))) return false">Accept</a>
                            </td>
                            <td>
                                <a href="${deleteLink}" onclick="if(!(confirm('Sure?'))) return false">Decline</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>