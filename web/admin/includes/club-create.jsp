<%-- 
    Document   : club-create
    Created on : Jun 10, 2023, 12:26:37 PM
    Author     : acer
--%>

<div class="activity-card">
    <form action="ClubControllerServlet" method="GET">
        <h3>Clubs Request List</h3>
        <div class="table-responsive">
            <table border="1">
                <thead>
                    <tr>
                        <th>CLub ID</th>
                        <th>Club Name</th>
                        <th>Club Description</th>
                        <th>Manager</th>
                        <th>Date Created</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${clRe}">
                        <c:url var="tempLink" value="ClubControllerServlet">
                            <c:param name="command" value="CREATE"></c:param>
                            <c:param name="clubId" value="${item.clubId}"></c:param>    
                        </c:url>
                        <tr>
                            <td>${item.clubId}</td>
                            <td>${item.clubName}</td>
                            <th>${item.clubDiscription}</th>
                            <td>${item.clubCreatorId}</td>
                            <th>${item.dateCreated}</th>
                            <td>
                                <a href="${tempLink}" onclick="if(!(confirm('Sure?'))) return false">Accept</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
