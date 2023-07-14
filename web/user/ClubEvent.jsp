<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Event - Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            th, td {
                text-align: center;
            }

            .activity-grid {
                display: grid;
                grid-template-columns: 95% 25%;
                grid-column-gap: 1.5rem;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Events List</h2>
                <section class="recent">
                    <c:if test="${sessionScope.IsCreator != null}">
                        <h4><a href="<%=request.getContextPath()%>/user?command=rCreateEvent">Create Event</a></h4>
                    </c:if>
                    <div class="activity-grid">
                        <%@ include file="includes/EventList.jsp" %>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>
