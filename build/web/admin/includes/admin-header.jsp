<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="admin/style/style-admin-homepage.css"/>
<!DOCTYPE html>
<header>
    <form action="<%=request.getContextPath()%>/ClubControllerServlet" method="GET">
        <input type="hidden" name="command" value="SEARCH">
        <div class="search-wrapper">
            <span class="ti-search"></span>
            <input name="searchTerm" type="search" placeholder="Search Club" >
        </div>
    </form>
    <div class="social-icons">
        <span class="ti-bell"></span>
        <span class="ti-comment"></span>
        <div></div>
    </div>
</header>