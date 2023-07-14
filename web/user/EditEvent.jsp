<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Edit Event</title>
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
                <h2 class="dash-title">Edit Event</h2>
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
                                <form action="<%=request.getContextPath()%>/upload" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="command" value="EditEvent">
                                    <input type="hidden" name="eID" value="${eventID}">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Event Name</th>
                                                <th>Date</th>
                                                <th>Description</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <img src="images/${event.img}" width="80" height="50" alt="image"/>
                                                    <input type="file" name="image" value="">
                                                </td>
                                                <c:if test="${name == null}">
                                                    <td><textarea rows="3" cols="27" name="name">${event.name}</textarea></td>
                                                    </c:if>
                                                    <c:if test="${name != null}">
                                                    <td><textarea rows="3" cols="27" name="name"></textarea></td>
                                                    </c:if>
                                                <td>
                                                    Old day: <input type="text" name="olddate" value="${event.date}" readonly=""/><br>
                                                    New day: <br><input type="date" name="newdate"/>
                                                </td>
                                                <c:if test="${description == null}">
                                                    <td><textarea rows="3" cols="30" name="description">${event.description}</textarea></td>
                                                    </c:if>
                                                    <c:if test="${description != null}">
                                                    <td><textarea rows="3" cols="30" name="description"></textarea></td>
                                                    </c:if>
                                                <td>
                                                    <input type="submit" value="Save"/>
                                                </td>
                                                <td>
                                                    <a href="<%=request.getContextPath()%>/user?command=EventManage&eID=${eventID}">Cancel</a>
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
