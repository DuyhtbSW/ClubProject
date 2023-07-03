<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifications List</title>
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Notifications</h1>
        <form action="<%=request.getContextPath()%>/user" method="get">
            <!--<input type="hidden" name="command" value="SearchClub">-->
            <a href="<%=request.getContextPath()%>/user?command=Home">Home</a>
            <!--<a href="<%=request.getHeader("referer")%>">Back</a>-->
            <!--<input type="text" name="search" value="${search}" oninput=""><input type="submit" value="Search">-->
            <br><br>
            <table border="1" width="600">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Status / Note</th>
                        <th>Date</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="pageSize" value="5" />
                    <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                    <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                    <c:forEach var="n" items="${notification}" begin="${startIndex}" end="${endIndex}" varStatus="loop">
                        <tr>
                            <c:if test="${n.title == 'Register Success'}">
                                <td>${loop.index + 1}</td>
                                <td>${n.title}</td>   
                                <td>${n.note}</td>
                                <td>${n.date}</td>
                            </c:if>
                            <c:if test="${n.title == 'Create Club'}">
                                <td>${loop.index + 1}</td>
                                <td>${n.title}</td>   
                                <td>${n.note}</td>
                                <td>${n.date}</td>
                                <td><a href="<%=request.getContextPath()%>/user?command=ViewDetailsClubs&cID=${n.clubID}">View details</a></td>
                            </c:if>
                            <c:if test="${n.title == 'Join Club'}">
                                <td>${loop.index + 1}</td>
                                <td>${n.title}</td>   
                                <td>${n.note}</td>
                                <td>${n.date}</td>
                                <td><a href="<%=request.getContextPath()%>/user?command=ViewDetailsJoins&mID=${n.memberID}">View details</a></td>
                            </c:if>
                            <c:if test="${n.title == 'Create Post'}">
                                <td>${loop.index + 1}</td>
                                <td>${n.title}</td>   
                                <td>${n.note}</td>
                                <td>${n.date}</td>
                                <td><a href="<%=request.getContextPath()%>/user?command=ViewDetailsPosts&pID=${n.postID}">View details</a></td>
                            </c:if>
                            <c:if test="${n.title == 'Create Event'}">
                                <td>${loop.index + 1}</td>
                                <td>${n.title}</td>   
                                <td>${n.note}</td>
                                <td>${n.date}</td>
                                <td><a href="<%=request.getContextPath()%>/user?command=ViewDetailsEvents&eID=${n.eventID}">View details</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <c:set var="totalPages" value="${notifications div pageSize}" />
            <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
            <c:set var="previousPage" value="${currentPage - 1}" />
            <c:set var="nextPage" value="${currentPage + 1}" />

            <c:choose>
                <c:when test="${currentPage > 1}">
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=${previousPage}"><</a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=1"><<</a>
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=${currentPage}"><</a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                <c:choose>
                    <c:when test="${page == currentPage}">
                        <b>${page}</b>
                    </c:when>
                    <c:otherwise>
                        <!--<a href="<%=request.getContextPath()%>/user?command=Notification&page=${page}">${page}</a>-->
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${currentPage < totalPages}">
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=${nextPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=${totalPagess + 1}">>></a>
                </c:when>
                <c:otherwise>
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=${currentPage}">></a>
                    <a href="<%=request.getContextPath()%>/user?command=Notification&page=${totalPagess + 1}">>></a>
                </c:otherwise>
            </c:choose>
        </form>
    </center>
</body>
</html>
