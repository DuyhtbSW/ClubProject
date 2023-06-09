<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <c:if test="${sessionScope.IsCreator != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=IsCreator&cID=${clubID}&cCID=${clubCreatorID}">
                        <span class="ti-home"></span>
                        <span>Overview</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.IsManager != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=IsManager&cID=${clubID}&cCID=${clubCreatorID}">
                        <span class="ti-home"></span>
                        <span>Overview</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.IsMember != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=IsMember&cID=${clubID}&cCID=${clubCreatorID}">
                        <span class="ti-home"></span>
                        <span>Overview</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManage">
                        <span class="ti-layout-grid2-thumb"></span>
                        <span>Club Manage</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.IsMember != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=ClubManage">
                        <span class="ti-layout-grid2-thumb"></span>
                        <span>Club Info</span>
                    </a>
                </li>
            </c:if>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubManager">
                    <span class="ti-face-smile"></span>
                    <span>Managers</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubMember">
                    <span class="ti-comments-smiley"></span>
                    <span>Members</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubPost">
                    <span class="ti-layout-list-thumb-alt"></span>
                    <span>Post</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubEvent">
                    <span class="ti-gallery"></span>
                    <span>Event</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubRating">
                    <span class="ti-check-box"></span>
                    <span>Rating</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ExitClub">
                    <span class="ti-unlink"></span>
                    <span>Exit</span>
                </a>
            </li>
        </ul>
    </div>
</div>
