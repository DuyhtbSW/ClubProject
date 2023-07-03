<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Details</title>
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            td {
                text-align: center;
            }

            textarea {
                resize: none;
            }
        </style>
    </head>
    <body>
    <center>
        <c:if test="${vclub != null}">
            <h1>Club Details</h1>
        </c:if>
        <c:if test="${vmember != null}">
            <h1>Join Details</h1>
        </c:if>
        <c:if test="${vpost != null}">
            <h1>Post Details</h1>
        </c:if>
        <c:if test="${vevent != null}">
            <h1>Event Details</h1>
        </c:if>
        <!--<form action="<%=request.getContextPath()%>/user" method="get">-->
        <!--<input type="hidden" name="command" value="SearchClub">-->
        <!--<a href="<%=request.getContextPath()%>/user?command=Home">Home</a>-->
        <!--<a href="<%=request.getHeader("referer")%>">Back</a>-->
        <!--<input type="text" name="search" value="${search}" oninput=""><input type="submit" value="Search">-->
        <br><br>
        <table border="1" width="600">
            <thead>
                <tr>
                    <c:if test="${vclub != null}">
                        <th>Code</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Date Created</th>
                        </c:if>
                        <c:if test="${vmember != null}">
                        <th>Club Code</th>
                        <th>Name</th>
                        <th>Request Date</th>
                        </c:if>
                        <c:if test="${vpost != null}">
                        <th>Title</th>
                        <th>Description</th>
                        <th>Date</th>
                        </c:if>
                        <c:if test="${vevent != null}">
                        <th>Name</th>
                        <th>Description</th>
                        <th>Date</th>
                        </c:if>
                </tr>
            </thead>
            <tbody>
                <c:if test="${vclub != null}">
                    <tr>
                        <td>${club.code}</td>
                        <td>${club.name}</td>
                        <td>${club.description}</td>
                        <td>${club.dateCreated}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=Notification">Back</a>
                        </td>
                        <c:if test="${club.status == 0}">
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=LoadDetailsClubs">Edit</a>
                                <!--<a href="<%=request.getContextPath()%>/user?command=LoadDetailsClubs&cID=${club.ID}">Edit</a>-->
                            </td>
                            <c:if test="${club.createRequest == 1}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=CancelRequestClub">Cancel Request</a>
                                </td>
                            </c:if>
                            <c:if test="${club.createRequest == 0}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=ResendRequestClub">Resend Request</a>
                                </td>
                            </c:if>
                        </c:if>
                    </tr>
                </c:if>
                <c:if test="${vmember != null}">
                    <tr>
                        <td>${member.userID}</td>
                        <td>${member.clubID}</td>
                        <td>${member.joinDate}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=Notification">Back</a>
                        </td>
                        <c:if test="${member.status == 0}">
                            <c:if test="${member.joinStatus == 1}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=CancelRequestJoin">Cancel Request</a>
                                </td>
                            </c:if>
                            <c:if test="${member.joinStatus == 0}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=ResendRequestJoin">Resend Request</a>
                                </td>
                            </c:if>
                        </c:if>
                    </tr>
                </c:if>
                <c:if test="${vpost != null}">
                    <tr>
                        <td>${post.title}</td>
                        <td>${post.description}</td>
                        <td>${post.date}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=Notification">Back</a>
                        </td>
                        <c:if test="${post.status == 0}">
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=LoadDetailsPosts">Edit</a>
                            </td>
                            <c:if test="${post.createRequest == 1}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=CancelRequestPost">Cancel Request</a>
                                </td>
                            </c:if>
                            <c:if test="${post.createRequest == 0}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=ResendRequestPost">Resend Request</a>
                                </td>
                            </c:if>
                        </c:if>
                    </tr>
                </c:if>
                <c:if test="${vevent != null}">
                    <tr>
                        <td>${event.name}</td>
                        <td>${event.description}</td>
                        <td>${event.date}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/user?command=Notification">Back</a>
                        </td>
                        <c:if test="${event.status == 0}">
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=LoadDetailsEvents">Edit</a>
                            </td>
                            <c:if test="${event.createRequest == 1}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=CancelRequestEvent">Cancel Request</a>
                                </td>
                            </c:if>
                            <c:if test="${event.createRequest == 0}">
                                <td>
                                    <a href="<%=request.getContextPath()%>/user?command=ResendRequestEvent">Resend Request</a>
                                </td>
                            </c:if>
                        </c:if>
                    </tr>
                </c:if>
            </tbody>
        </table>
        <br><br><br>
        <c:if test="${eclub != null}">
            <form action="<%=request.getContextPath()%>/user" method="get">
                <input type="hidden" name="command" value="EditDetailsClubs">
                <!--<table border="1" width="600">-->
                <table>
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <c:if test="${code == null}">
                                <!--<td><input type="text" name="code" value="${club.code}"></td>-->
                                <td><textarea rows="4" cols="27" name="code">${club.code}</textarea></td>
                                </c:if>
                                <c:if test="${code != null}">
                                <!--<td><input type="text" name="code" value=""></td>-->
                                <td><textarea rows="4" cols="27" name="code"></textarea></td>
                                </c:if>
                                <c:if test="${name == null}">
                                <td><textarea rows="4" cols="27" name="name">${club.name}</textarea></td>
                                </c:if>
                                <c:if test="${name != null}">
                                <td><textarea rows="4" cols="27" name="name"></textarea></td>
                                </c:if>
                                <c:if test="${description == null}">
                                <td><textarea rows="4" cols="27" name="description">${club.description}</textarea></td>
                                </c:if>
                                <c:if test="${description != null}">
                                <td><textarea rows="4" cols="27" name="description"></textarea></td>
                                </c:if>
                            <td>
                                <input type="submit" name="save" value="Save"/>
                            </td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=ViewDetailsClubs&cID=${club.ID}">Cancel</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </c:if>
        <c:if test="${epost != null}">
            <form action="<%=request.getContextPath()%>/user" method="get">
                <input type="hidden" name="command" value="EditDetailsPosts">
                <table>
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <c:if test="${title == null}">
                                <td><textarea rows="3" cols="27" name="title">${post.title}</textarea></td>
                                </c:if>
                                <c:if test="${title != null}">
                                <td><textarea rows="3" cols="27" name="title"></textarea></td>
                                </c:if>
                                <c:if test="${description == null}">
                                <td><textarea rows="3" cols="30" name="description">${post.description}</textarea></td>
                                </c:if>
                                <c:if test="${description != null}">
                                <td><textarea rows="3" cols="30" name="description"></textarea></td>
                                </c:if>
                            <td>
                                <input type="submit" value="Save"/>
                            </td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=ViewDetailsPosts&pID=${post.ID}">Cancel</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </c:if>
        <c:if test="${eevent != null}">
            <form action="<%=request.getContextPath()%>/user" method="get">
                <input type="hidden" name="command" value="EditDetailsEvents">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Date</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <c:if test="${name == null}">
                                <td><textarea rows="3" cols="27" name="name">${event.name}</textarea></td>
                                </c:if>
                                <c:if test="${name != null}">
                                <td><textarea rows="3" cols="27" name="name"></textarea></td>
                                </c:if>
                                <c:if test="${description == null}">
                                <td><textarea rows="3" cols="30" name="description">${event.description}</textarea></td>
                                </c:if>
                                <c:if test="${description != null}">
                                <td><textarea rows="3" cols="30" name="description"></textarea></td>
                                </c:if>
                            <td>
                                Old day: <br><input type="text" name="olddate" value="${event.date}" readonly=""/><br>
                                New day: <br><input type="date" name="newdate"/>
                            </td>
                            <td>
                                <input type="submit" value="Save"/>
                            </td>
                            <td>
                                <a href="<%=request.getContextPath()%>/user?command=ViewDetailsEvents&eID=${event.ID}">Cancel</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </c:if>
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
        <!--</form>-->
    </center>
</body>
</html>
