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
        <a href="<%=request.getContextPath()%>/user?command=Home">Home</a>
        <a href="<%=request.getContextPath()%>/user?command=ClubsList">Clubs List</a>
        <c:if test="${sessionScope.clubCreator != null}">
        <li><a href="<%=request.getContextPath()%>/user/ClubHome.jsp">Club Manager</a></li>
        </c:if>
        <c:if test="${sessionScope.clubManager != null}">
        <li><a href="<%=request.getContextPath()%>/user?command=Home">Club Manager</a></li>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <c:if test="${sessionScope.account.name != null}">
            <li><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Hello ${sessionScope.account.name}</a></li>
            </c:if>
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
        <li><a href="<%=request.getContextPath()%>/user/Login.jsp">Login</a></li>
        </c:if>
    <!--<a href="Login.jsp">Login</a>-->
</body>
</html>
