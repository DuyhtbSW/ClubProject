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
            <li>
                <a href="<%=request.getContextPath()%>/user?command=Home">
                    <span class="ti-home"></span>
                    <span>Home</span>
                </a>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList">
                    <span class="ti-unlink"></span>
                    <span>Clubs List</span>
                </a>
            </li>
            <c:if test="${sessionScope.clubCreator != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=ForCreator">
                        <span class="ti-layout-grid2-thumb"></span>
                        <span>Club Manager<h6>for Creator</h6></span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.clubManager != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=ForManager">
                        <span class="ti-layout-grid2-thumb"></span>
                        <span>Club Manager<h6>for Manager</h6></span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.clubMember != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=ForMember">
                        <span class="ti-layout-grid2-thumb"></span>
                        <span>My Club</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=LoadProfile">
                        <span class="ti-face-smile"></span>
                        <span>Hello ${sessionScope.account.name}</span>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/user?command=Logout">
                        <span class="ti-comments-smiley"></span>
                        <span>Logout</span>
                    </a>
                </li>
            </c:if>

            <!--            <li>
                            <a href="<%=request.getContextPath()%>/user?command=ClubPost">
                                <span class="ti-layout-list-thumb-alt"></span>
                                <span>Post</span>
                            </a>
                        </li>-->
            <c:if test="${sessionScope.account == null}">
                <li>
                    <a href="<%=request.getContextPath()%>/user/Login.jsp">
                        <span class="ti-gallery"></span>
                        <span>Login</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
