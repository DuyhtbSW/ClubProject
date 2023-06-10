<section id="detail">
    <h3>User detail</h3>
    <form action="UserControllerServlet" method="GET">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="userId" value="${The_User.userId}">
        <table>
            <tbody>
                <tr>
                    <TH>User ID</TH><TD>${The_User.userId}</TD><TD>${The_User.userId}</TD>
                <tr>
                    <TH>User Name</TH><TD>${The_User.userName}</TD><TD> <input type="text" name="userName" value="${The_User.userName}"></TD>
                <tr>
                    <TH>User Email</TH><TD>${The_User.userEmail}</TD><TD> <input type="text" name="userEmail" value="${The_User.userEmail}"></TD>
                <tr>
                    <TH>User Password</TH><TD>${The_User.userPassword}</TD><TD> <input type="text" name="userPassword" value="${The_User.userPassword}"></TD>
                <tr>
                    <TH>User Phone</TH><TD>${The_User.userPhone}</TD><TD> <input type="text" name="userPhone" value="${The_User.userPhone}"></TD>
                <tr>
                    <TH>User DOB</TH><TD>${The_User.DOB}</TD><TD> <input type="text" name="userDOB" value="${The_User.DOB}"></TD>
                <tr>
                    <TH>User Gender</TH><TD>${The_User.userGender}</TD><TD> <input type="text" name="userGender" value="${The_User.userGender}"></TD>
                <tr>
                    <TH></TH><TH><a href="UserControllerServlet"> Back to the List</a></TH>
                    <TH>
                        <input type="submit" value="UPDATE" class="save" onclick="alert('Update success')"/>
                    </TH>
            </tbody>
        </table>    
    </form>
</section>
