<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>View Comment</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            th, td {
                text-align: center;
            }

            textarea {
                resize: none;
            }

            #center2 {
                padding-left: 11%;
            }

            #center3 {
                padding-left: 7%;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">View Comment</h2>
                <section class="recent">
                    <c:if test="${comment == null}">
                        <h4><a href="<%=request.getContextPath()%>/user?command=SetToComment&pID=${postID}">Comment</a></h4>
                    </c:if>
                    <div class="activity-grid">
                        <div class="activity-card">
                            <c:if test="${warning != null}">
                                <!--<h3>No manager yet</h3>-->
                                <h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>
                            </c:if>
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Poster</th>
                                            <th>Post Date</th>
                                            <th>Title</th>
                                            <th>Description</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${post.memberID}</td>
                                            <td>${post.date}</td>
                                            <td>${post.title}</td>
                                            <td>${post.description}</td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=ClubPost">Back</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <br>
                            <div class="table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Commenter</th>
                                            <th>Comment Date</th>
                                            <th>Content</th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="pc" items="${postComment}">
                                            <c:if test="${thisComment.ID == pc.ID}">
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <td>${pc.commentorID}</td>
                                                        <td>${pc.date}</td>
                                                        <td>${pc.content}</td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=LoadEditComment&pID=${postID}&pcID=${pc.ID}">Edit</a>
                                                        </td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${pc.ID}">Remove</a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <thead>
                                            <form action="<%=request.getContextPath()%>/user">
                                                <input type="hidden" name="command" value="EditComment">
                                                <input type="hidden" name="pID" value="${postID}">
                                                <table>
                                                    <tr>
                                                        <td><textarea rows="3" cols="100" placeholder="Type a comment here..." name="comment">${thisComment.content}</textarea></td>
                                                        <td><input type="submit" value="Save"/></td>
                                                        <td><a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}">Cancel</a></td>
                                                    </tr>
                                                </table>
                                            </form>
                                            </thead>
                                        </c:if>

                                        <c:if test="${thisComment.ID != pc.ID}">
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <td id="center1">${pc.commentorID}</td>
                                                        <td id="center2">${pc.date}</td>
                                                        <td id="center3">${pc.content}</td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=LoadEditComment&pID=${postID}&pcID=${pc.ID}">Edit</a>
                                                        </td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${pc.ID}">Remove</a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div><br>
                    <c:if test="${comment != null}">
                        <form action="<%=request.getContextPath()%>/user">
                            <input type="hidden" name="command" value="Comment">
                            <input type="hidden" name="pID" value="${postID}">
                            <table>
                                <tr>
                                    <td><textarea rows="3" cols="100" placeholder="Type a comment here..." name="comment"></textarea></td>
                                    <td><input type="submit" value="Send"/></td>
                                    <td><a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}">Cancel</a></td>
                                </tr>
                            </table>
                        </form>
                    </c:if>
                </section>
            </main>
        </div>
    </body>
</html>
s