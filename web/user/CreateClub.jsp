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
        <form action="<%=request.getContextPath()%>/user" method="get">
            <input type="hidden" name="command" value="CreateClub">
            <table border="1" width="200">
                <tr><td>Club Code:</td><td><input type="text" name="cCode" value=""></td></tr>
                <tr><td>Club Name:</td><td><textarea rows="2" cols="21" name="cName"></textarea></td></tr>
                <tr><td>Club Description:</td><td><textarea rows="6" cols="21" name="cDescription"></textarea></td></tr>
                <tr><td><a href="<%=request.getContextPath()%>/user?command=ClubsList">Back</a></td><td><input type="submit" value="Create"/><br>
                        <%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></td></tr>
            </table>
        </form>
    </center>
</body>
</html>
