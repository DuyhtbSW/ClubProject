<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clubs List</title>
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
        <h1>Clubs</h1>
        <form action="user" method="get">
            <input type="hidden" name="command" value="Profile">
            <a href="<%=request.getContextPath()%>/user?command=Home">Home</a>
            <c:if test="${sessionScope.account != null}">
                <a href="user/CreateClub.jsp">Create Club</a>
            </c:if><br><br>
            <table border="1" width="700">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Club Code</th>
                        <th>Club Name</th>
                        <th>Club Founding Date</th>
                        <th>Club Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="pageSize" value="5" />
                    <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                    <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                    <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                    <c:forEach var="c" items="${club}" begin="${startIndex}" end="${endIndex}">
                        <!--<input type="hidden" name="cCreatorID" value="${c.creatorID}">-->
                        <tr>
                            <td>${c.ID}</td>
                            <td>${c.code}</td>   
                            <td>${c.name}</td>
                            <td>${c.dateCreated}</td>
                            <c:if test="${c.joinRequest == 0}">
                                <td>Public</td>
                            </c:if>
                            <c:if test="${c.joinRequest == 1}">
                                <td>Private</td>
                            </c:if>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=ViewDetailsClub&cID=${c.ID}&cCreatorID=${c.creatorID}">View Details</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form><br>
        <c:set var="totalPages" value="${clubs div pageSize}" />
        <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
        <c:set var="previousPage" value="${currentPage - 1}" />
        <c:set var="nextPage" value="${currentPage + 1}" />

        <c:choose>
            <c:when test="${currentPage > 1}">
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=1"><<</a>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=${previousPage}"><</a>
            </c:when>
            <c:otherwise>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=1"><<</a>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=${currentPage}"><</a>
            </c:otherwise>
        </c:choose>

        <c:forEach var="page" begin="1" end="${totalPagess + 1}">
            <c:choose>
                <c:when test="${page == currentPage}">
                    <b>${page}</b>
                </c:when>
                <c:otherwise>
                    <!--<a href="?page=${page}">${page}</a>-->
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${currentPage < totalPages}">
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=${nextPage}">></a>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=${totalPagess + 1}">>></a>
            </c:when>
            <c:otherwise>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=${currentPage}">></a>
                <a href="<%=request.getContextPath()%>/user?command=ClubsList&page=${totalPagess + 1}">>></a>
            </c:otherwise>
        </c:choose>
    </center>
</body>
</html>
