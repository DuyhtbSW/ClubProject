<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Edit Post</title>
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
                <h2 class="dash-title">Edit Post</h2>
                <section class="recent">
                    <div class="activity-grid">
                        <div class="activity-card">
                            <c:if test="${warning != null}">
                                <h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>
                            </c:if>
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Title</th>
                                            <th>Description</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <form action="<%=request.getContextPath()%>/user" method="get">
                                        <input type="hidden" name="command" value="EditPost">
                                        <input type="hidden" name="pID" value="${postID}">
                                        <tr>
                                            <td><textarea rows="3" cols="27" name="title">${post.title}</textarea></td>
                                            <td><textarea rows="3" cols="30" name="description">${post.description}</textarea></td>
                                            <td>
                                                <input type="submit" value="Save"/>
                                            </td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=PostManage&pID=${postID}">Cancel</a>
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
