<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                                            <th></th>
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
                                            <td><img src="images/${post.img}" width="80" height="50" alt="image"/></td>
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
                                <center>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Commenter</th>
                                                <th>Comment Date</th>
                                                <th>Content</th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="pageSize" value="5" />
                                            <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                                            <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                                            <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                                            <c:forEach var="pc" items="${postComment}" begin="${startIndex}" end="${endIndex}">
                                                <tr>
                                                    <c:if test="${thisComment.ID == pc.ID}">
                                                        <td>${pc.postID}</td>
                                                        <td>${pc.date}</td>
                                                        <td>
                                                            <form id="editCommentForm" action="<%=request.getContextPath()%>/user" method="get">
                                                                <input type="hidden" name="command" value="EditComment">
                                                                <!--<input type="hidden" name="comment" value="${comment}">-->
                                                                <input type="hidden" name="pID" value="${postID}">
                                                                <input type="hidden" name="pcID" value="${pc.ID}">
                                                                <c:if test="${comments == null}">
                                                                    <textarea id="editCommentInput" rows="2" cols="30" placeholder="Type a comment here..." name="comment">${thisComment.content}</textarea>
                                                                </c:if>
                                                                <c:if test="${comments != null}">
                                                                    <textarea id="editCommentInput" rows="2" cols="30" placeholder="Type a comment here..." name="comment"></textarea>
                                                                </c:if>
                                                                <td>
                                                                    <input type="submit" value="Save">
                                                                </td>
                                                            </form>
                                                        </td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}">Cancel</a>
                                                        </td>
                                                <script>
                                                    document.getElementById("editCommentInput").addEventListener("keydown", function (event) {
                                                        if (event.keyCode === 13) { // Kiểm tra phím Enter
                                                            event.preventDefault(); // Ngăn chặn hành động mặc định của phím Enter
                                                            document.getElementById("editCommentForm").submit(); // Gửi form
                                                        }
                                                    });
                                                </script>
                                            </c:if>
                                            <c:if test="${thisComment.ID != pc.ID}">
                                                <c:choose>
                                                    <c:when test="${pc.commentorID == commenterID}">
                                                        <td>${pc.postID}</td>
                                                        <td>${pc.date}</td>
                                                        <td>${pc.content}</td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=LoadEditComment&pID=${postID}&pcID=${pc.ID}">Edit</a>
                                                        </td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${pc.ID}&cmtID=${pc.commentorID}">Remove</a>
                                                        </td>
                                                    </c:when>
                                                    <c:when test="${sessionScope.IsCreator != null || sessionScope.IsManager != null}">
                                                        <td>${pc.postID}</td>
                                                        <td>${pc.date}</td>
                                                        <td>${pc.content}</td>
                                                        <td></td>
                                                        <td>
                                                            <a href="<%=request.getContextPath()%>/user?command=DeleteComment&pID=${postID}&pcID=${pc.ID}&cmtID=${pc.commentorID}">Remove</a>
                                                        </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>${pc.postID}</td>
                                                        <td>${pc.date}</td>
                                                        <td>${pc.content}</td>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:if>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table><br>
                                    <c:set var="totalPages" value="${postComments div pageSize}" />
                                    <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
                                    <c:set var="previousPage" value="${currentPage - 1}" />
                                    <c:set var="nextPage" value="${currentPage + 1}" />

                                    <c:choose>
                                        <c:when test="${currentPage > 1}">
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=1"><<</a>
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${previousPage}"><</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=1"><<</a>
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${currentPage}"><</a>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                                        <c:choose>
                                            <c:when test="${page == currentPage}">
                                                <b>${page}</b>
                                            </c:when>
                                            <c:otherwise>
                                                <!--<a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${page}">${page}</a>-->
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:choose>
                                        <c:when test="${currentPage < totalPages}">
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${nextPage}">></a>
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${totalPagess + 1}">>></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${currentPage}">></a>
                                            <a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}&page=${totalPagess + 1}">>></a>
                                        </c:otherwise>
                                    </c:choose>
                                </center>
                            </div>
                        </div>
                    </div><br>
                    <c:if test="${comment != null}">
                        <form id="commentForm" action="<%=request.getContextPath()%>/user">
                            <input type="hidden" name="command" value="Comment">
                            <input type="hidden" name="pID" value="${postID}">
                            <table>
                                <tr>
                                    <td><textarea id="commentInput" rows="3" cols="100" placeholder="Type a comment here..." name="comment"></textarea></td>
                                    <td><input type="submit" value="Send"/></td>
                                    <td><a href="<%=request.getContextPath()%>/user?command=ViewComment&pID=${postID}">Cancel</a></td>
                                </tr>
                            </table>
                        </form>
                        <script>
                            document.getElementById("commentInput").addEventListener("keydown", function (event) {
                                if (event.keyCode === 13) { // Kiểm tra phím Enter
                                    event.preventDefault(); // Ngăn chặn hành động mặc định của phím Enter
                                    document.getElementById("commentForm").submit(); // Gửi form
                                }
                            });
                        </script>
                    </c:if>
                </section>
            </main>
        </div>
    </body>
</html>