<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Event Manage</title>
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
                <h2 class="dash-title">Event Manage</h2>
                <section class="recent">
                    <h4><a href="<%=request.getContextPath()%>/user?command=ClubEvent">Back</a></h4>
                    <div class="activity-grid">
                        <div class="activity-card">
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>Event Name</th>
                                            <th>Date</th>
                                            <th>Description</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><img src="images/${event.img}" width="80" height="50" alt="image"/></td>
                                            <td>${event.name}</td>
                                            <td>${event.date}</td>
                                            <td>${event.description}</td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=LoadEditEvent&eID=${eventID}">Edit</a>
                                            </td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=DeleteEvent&eID=${eventID}">Remove</a>
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
