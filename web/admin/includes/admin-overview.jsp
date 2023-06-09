<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.Admin.ClubDao" %>
<%@ page import="dao.Admin.MemberDao" %>
<%@ page import="dao.Admin.UserDao" %>

<!DOCTYPE html>
<div class="overview">
    <h2 class="dash-title">Overview</h2>

    <div class="dash-cards">

        <div class="card-single">
            <div class="card-body">
                <span class="ti-reload"></span>
                <div>
                    <h5>Users</h5>
                    <h4><%= UserDao.countUser() %></h4>
                </div>
            </div>
            <div class="card-footer">
                <a href="<%=request.getContextPath()%>/UserControllerServlet">View all</a>
            </div>
        </div>

        <div class="card-single">
            <div class="card-body">
                <span class="ti-check-box"></span>
                <div>
                    <h5>Members</h5>
                    <h4><c:out value="<%= MemberDao.countMember() %>" /></h4>
                </div>
            </div>
            <div class="card-footer">
                <a href="<%=request.getContextPath()%>/MemberControllerServlet">View all</a>
            </div>
        </div>
                
        <div class="card-single">
            <div class="card-body">
                <span class="ti-briefcase"></span>
                <div>
                    <h5>Clubs</h5>
                    <h4><%= ClubDao.countClub()%></h4>
                </div>
            </div>
            <div class="card-footer">
                <a href="<%=request.getContextPath()%>/ClubControllerServlet">View all</a>
            </div>
        </div>
    </div>
</div>
