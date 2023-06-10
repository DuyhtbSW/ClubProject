<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Registration</h1>
        <form action="<%=request.getContextPath()%>/user" method="get">
            <input type="hidden" name="command" value="Register">
            <table border="1" width="200">
                <tr><td>Email:</td><td><input type="email" name="acc" value="${Acc}"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass" value=""></td></tr>
                <tr><td>Repassword:</td><td><input type="password" name="repass" value=""></td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user/Login.jsp">Login</a></td><td><input type="submit" value="Register"/><br>
                        <%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></td></tr>
            </table>
        </form>
    </center>
</body>
</html>
