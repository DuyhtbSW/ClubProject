<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Home - Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    </head>
    <body>

        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>

        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>

                <h2 class="dash-title">Overview</h2>
                <c:if test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                    <div class="dash-cards">
                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-briefcase"></span>
                                <div>
                                    <h5>Managers</h5>
                                    <h4>${totalManager}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubManager">View all</a>
                            </div>
                        </div>

                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-check-box"></span>
                                <div>
                                    <h5>Members</h5>
                                    <h4>${totalMember}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubMember">View all</a>
                            </div>
                        </div>

                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-reload"></span>
                                <div>
                                    <h5>Posts</h5>
                                    <h4>${totalPost}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubPost">View all</a>
                            </div>
                        </div>
                    </div><br><br>

                    <div class="dash-cards">
                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-briefcase"></span>
                                <div>
                                    <h5>Events</h5>
                                    <h4>${totalEvent}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubEvent">View all</a>
                            </div>
                        </div>

                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-check-box"></span>
                                <div>
                                    <h5>Join club request</h5>
                                    <h4>${totalEvent}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=JoinClubRequestList&clubID=${clubID}">View all</a>
                            </div>
                        </div>

                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-reload"></span>
                                <div>
                                    <h5>Post club request</h5>
                                    <h4>${totalEvent}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user/ClubEvent.jsp">View all</a>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.IsMember != null}">
                    <div class="dash-cards">
                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-briefcase"></span>
                                <div>
                                    <h5>Managers</h5>
                                    <h4>${totalManager}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubManager">View all</a>
                            </div>
                        </div>

                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-briefcase"></span>
                                <div>
                                    <h5>Members</h5>
                                    <h4>${totalMember}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubMember">View all</a>
                            </div>
                        </div>
                    </div><br><br>

                    <div class="dash-cards">
                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-check-box"></span>
                                <div>
                                    <h5>Posts</h5>
                                    <h4>${totalPost}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubPost">View all</a>
                            </div>
                        </div>

                        <div class="card-single">
                            <div class="card-body">
                                <span class="ti-reload"></span>
                                <div>
                                    <h5>Events</h5>
                                    <h4>${totalEvent}</h4>
                                </div>
                            </div>
                            <div class="card-footer">
                                <a href="<%=request.getContextPath()%>/user?command=ClubEvent">View all</a>
                            </div>
                        </div>
                    </div>
                </c:if>
            </main>
        </div>
    </body>
</html>