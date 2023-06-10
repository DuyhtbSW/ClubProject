<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Login</h1>
        <form action="<%=request.getContextPath()%>/user" method="get">
            <input type="hidden" name="command" value="Login">
            <table border="1" width="200">
                <tr><td>Email:</td><td><input type="email" name="acc" value="${cAcc != null ? cAcc : ""}"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass" value="${cPass != null ? cPass : ""}"></td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user/Home.jsp">Home</a></td><td><input type="checkbox" name="remember">Remember me</td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user/Register.jsp">Register</a></td><td><input type="submit" value="Login"/><br>
                        <%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></td></tr>
            </table>
        </form>
    </center>
</body>
</html>
