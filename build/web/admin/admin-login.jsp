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
        <title>Admin | Login</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/admin/style/admin-login.css"/>
    </head>
    <body>
        <h1>Login page</h1>
        <form action="<%=request.getContextPath()%>/AdminControllerServlet" method="GET" onsubmit = " return validateLogin()">
            <input type="hidden" name="command" value="LOGIN">
            <div class="form-group">
                <label for="username">Email</label>
                <input type="text" id="username" name="username"><span style="color: red;">*</span>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" ><span  style="color: red;">*</span>
            </div>
            <p id="error" style="color: red; font-style: italic;">${loginFail}</p>
            <button type="submit">Login</button>
        </form>
    </body>
    <script>
        function validateLogin() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            if (username && password) {
                return true;
            } else {
                alert("Please fill in both fields!");
                return false;
            }
        }
    </script>
</html>
