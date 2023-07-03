<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Post Club Request - Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            th, td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Post Club Request</h2>
                <section class="recent">
                    <h4><a href="<%=request.getContextPath()%>/user?command=ClubManage">Back</a></h4>
                    <div class="activity-grid">
                        <div class="activity-card">
                            <!--    <h3>Club Manage</h3>-->
                            <div class="table-responsive">
                                <center>
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
                                            <c:set var="pageSize" value="5" />
                                            <c:set var="currentPage" value="${param.page eq null ? 1 : param.page}" />
                                            <c:set var="startIndex" value="${(currentPage - 1) * pageSize}" />
                                            <c:set var="endIndex" value="${(currentPage * pageSize) - 1}" />
                                            <c:forEach var="pr" items="${postRequest}" begin="${startIndex}" end="${endIndex}">
                                                <tr>
                                                    <td>${pr.memberID}</td>
                                                    <td>${pr.date}</td>
                                                    <td>${pr.title}</td>
                                                    <td>${pr.description}</td>
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/user?command=PostRequestAccept&pID=${pr.ID}&mID=${pr.clubID}">Accept</a>
                                                    </td>
                                                    <td>
                                                        <a href="<%=request.getContextPath()%>/user?command=PostRequestDecline&pID=${pr.ID}&mID=${pr.clubID}">Decline</a>
                                                    </td>
                                                </c:forEach>
                                        </tbody>
                                    </table><br>
                                    <c:set var="totalPages" value="${postRequests div pageSize}" />
                                    <fmt:parseNumber var="totalPagess" value="${totalPages}" type="number" integerOnly="true"/>
                                    <c:set var="previousPage" value="${currentPage - 1}" />
                                    <c:set var="nextPage" value="${currentPage + 1}" />
                                    <c:if test="${totalPages % 2 == 0}">
                                        <c:choose>
                                            <c:when test="${currentPage > 1}">
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=1"><<</a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${previousPage}"><</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=1"><<</a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${currentPage}"><</a>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach var="page" begin="1" end="${totalPagess}">
                                            <c:choose>
                                                <c:when test="${page == currentPage}">
                                                    <b>${page}</b>
                                                </c:when>
                                                <c:otherwise>
                                                    <!--<a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${page}">${page}</a>-->
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${currentPage < totalPages}">
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${nextPage}">></a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${totalPagess}">>></a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${currentPage}">></a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${totalPagess}">>></a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                    <c:if test="${totalPages % 2 != 0}">
                                        <c:choose>
                                            <c:when test="${currentPage > 1}">
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=1"><<</a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${previousPage}"><</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=1"><<</a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${currentPage}"><</a>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach var="page" begin="1" end="${totalPagess + 1}">
                                            <c:choose>
                                                <c:when test="${page == currentPage}">
                                                    <b>${page}</b>
                                                </c:when>
                                                <c:otherwise>
                                                    <!--<a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${page}">${page}</a>-->
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${currentPage < totalPages}">
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${nextPage}">></a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${totalPagess + 1}">>></a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${currentPage}">></a>
                                                <a href="<%=request.getContextPath()%>/user?command=PostClubRequestList&page=${totalPagess + 1}">>></a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </center>
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>