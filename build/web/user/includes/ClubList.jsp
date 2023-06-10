<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="activity-card">
<!--    <h3>Club Manage</h3>-->
    <div class="table-responsive">
        <table>
            <thead>
                <tr>
                    <th>Club Code</th>
                    <th>Club Name</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${club.code}</td>
                    <td>${club.name}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/user?command=ViewClubDetails">View detail</a>
                    </td>
                    <td>
                        <a href="#">Join club request</a>
                    </td>
                    <td>
                        <a href="#">Remove</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>