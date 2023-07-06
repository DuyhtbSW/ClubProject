<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="admin/style/style-admin-homepage.css"/>
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
                <a href="<%=request.getContextPath()%>/AdminControllerServlet">
                    <span class="ti-home"></span>
                    <span>Home</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/UserControllerServlet">
                    <span class="ti-face-smile"></span>
                    <span>User</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/MemberControllerServlet">
                    <span class="ti-comments-smiley"></span>
                    <span>Members</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/ClubControllerServlet">
                    <span class="ti-layout-grid2-thumb"></span>
                    <span>Clubs</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span class="ti-layout-list-thumb-alt"></span>
                    <span>Post * Admin Don't Care</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/EventControllerServlet">
                    <span class="ti-gallery"></span>
                    <span>Event</span>
                </a>
            </li>
        </ul>
    </div>
</div>
