<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="user/style/Club.css"/>
<!DOCTYPE html>
<div class="sidebar">
    <div class="sidebar-header">
        <h3 class="brand">
            <span class="ti-unlink"></span> 
            <span>Club of FPT University</span>
        </h3> 
        <label for="sidebar-toggle" class="ti-menu-alt"></label>
    </div>

    <div class="sidebar-menu">
        <ul>
            <li>
                <a href="<%=request.getContextPath()%>/user/Home.jsp">
                    <span class="ti-home"></span>
                    <span>Home</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user/ClubHome.jsp">
                    <span class="ti-unlink"></span>
                    <span>Overview</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubManage">
                <!--<a href="<%=request.getContextPath()%>/ClubManage.jsp">-->
                    <span class="ti-layout-grid2-thumb"></span>
                    <span>Club Manage</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubManager">
                <!--<a href="<%=request.getContextPath()%>/ClubManager.jsp">-->
                    <span class="ti-face-smile"></span>
                    <span>Managers</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubMember">
                <!--<a href="<%=request.getContextPath()%>/ClubMember.jsp">-->
                    <span class="ti-comments-smiley"></span>
                    <span>Members</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubPost">
                <!--<a href="<%=request.getContextPath()%>/ClubPost.jsp">-->
                    <span class="ti-layout-list-thumb-alt"></span>
                    <span>Post</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user/ClubEvent.jsp">
                    <span class="ti-gallery"></span>
                    <span>Event</span>
                </a>
            </li>
        </ul>
    </div>
</div>
