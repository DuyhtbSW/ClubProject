<%-- 
    Document   : home
    Created on : May 25, 2023, 7:33:16 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Admin - Club Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
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
                        <div class="summary">
                            <div class="summary-card">
                                <div class="summary-single">
                                    <span class="ti-id-badge"></span>
                                    <div>
                                        <h5>196</h5>
                                        <small>Create Club Request</small>
                                    </div>
                                </div>
                                <div class="summary-single">
                                    <span class="ti-calendar"></span>
                                    <div>
                                        <h5>16</h5>
                                        <small>Event Request</small>
                                    </div>
                                </div>
                                <div class="summary-single">
                                    <span class="ti-face-smile"></span>
                                    <div>
                                        <h5>12</h5>
                                        <small>Club update request</small>
                                    </div>
                                </div>
                            </div>

                            <div class="bday-card">
                                <div class="bday-flex">
                                    <div class="bday-img"></div>
                                    <div class="bday-info">
                                        <h5>Club Dever</h5>
                                        <small>Event Today</small>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <button>
                                        <span class="ti-gift"></span>
                                        View Detail
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </main>

        </div>

    </body>
</html>
