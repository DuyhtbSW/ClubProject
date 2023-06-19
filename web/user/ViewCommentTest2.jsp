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
                                            <th>Date</th>
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
                                            <th>Date</th>
                                            <th>Content</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%--<c:forEach var="pc" items="${postComment}">--%>

                                        <c:forEach var="mc" items="${myComments}">
                                            <tr>
                                                <c:if test="${thisComment.ID == mc.ID}">
                                                    <td>${mc.commentorID}</td>
                                                    <td>${mc.date}</td>
                                                    <td>
                                                        <form action="user" method="get">
                                                            <input type="hidden" name="command" value="EditComment">
                                                            <!--<input type="hidden" name="comment" value="${comment}">-->
                                                            <input type="hidden" name="pID" value="${postID}">
                                                            <input type="hidden" name="pcID" value="${mc.ID}">
                                                            <c:if test="${comments == null}">
                                                                <textarea rows="2" cols="30" placeholder="Type a comment here..." name="comment">${thisComment.content}</textarea>
                                                            </c:if>
                                                            <c:if test="${comments != null}">
                                                                <textarea rows="2" cols="30" placeholder="Type a comment here..." name="comment"></textarea>
                                                            </c:if>
                                                            <td>
                                                                <input type="submit" value="Save">
                                                            </td>
                                                        </form>
                                                    </td>
                                                    <!--<td>-->
                                                        <!--<a type="submit" href="<%=request.getContextPath()%>/user?command=EditComment&comment=${content}&pID=${postID}&pcID=${pc.ID}">Save</a>-->
                                                        <!--<a type="submit" href="<%=request.getContextPath()%>/${user}&pID=${postID}&pcID=${pc.ID}">Save</a>-->
                                                    <!--</td>-->
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}">Cancel</a>
                                                    </td>
                                                </c:if>
                                                <c:if test="${thisComment.ID != mc.ID}">
                                                    <td>${mc.commentorID}</td>
                                                    <td>${mc.date}</td>
                                                    <td>${mc.content}</td>
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/user?command=LoadEditComment&pID=${postID}&pcID=${mc.ID}">Edit</a>
                                                    </td>
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${mc.ID}">Remove</a>
                                                    </td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                        <c:if test="${thisComment.ID != pc.ID && sessionScope.IsCreator != null}">
<!--                                                    <td>${pc.commentorID}</td>
                                            <td>${pc.date}</td>
                                            <td>${pc.content}</td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${pc.ID}">Remove</a>
                                            </td>-->
                                        </c:if>
                                        <c:if test="${thisComment.ID != pc.ID && sessionScope.IsManager != null}">
<!--                                                    <td>${pc.commentorID}</td>
                                            <td>${pc.date}</td>
                                            <td>${pc.content}</td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${pc.ID}">Remove</a>
                                            </td>-->
                                        </c:if>
                                        <c:if test="${thisComment.ID != pc.ID && sessionScope.IsMember != null}">
<!--                                                    <td>${pc.commentorID}</td>
                                            <td>${pc.date}</td>
                                            <td>${pc.content}</td>-->
                                        </c:if>
                                        <c:if test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                                            <c:forEach var="nmc" items="${notMyComments}">
                                                <tr>
                                                    <td>${nmc.commentorID}</td>
                                                    <td>${nmc.date}</td>
                                                    <td>${nmc.content}</td>
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${nmc.ID}">Remove</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${sessionScope.IsMember != null}">
                                            <c:forEach var="nmc" items="${notMyComments}">
                                                <tr>
                                                    <td>${nmc.commentorID}</td>
                                                    <td>${nmc.date}</td>
                                                    <td>${nmc.content}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <%--</c:forEach>--%>
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
