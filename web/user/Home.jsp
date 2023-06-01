<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/Home.css"/>
        <title>Home</title>
    </head>
    <body>
        <a href="<%=request.getContextPath()%>/user/Home.jsp">Home</a>
        <a href="<%=request.getContextPath()%>/user?command=ClubsList">Clubs List</a>
        <c:if test="${sessionScope.clubCreator != null}">
        <li><a href="<%=request.getContextPath()%>/user/ClubHome.jsp">Manage Your Club</a></li>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <%--<c:if test="${sessionScope.account.name != null}">--%>
            <!--<li><a href="user?command=LoadProfile">Hello ${sessionScope.account.name}</a></li>-->
        <%--</c:if>--%>
        <%--<c:if test="${sessionScope.account.name == null}">--%>
        <!--<li><a href="user?command=LoadProfile">Hello ${sessionScope.account.email}</a></li>-->
        <%--</c:if>--%>
        <c:choose>
            <c:when test="${sessionScope.account.name != null}">
                <li><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Hello ${sessionScope.account.name}</a></li>
                </c:when>
                <c:otherwise>
                <li><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Hello ${sessionScope.account.email}</a></li>
                </c:otherwise>
            </c:choose>
        <li><a href="<%=request.getContextPath()%>/user?command=Logout">Logout</a></li>
        </c:if>
        <c:if test="${sessionScope.account == null}">
        <li><a href="<%=request.getContextPath()%>/user/Login.jsp">Login</a></li>
        </c:if>
    <!--<a href="Login.jsp">Login</a>-->
</body>
</html>
