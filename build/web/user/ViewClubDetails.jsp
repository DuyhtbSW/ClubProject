<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Club Details</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Club Details</h2>
                <section class="recent">
                    <div class="activity-grid">
                        <%--<%@ include file="includes/ClubList.jsp" %>--%>
                        <div class="activity-card">
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Club Code</th>
                                            <th>Club Name</th>
                                            <th>Club Description</th>
                                            <th>Date Created</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${club.code}</td>
                                            <td>${club.name}</td>
                                            <td>${club.description}</td>
                                            <td>${club.dateCreated}</td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=LoadEditClub">Edit</a>
                                            </td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=ClubManage">Back</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>
