<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Edit Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Edit Club</h2>
                <section class="recent">
                    <div class="activity-grid">
                        <div class="activity-card">
                            <h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Club Code</th>
                                            <th>Club Name</th>
                                            <th>Club Description</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <form action="<%=request.getContextPath()%>/user" method="get">
                                        <input type="hidden" name="command" value="EditClub">
                                        <tr>
                                            <td><input type="text" name="code" value="${club.code}"></td>
                                            <td><textarea rows="2" cols="25" name="name">${club.name}</textarea></td>
                                            <td><textarea rows="4" cols="25" name="description">${club.description}</textarea></td>
                                            <td>
                                                <input type="submit" name="save" value="Save"/>
                                                <!--<a href="<%=request.getContextPath()%>/user?command=EditClub">Save</a>-->
                                            </td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=ViewClubDetails">Cancel</a>
                                            </td>
                                        </tr>
                                    </form>
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
