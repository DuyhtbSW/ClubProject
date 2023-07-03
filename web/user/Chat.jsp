<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Chat</title>
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
                <h2 class="dash-title">Chat</h2>
                <section class="recent">
                    <%--<c:if test="${comment == null}">--%>
                        <!--<h4><a href="<%=request.getContextPath()%>/user?command=SetToChat&mID=${recipientID}">Chat</a></h4>-->
                    <%--</c:if>--%>
                    <div class="activity-grid">
                        <div class="activity-card">
                            <c:if test="${warning != null}">
                                <!--<h3>No manager yet</h3>-->
                                <h3><%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></h3>
                            </c:if>
                            <div class="table-responsive">
                                <center>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>${recipientName}</th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="pageSize" value="5" />
                                            <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                                            <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                                            <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                                            <c:forEach var="c" items="${chat}" begin="${startIndex}" end="${endIndex}">
                                                <tr>
                                                    <c:if test="${c.senderID != senderID}">
                                                        <td>
                                                            <h2>${c.content}</h2>
                                                            <h6>${c.date}</h6>
                                                        </td>
                                                    </c:if>
                                                    <td></td>
                                                    <td></td>
                                                    <c:if test="${c.senderID == senderID}">
                                                        <td>
                                                            <h2>${c.content}</h2>
                                                            <h6>${c.date}</h6>
                                                        </td>
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
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=1"><<</a>
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${previousPage}"><</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=1"><<</a>
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${currentPage}"><</a>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                                        <c:choose>
                                            <c:when test="${page == currentPage}">
                                                <b>${page}</b>
                                            </c:when>
                                            <c:otherwise>
                                                <!--<a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${page}">${page}</a>-->
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:choose>
                                        <c:when test="${currentPage < totalPages}">
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${nextPage}">></a>
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${totalPagess + 1}">>></a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${currentPage}">></a>
                                            <a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}&page=${totalPagess + 1}">>></a>
                                        </c:otherwise>
                                    </c:choose>
                                </center>
                            </div>
                        </div>
                    </div><br>
                    <form id="chatForm" action="<%=request.getContextPath()%>/user">
                        <input type="hidden" name="command" value="Chat">
                        <input type="hidden" name="mID" value="${recipientID}">
                        <table>
                            <tr>
                                <td><textarea id="chatInput" rows="3" cols="100" placeholder="Enter a chat here..." name="chat"></textarea></td>
                                <td><input type="submit" value="Send"/></td>
                                <td><a href="<%=request.getContextPath()%>/user?command=LoadChat&mID=${recipientID}">Cancel</a></td>
                            </tr>
                        </table>
                    </form>
                    <script>
                        document.getElementById("chatInput").addEventListener("keydown", function (event) {
                            if (event.keyCode === 13) { // Kiểm tra phím Enter
                                event.preventDefault(); // Ngăn chặn hành động mặc định của phím Enter
                                document.getElementById("chatForm").submit(); // Gửi form
                            }
                        });
                    </script>
                </section>
            </main>
        </div>
    </body>
</html>