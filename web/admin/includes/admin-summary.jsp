<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page import="dao.Admin.EventDao" %>
<%@ page import="model.Admin.Event" %>
<%@ page import="dao.Admin.ClubDao" %>
<%@ page import="dao.Admin.EventDao" %>
<div class="summary">
    <div class="summary-card">
        <div class="summary-single" >
            <span class="ti-id-badge"></span>
            <div>
                <c:url var="tempLink" value="ClubControllerServlet">
                    <c:param name="command" value="CLUBREQUEST"></c:param>
                </c:url>
                <h5><%= ClubDao.countClubRequest() %></h5>
                <a type="submit" href="<%=request.getContextPath()%>/${tempLink}"><small>Create Club Request</small></a>
            </div>
        </div>
        <div class="summary-single">
            <span class="ti-calendar"></span>
            <div>
                <c:url var="tempLink" value="EventControllerServlet">
                    <c:param name="command" value="EVENTREQUEST"></c:param>
                </c:url>
                <h5><%= EventDao.countEventRequest() %></h5>
                <a type="submit" href="<%=request.getContextPath()%>/${tempLink}"><small>Event Request</small></a>
            </div>
        </div>
        <div class="summary-single">
            <span class="ti-face-smile"></span>
            <div>
                <h5>0</h5>
                <small>Club Update Request</small>
            </div>
        </div>
    </div>
    <div class="bday-card">
        <div class="bday-flex">
            <img class="bday-img" src="<%=request.getContextPath()%>/admin/images/Event.jpg" alt="alt"/>
            <div class="bday-info">
                <h5>
                    <% List<Event> events = EventDao.getEventToday(); %> 
                    <% if (events.isEmpty()) { %> No Event 
                    <% } else { 
                        String eventList = "";
                        for (Event event : events) { 
                            if (eventList.isEmpty()) {
                                eventList += event.getEventName();
                            } else {
                                eventList += " & " + event.getEventName();
                            }
                        } %> 
                    <%= eventList %>
                    <% } %>
                </h5>
                <small>Event Today</small>
            </div>
        </div>
        <div class="text-center">
            <c:url var="tempLink" value="EventControllerServlet">
                <c:param name="command" value="EVENTTODAY"></c:param>
            </c:url>
            <button>
                <span class="ti-gift"></span>
                <a href="<%=request.getContextPath()%>/${tempLink}">View detail</a>
            </button>
        </div>
    </div>
</div>
