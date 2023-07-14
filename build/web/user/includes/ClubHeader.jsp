<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="user/style/Club.css"/>
<!DOCTYPE html>
<header>
    <div class="search-wrapper">
        <span class="ti-search"></span>
        <input type="search" placeholder="Search">
    </div>

    <div class="social-icons">
        <a href="<%=request.getContextPath()%>/user?command=Notification">
            <span class="ti-bell"></span>
        </a>
        <div>1</div>
        <!--<span class="ti-comment"></span>-->
    </div>
</header>