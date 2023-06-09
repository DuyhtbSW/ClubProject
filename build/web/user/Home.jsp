<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/Home.css"/>
        <title>Home</title>
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                padding: 20px 100px;
                display: flex;
                justify-content: space-between;
            }
            a {
                text-decoration: none;
            }
            li {
                list-style-type: none;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.account == null}">
            <script>
                <%
//                    String cookie = "";
//                    Cookie[] cookies = request.getCookies();
//                    if (cookies != null) {
//                        for (Cookie c : cookies) {
//                            if (c.getName().equals("rAcc")) {
//                                cookie = c.getValue();
//                            }
//                        }
//                        if (cookie != null) {
//                            response.sendRedirect("user");
//                        }
//                    }
                %>
            </script>
            <a href="<%=request.getContextPath()%>/user?command=GetCookie">Home</a>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <a href="<%=request.getContextPath()%>/user?command=Home">Home</a>
        </c:if>
        <a href="<%=request.getContextPath()%>/user?command=ClubsList">Clubs List</a>
        <c:if test="${sessionScope.clubCreator != null}">
        <li><a href="<%=request.getContextPath()%>/user?command=ForCreator">Club Manager<h6>for Creator</h6></a></li>
        </c:if>
        <c:if test="${sessionScope.clubManager != null}">
        <li><a href="<%=request.getContextPath()%>/user?command=ForManager">Club Manager<h6>for Manager</h6></a></li>
        </c:if>
        <c:if test="${sessionScope.clubMember != null}">
        <li><a href="<%=request.getContextPath()%>/user?command=ForMember">My Club</a></li>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <c:if test="${sessionScope.account.name != null}">
            <li><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Hello ${sessionScope.account.name}</a></li>
            </c:if>
        <li><a href="<%=request.getContextPath()%>/user?command=Notification">Notification</a></li>
            <%--<c:if test="${sessionScope.account.name == null}">--%>
            <!--<li><a href="user?command=LoadProfile">Hello ${sessionScope.account.email}</a></li>-->
        <%--</c:if>--%>
        <%--<c:choose>--%>
        <%--<c:when test="${sessionScope.account.name != null}">--%>
            <!--<li><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Hello ${sessionScope.account.name}</a></li>-->
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <!--<li><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Hello ${sessionScope.account.email}</a></li>-->
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <li><a href="<%=request.getContextPath()%>/user?command=Logout">Logout</a></li>
        </c:if>
        <c:if test="${sessionScope.account == null}">
        <li><a href="<%=request.getContextPath()%>/user?command=rLogin">Login</a></li>
        </c:if>
    <!--<a href="Login.jsp">Login</a>-->
</body>
</html>
