<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Edit Profile</h1>
        <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
            <!--<input type="hidden" name="command" value="EditProfile">-->
            <table border="1" width="300">
                <tr><td>Image:</td><td><img src="images/${user.img}" width="200" height="150"/><input type="file" name="image"></td></tr>
                <tr><td>Name:</td><td><input type="text" name="name" value="${user.name}" placeholder="Enter name"></td></tr>
                <tr><td>Email:</td><td><input type="email" name="email" value="${user.email}" placeholder="Enter email"></td></tr>
                <tr><td>Phone:</td><td><input type="text" name="phone" value="${user.phone}" placeholder="Enter phone Ex: 0[35789]12345678"></td></tr>
                <tr><td>Gender:</td><td><input type="text" name="gender" value="${user.gender}" placeholder="Enter gender Ex: 'Male' 'Female' 'Other'"></td></tr>
                <tr><td>Date of birth:</td><td><input type="text" name="" value="${user.DOB}" placeholder="Enter dob Ex: 01/01/1999" readonly=""><br>
                        <input type="date" name="dob" value="${user.DOB}" placeholder="Enter dob Ex: 01/01/1999"></td></tr>
                <tr><td></td><td><input type="submit" name="save" value="Save"/><a href="user?command=LoadProfile">Cancel</a><br>
                <!--<tr><td><a href="<%=request.getContextPath()%>/user?command=Home">Home</a></td><td><input type="submit" name="save" value="Save"/><a href="user?command=LoadProfile">Cancel</a><br>-->
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
