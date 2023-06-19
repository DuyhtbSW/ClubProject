<%-- 
    Document   : admin-club-search
    Created on : Jun 16, 2023, 11:03:12 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <%@ include file="includes/admin-conditionlogin.jsp" %>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

        <title>Admin - Club Page</title>
    </head>
    <body>

        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/admin-sidebar.jsp" %>

        <div class="main-content">
            <%@ include file="includes/admin-header.jsp" %>
            <main>

                <%@include file="includes/admin-overview.jsp" %>

                <section class="recent">
                    <div class="activity-grid">
                        <div class="activity-card">
                            <form action="ClubControllerServlet" method="GET">
                                <h3>Search List</h3>
                                <div class="table-responsive">
                                    <table border="1">
                                        <thead>
                                            <tr>
                                                <th>Club ID</th>
                                                <th>Club Name</th>
                                                <th>Number of member</th>
                                                <th>Manager</th>
                                                <th>Join Request</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${empty The_Club}">
                                            <p>No results found.</p> 
                                        </c:if>
                                        <style>
                                            p{
                                                color: red;
                                                font-style: italic;
                                                margin: 10px;
                                            }
                                        </style>
                                        <c:forEach var="item" items="${The_Club}">
                                            <c:url var="tempLink" value="ClubControllerServlet">
                                                <c:param name="command" value="LOAD"></c:param>
                                                <c:param name="clubId" value="${item.clubId}"></c:param>    
                                            </c:url>
                                            <tr>
                                                <td>${item.clubId}</td>
                                                <td>${item.clubName}</td>
                                                <td><c:out value="${MemberDao.countMemberOfClub(item.clubId)}" /></td>
                                                <td>${UserDao.getUserName(item.clubCreatorId)}</td>
                                                <td>${item.joinRequest == false ? "Not required" : "Required"}</td>
                                                <td>
                                                    <a href="${tempLink}">View detail</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>

            </main>

        </div>

    </body>
</html>

