<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Admin - User Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@include file="includes/admin-sidebar.jsp" %>

        <div class="main-content">
            <%@include file="includes/admin-header.jsp" %>
            <main>
                <%@include file="includes/admin-overview.jsp" %>
                <section class="recent">
                    <div class="activity-grid">
                        
                        <%@ include file="includes/user-list.jsp" %>

                        <%@ include file="includes/admin-summary.jsp" %>
                    </div>
                </section>

            </main>

        </div>

    </body>
</html>
