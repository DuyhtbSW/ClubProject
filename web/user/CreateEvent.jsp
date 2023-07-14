<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Create Event</title>
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
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Create Event</h2>
                <section class="recent">
                    <h4><a href="<%=request.getContextPath()%>/user?command=ClubEvent">Back</a></h4>
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
                                <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="command" value="CreateEvent">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Image</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Date</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><input type="file" name="image" value=""></td>
                                                <td><textarea rows="3" cols="27" name="name"></textarea></td>
                                                <td><textarea rows="3" cols="30" name="description"></textarea></td>
                                                <td><input type="date" name="date"></td>
                                                <td>
                                                    <input type="submit" value="Create"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>
