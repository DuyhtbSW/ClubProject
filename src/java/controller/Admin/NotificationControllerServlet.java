/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import dao.Admin.ClubDao;
import dao.Admin.EventDao;
import dao.Admin.NotificationDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import model.Admin.Club;
import model.Admin.Event;
import model.Admin.Notification;

/**
 *
 * @author acer
 */
public class NotificationControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NotificationControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotificationControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            // Nếu người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/admin/admin-login.jsp");
            return;
        }
        String theCommand = request.getParameter("command");
        switch (theCommand) {
            case "SENT":
                sentClubNotification(request, response);
                break;
            case "LOAD":
                clubNotification(request, response);
                break;
            case "SENTEVENT":
                sentEventNotification(request, response);
                break;
            case "LOADEVENT":
                eventNotification(request, response);
                break;

            default:
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void sentClubNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int clubId = Integer.parseInt(request.getParameter("clubId"));
        int notificationId = Integer.parseInt(request.getParameter("notificationId"));
        String note = request.getParameter("Note");
        String accept = request.getParameter("accept");
        
        Notification noti = new Notification(notificationId, note);
        Club theClub = new Club(clubId);
        Club theClub1 = new Club(clubId, userId);
        if (note.isEmpty() || accept == null || accept.isEmpty()) {
            request.getSession().setAttribute("warning", "Please complete all information!");
            request.getRequestDispatcher("NotificationControllerServlet?command=LOAD&clubId="+clubId).forward(request, response);
        } else if (accept.equals("Accept")) {
            new ClubDao().createClub(theClub);
            new ClubDao().insertCreatorToMember(theClub1);
            new NotificationDao().sentNotification(noti);
        } else {
            new ClubDao().declineClub(theClub);
            new NotificationDao().sentNotification(noti);
        }
        request.getRequestDispatcher("ClubControllerServlet?command=CLUBREQUEST").forward(request, response);
    }

    private void clubNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clubId = request.getParameter("clubId");
        Notification notiEdit = new ClubDao().getNotifromClubId(clubId);
        request.setAttribute("noti", notiEdit);
        Club theClub = new ClubDao().getClub(clubId);
        request.setAttribute("The_Club", theClub);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin/admin-club-notification.jsp");
        dispathcher.forward(request, response);
    }

    private void eventNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        Notification notiEdit = new ClubDao().getNotifromEventId(eventId);
        request.setAttribute("noti", notiEdit);
        Event theEvent = new EventDao().getEvent(eventId);
        request.setAttribute("The_Event", theEvent);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin/admin-event-notification.jsp");
        dispathcher.forward(request, response);
    }

    private void sentEventNotification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        int notificationId = Integer.parseInt(request.getParameter("notificationId"));
        
        String note = request.getParameter("Note");
        String accept = request.getParameter("accept");
        Notification noti = new Notification(notificationId, note);
        Event event = new Event(eventId);
        if (note.isEmpty() || accept == null || accept.isEmpty()) {
            request.getSession().setAttribute("warning", "Please complete all information!");
            request.getRequestDispatcher("NotificationControllerServlet?command=LOADEVENT&eventId=" + eventId).forward(request, response);
        } else if (accept.equals("Accept")) {
            new EventDao().acceptEvent(event);
            new NotificationDao().sentNotification(noti);
            request.getRequestDispatcher("EventControllerServlet?command=EVENTREQUEST").forward(request, response);
        } else {
            new EventDao().declineEvent(event);
            new NotificationDao().sentNotification(noti);
            request.getRequestDispatcher("EventControllerServlet?command=EVENTREQUEST").forward(request, response);
        }
    }

}