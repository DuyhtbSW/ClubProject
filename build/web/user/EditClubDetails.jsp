<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Edit Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
            }

            th, td {
                text-align: center;
            }

            textarea {
                resize: none;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Edit Club</h2>
                <section class="recent">
                    <div class="activity-grid">
                        <div class="activity-card">
                            <c:if test="${warning != null}">
                                <!--<h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>-->
                                <%
                                    String warning = (String) request.getSession().getAttribute("warning");
                                    if (warning != null && !warning.isEmpty()) {
                                %>
                                <div class="warning-message">
                                    <h3><%=warning%></h3>
                                </div>
                                <%
                                    // Xóa thông báo sau khi hiển thị
                                    request.getSession().removeAttribute("warning");
                                }
                                %>
                            </c:if>
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Club Code</th>
                                            <th>Club Name</th>
                                            <th>Club Description</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <form action="<%=request.getContextPath()%>/user" method="get">
                                        <input type="hidden" name="command" value="EditClub">
                                        <tr>
                                            <c:if test="${code == null}">
                                                <td><input type="text" name="code" value="${club.code}"></td>
                                                </c:if>
                                                <c:if test="${code != null}">
                                                <td><input type="text" name="code" value=""></td>
                                                </c:if>
                                                <c:if test="${name == null}">
                                                <td><textarea rows="2" cols="25" name="name">${club.name}</textarea></td>
                                                </c:if>
                                                <c:if test="${name != null}">
                                                <td><textarea rows="2" cols="25" name="name"></textarea></td>
                                                </c:if>
                                                <c:if test="${description == null}">
                                                <td><textarea rows="4" cols="27" name="description">${club.description}</textarea></td>
                                                </c:if>
                                                <c:if test="${description != null}">
                                                <td><textarea rows="4" cols="27" name="description"></textarea></td>
                                                </c:if>
                                            <td>
                                                <input type="submit" name="save" value="Save"/>
                                            </td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=ViewClubDetails">Cancel</a>
                                            </td>
                                        </tr>
                                    </form>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>
