<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" href="style/admin-login.css"/>
    </head>
    <body>s
        <h1>Login page</h1>
        <form action="<%=request.getContextPath()%>/AdminControllerServlet" method="GET" onsubmit = " return validateLogin()">
            <input type="hidden" name="command" value="LOGIN">
            <p id="error">${loginFail}</p>
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
