<%-- 
    Document   : notification
    Created on : Jun 15, 2023, 4:29:26 PM
    Author     : acer
--%>

<div class="activity-card">
    <form action="ClubControllerServlet" method="GET">
        <div class="table-responsive">
            <table border="1">
                <tbody>
                    <tr>
                        <th>Club ID</th><td>${item.clubId}</td>
                    <tr>    
                        <th>Club Name</th><td>${item.clubName}</td>
                    <tr>    
                        <th>Club Description</th><td>${item.clubDescription}</td>
                    <tr>    
                        <th>Manager</th><td>${item.clubCreatorId}</td>
                    <tr>    
                        <th>Date Created</th><td>${item.dateCreated}</td>
                    <tr>    
                        <th></th>
                    <tr>   
                        <th></th>
                </tbody>
            </table>
        </div>
    </form>
</div>
