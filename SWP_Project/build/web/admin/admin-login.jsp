<%-- 
    Document   : admin-login
    Created on : May 23, 2023, 11:51:42 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="admin-login.css"/>
    </head>
    <body>
        <h1>Login page</h1>
        <p id="error">${loginFail}</p>
        <!--        <form action="AdminControllerServlet" method="GET" onsubmit = "return validateLogin()">-->
        <form action="admin-homepage.jsp" method="GET" onsubmit = "return validateLogin()">
            <!--<input type="hidden" name="command" value="LOGIN">-->
            <div class="form-group">
                <label for="username">Admin ID<span>*</span></label>
                <input type="text" id="username" name="username">
            </div>
            <div class="form-group">
                <label for="password">Password<span>*</span></label>
                <input type="password" id="password" name="password" >
            </div>
            <button type="submit">Login</button>
        </form>

    </body>
</html>
