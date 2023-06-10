<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Club Details</title>
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head> 
    <body>
    <center>
        <h1>Club Details</h1>
        <form action="user" method="get">
            <input type="hidden" name="command" value="JoinClub">
            <input type="hidden" name="clubID" value="${club.ID}">
            <input type="hidden" name="clubCreatorID" value="${club.creatorID}">
            <table border="1" width="300">
                <tr><td>Club Code:</td><td><input type="text" name="" value="${club.code}" readonly=""></td></tr>
                <tr><td>Club Name:</td><td><textarea rows="2" cols="21" readonly="">${club.name}</textarea></td></tr>
                <!--<tr><td>Club Name:</td><td><input type="text" name="" value="${club.name}"></td></tr>-->
                <tr><td>Club Description:</td><td><textarea rows="6" cols="21" readonly="">${club.description}</textarea></td></tr>
                <!--<tr><td>Club Name:</td><td><input type="text" name="" value="${club.name}"></td></tr>-->
                <tr><td>Club Creator:</td><td><input type="text" name="" value="${clubCreatorName}" readonly=""></td></tr>
                <tr><td>Date Created:</td><td><input type="text" name="" value="${club.dateCreated}" readonly=""></td></tr>
                <tr><td><a href="user?command=ClubsList">Back</a></td><td><input type="submit" value="Join"/><br>
                        <%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></td></tr>
            </table>
        </form>
    </center>
</body>
</html>
