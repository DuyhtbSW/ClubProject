<%-- 
    Document   : club-detail
    Created on : May 24, 2023, 2:07:30 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<section>
    <h3>Club detail</h3>
<Table>
    <TR><TH>Club ID</TH><TH>Club Name</TH><TH>Description</TH><TH>Creator ID</TH><TH>Created Date</TH><TH>Action</TH>
    <c:forEach items="${club}" var="b"> 
    <TR><TD>${b.clubID}</TD><TD>${b.clubName}</TD><TD>${b.clubDescription}</TD><TD>${b.creatorId}</TD><TD>${b.dateCreated}</TD><TH>Remove|Edit</TH>
    </c:forEach>
</table>    

</section>
