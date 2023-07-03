<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
        <title>Verification - Remove Club</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <style>
            a {
                text-decoration: none;
                padding: 0 1%;
            }

            th, td {
                text-align: center;
            }

            input[type=submit] {
                padding: 4px 10px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <input type="checkbox" id="sidebar-toggle">
        <%@ include file="includes/ClubSidebar.jsp" %>
        <div class="main-content">
            <%@ include file="includes/ClubHeader.jsp" %>
            <main>
                <h2 class="dash-title">Verification</h2>
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
                                <center>
                                    <form action="<%=request.getContextPath()%>/user" method="get">
                                        <c:if test="${verify == null}">
                                            <input type="hidden" name="command" value="Verification">
                                        </c:if>
                                        <c:if test="${verify != null}">
                                            <input type="hidden" name="command" value="VerificationOTP">
                                        </c:if>
                                        <table>
                                            <%--<c:if test="${email == null}">--%>
                                                <!--<tr><td></td><td></td><td></td><td><h2>Email: </h2></td><td><input type="email" name="email" value="" placeholder="Enter email"></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>-->
                                                    <%--</c:if>--%>
                                                    <c:if test="${email != null}">
                                                <tr><td></td><td></td><td></td><td><h2>Email: </h2></td><td><input type="email" name="email" value="${email}" readonly=""></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                                                    </c:if>
                                                <tr><td></td><td></td><td></td><td><h2>OTP: </h2></td><td><input type="text" name="otp" placeholder="Enter OTP"></td><td><input type="submit" name="getOTP" value="Get OTP"/></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                                                <tr><td></td><td></td><td></td><td><a href="<%=request.getContextPath()%>/user?command=ClubManage"><h2>Back</h2></a></td><td><input type="submit" name="verify" value="Verify"/></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
                                        </table>
                                    </form>
                                </center>
                            </div>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
</html>
