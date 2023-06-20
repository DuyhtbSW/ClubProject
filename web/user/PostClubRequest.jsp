<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Post Club Request - Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            th, td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Post Club Request</h2>
                <section class="recent">
                    <h4><a href="<%=request.getContextPath()%>/user?command=ClubManage">Back</a></h4>
                    <div class="activity-grid">
                        <div class="activity-card">
                            <!--    <h3>Club Manage</h3>-->
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
                                        <c:forEach var="pr" items="${postRequest}">
                                            <tr>
                                                <td>${pr.memberID}</td>
                                                <td>${pr.date}</td>
                                                <td>${pr.title}</td>
                                                <td>${pr.description}</td>
                                                <td>
                                                    <a href="<%=request.getContextPath()%>/user?command=PostRequestAccept&pID=${pr.ID}">Accept</a>
                                                </td>
                                                <td>
                                                    <a href="<%=request.getContextPath()%>/user?command=PostRequestDecline&pID=${pr.ID}">Decline</a>
                                                </td>
                                            </c:forEach>
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