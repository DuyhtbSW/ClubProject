package controller.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Admin.Event;
import dao.Admin.EventDao;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            // Nếu người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/admin-login.jsp");
            return;
        }
        String theCommand = request.getParameter("command");
        if (theCommand == null) {
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "LIST":
                listAllEvent(request, response);
                break;
            case "EVENTTODAY":
                loadEventToday(request, response);
                break;
            case "LOAD":
                loadEvent(request, response);
                break;
            case "DELETE":
                deleteEvent(request, response);
                break;
            case "UPDATE":
                updateEvent(request, response);
                break;
            default:
                listAllEvent(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void listAllEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Event> event = new EventDao().listAllEvent();
        request.setAttribute("event", event);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin-event.jsp");
        dispatcher.forward(request, response);
    }
    
    private void loadEventToday(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Event> event = new EventDao().getEventToday();
        request.setAttribute("eventtd", event);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin-event-today.jsp");
        dispatcher.forward(request, response);
    }

    private void loadEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        Event theEvent = new EventDao().getEvent(eventId);
        request.setAttribute("The_Event", theEvent);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin/admin-event-detail.jsp");
        dispathcher.forward(request, response);
    }

    private void updateEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String eventName = request.getParameter("eventName");
        String eventDescription = request.getParameter("eventDescription");
        String eventDateStr = request.getParameter("eventDate");
        Date eventDate = null;
        if (eventDateStr != null && !eventDateStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                eventDate = sdf.parse(eventDateStr);
            } catch (ParseException e) {
            }
        }

        Event theEvent = new Event(eventId, eventName, eventDescription, eventDate);
        new EventDao().updateEvent(theEvent);
        loadEvent(request, response);
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        new EventDao().deleteEvent(eventId);
        listAllEvent(request, response);
    }
}
