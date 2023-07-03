<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Forgot Password</h1>
        <c:if test="${otp == null}">
            <c:if test="${next == null}">
                <form action="<%=request.getContextPath()%>/user" method="get">
                    <input type="hidden" name="command" value="NextForgotPass">
                    <table border="1" width="200">
                        <tr><td>Email:</td><td><input type="email" name="email" value="" placeholder="Enter email"></td></tr>
                        <tr><td><a href="<%=request.getContextPath()%>/user?command=${fr}">Back</a></td><td><input type="submit" value="Next"/><br>
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
                    <input type="hidden" name="command" value="ConfirmForgotPass">
                    <table border="1" width="200">
                        <tr><td>OTP:</td><td><input type="text" name="otp" value="" placeholder="Enter OTP"></td></tr>
                        <tr><td><a href="<%=request.getContextPath()%>/user?command=rForgotPass">Back</a></td><td><input type="submit" value="Next"/><br>
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
        </c:if>
        <c:if test="${otp != null}">
            <form action="<%=request.getContextPath()%>/user" method="get">
                <input type="hidden" name="command" value="ForgotPass">
                <table border="1" width="309">
                    <tr><td>New Password:</td><td><input type="text" name="nPass" value="" placeholder="Enter new password"></td></tr>
                    <tr><td>Confirm Password:</td><td><input type="text" name="cfPass" value="" placeholder="Confirm new password"></td></tr>
                    <tr><td><a href="<%=request.getContextPath()%>/user?command=rForgotsPass">Back</a></td><td><input type="submit" value="Change"/><br>
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

