<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Change Password</h1>
        <form action="<%=request.getContextPath()%>/user" method="get">
            <input type="hidden" name="command" value="ChangePass">
            <table border="1" width="309">
                <tr><td>Current Password:</td><td><input type="text" name="crPass" value=""></td></tr>
                <tr><td>New Password:</td><td><input type="text" name="nPass" value=""></td></tr>
                <tr><td>Confirm Password:</td><td><input type="text" name="cfPass" value=""></td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user?command=LoadProfile">Back</a></td><td><input type="submit" value="Change"/><br><a href="<%=request.getContextPath()%>/user?command=rForgotPass&fr=FCP">Forgot password?</a>
                        <br>
                        <%--<%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%>--%>
                        <%
                            String warning = (String) request.getSession().getAttribute("warning");
                            if (warning != null && !warning.isEmpty()) {
                        %>
                        <div class="warning-message">
                            <%=warning%>
                        </div>
                        <%
                            // Xóa thông báo sau khi hiển thị
                            request.getSession().removeAttribute("warning");
                        }
                        %></td></tr>
            </table>
        </form>
    </center>
</body>
</html>
