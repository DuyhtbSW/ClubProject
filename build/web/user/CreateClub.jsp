<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Club</title>
        <style>
            a {
                text-decoration: none;
            }

            textarea {
                resize: none;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Create Club</h1>
        <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
            <input type="hidden" name="command" value="CreateClub">
            <table border="1" width="200">
                <tr><td>Club Image:</td><td><input type="file" name="cImg" value=""></td></tr>
                <!--<tr><td>Club Code:</td><td><input type="text" name="cCode" value=""></td></tr>-->
                <tr><td>Club Code:</td><td><textarea rows="2" cols="35" name="cCode"></textarea></td></tr>
                <tr><td>Club Name:</td><td><textarea rows="2" cols="35" name="cName"></textarea></td></tr>
                <tr><td>Club Description:</td><td><textarea rows="6" cols="35" name="cDescription"></textarea></td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user?command=ClubsList">Back</a></td><td><input type="submit" value="Create"/><br>
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
