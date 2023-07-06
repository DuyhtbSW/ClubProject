<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Manage - Club</title>
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
                <c:if test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                    <h2 class="dash-title">Club Manage</h2>
                </c:if>
                <c:if test="${sessionScope.IsMember != null}">
                    <h2 class="dash-title">Club Info</h2>
                </c:if>
                <section class="recent">
                    <c:if test="${sessionScope.IsCreator != null}">
                        <c:if test="${joinRequest == 1}">
                            <h3><a href="<%=request.getContextPath()%>/user?command=SetToPublic">Set to Public</a></h3>
                        </c:if>
                        <c:if test="${joinRequest != 1}">
                            <h3><a href="<%=request.getContextPath()%>/user?command=SetToPrivate">Set to Private</a></h3>
                        </c:if>
                    </c:if>
                    <div class="activity-grid">
                        <%@ include file="includes/ClubList.jsp" %>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>