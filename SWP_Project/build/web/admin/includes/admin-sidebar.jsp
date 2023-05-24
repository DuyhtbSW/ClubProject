<%-- 
    Document   : admin-sidebar
    Created on : May 23, 2023, 2:02:35 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <a href="<%=request.getContextPath()%>/admin/admin-club.jsp">
                            <span class="ti-home"></span>
                            <span>Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/admin-manager.jsp">
                            <span class="ti-face-smile"></span>
                            <span>Managers</span>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/admin-club.jsp">
                            <span class="ti-layout-grid2-thumb"></span>
                            <span>Clubs</span>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/admin-member.jsp">
                            <span class="ti-comments-smiley"></span>
                            <span>Members</span>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/admin-post.jsp">
                            <span class="ti-layout-list-thumb-alt"></span>
                            <span>Post</span>
                        </a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin/admin-event.jsp">
                            <span class="ti-gallery"></span>
                            <span>Event</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
