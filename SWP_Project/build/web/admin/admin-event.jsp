<%-- 
    Document   : admin-event
    Created on : May 23, 2023, 2:45:35 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Admin - Event Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    </head>
    <body>

        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/admin-sidebar.jsp" %>
        
        <div class="main-content">
            <%@ include file="includes/admin-header.jsp" %>
            <main>

                <h2 class="dash-title">Overview</h2>

                <div class="dash-cards">
                    <div class="card-single">
                        <div class="card-body">
                            <span class="ti-briefcase"></span>
                            <div>
                                <h5>Clubs</h5>
                                <h4>20</h4>
                            </div>
                        </div>
                        <div class="card-footer">
                            <a href="">View all</a>
                        </div>
                    </div>

                    <div class="card-single">
                        <div class="card-body">
                            <span class="ti-reload"></span>
                            <div>
                                <h5>Events</h5>
                                <h4>30</h4>
                            </div>
                        </div>
                        <div class="card-footer">
                            <a href="">View all</a>
                        </div>
                    </div>

                    <div class="card-single">
                        <div class="card-body">
                            <span class="ti-check-box"></span>
                            <div>
                                <h5>Members</h5>
                                <h4>540</h4>
                            </div>
                        </div>
                        <div class="card-footer">
                            <a href="">View all</a>
                        </div>
                    </div>
                </div>


                <section class="recent">
                    <div class="activity-grid">
                        <%@ include file="includes/event-list.jsp" %>

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
                                        <small>Profile update request</small>
                                    </div>
                                </div>
                            </div>

                            <div class="bday-card">
                                <div class="bday-flex">
                                    <div class="bday-img"></div>
                                    <div class="bday-info">
                                        <h5>Dwayne F. Sanders</h5>
                                        <small>Birthday Today</small>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <button>
                                        <span class="ti-gift"></span>
                                        Wish him
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </main>

        </div>

    </body>
    </body>
</html>
