<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:if test="${next == null}">
            <h1>Registration</h1>
        </c:if>
        <c:if test="${next != null}">
            <h1>Register Account</h1>
        </c:if>
        <c:if test="${next == null}">
            <form action="<%=request.getContextPath()%>/user" method="get">
                <input type="hidden" name="command" value="Register">
                <table border="1" width="200">
                    <tr><td>Email:</td><td><input type="email" name="acc" value="${Acc}"></td></tr>
                    <tr><td>Password:</td><td><input type="password" name="pass" value=""></td></tr>
                    <tr><td>Repassword:</td><td><input type="password" name="repass" value=""></td></tr>
                    <tr><td><a href="<%=request.getContextPath()%>/user?command=rLogin">Login</a></td><td><input type="submit" value="Register"/><br>
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
        </c:if>
        <c:if test="${next != null}">
            <form action="<%=request.getContextPath()%>/user" method="get">
                <input type="hidden" name="command" value="RegisterAccount">
                <table border="1" width="200">
                    <tr><td>OTP:</td><td><input type="text" name="otp" value="" placeholder="Enter OTP"></td></tr>
                    <tr><td><a href="<%=request.getContextPath()%>/user?command=Regist">Back</a></td><td><input type="submit" value="Next"/><br>
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
        </c:if>
    </center>
</body>
</html>
