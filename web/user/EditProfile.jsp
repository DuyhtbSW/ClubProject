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
        <form action="<%=request.getContextPath()%>/user" method="get">
            <input type="hidden" name="command" value="EditProfile">
            <table border="1" width="200">
                <tr><td>Name:</td><td><input type="text" name="name" value="${user.name}"></td></tr>
                <tr><td>Email:</td><td><input type="email" name="email" value="${user.email}"></td></tr>
                <tr><td>Phone:</td><td><input type="text" name="phone" value="${user.phone}"></td></tr>
                <tr><td>Gender:</td><td><input type="text" name="gender" value="${user.gender}"></td></tr>
                <tr><td>Date of birth:</td><td><input type="text" name="dob" value="${user.DOB}"></td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user/Home.jsp">Home</a></td><td><input type="submit" name="save" value="Save"/><a href="user?command=LoadProfile">Cancel</a><br>
                        <%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></td></tr>
            </table>
        </form>
    </center>
</body>
</html>