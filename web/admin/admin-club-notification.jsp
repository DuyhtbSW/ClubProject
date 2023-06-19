<%-- 
    Document   : admin-club-notification
    Created on : Jun 17, 2023, 11:20:35 PM
    Author     : acer
--%>

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
                        <%@ include file="includes/notification.jsp" %>
                        <%@ include file="includes/admin-summary.jsp" %>
                    </div>
                </section>

            </main>

        </div>

    </body>

</html>