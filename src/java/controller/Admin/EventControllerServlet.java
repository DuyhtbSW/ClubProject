/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Admin.Event;
import dao.Admin.EventDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author acer
 */
public class EventControllerServlet extends HttpServlet {

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
            out.println("<title>Servlet EventControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EventControllerServlet at " + request.getContextPath() + "</h1>");
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
        String theCommand = request.getParameter("command");
        if (theCommand == null) {
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "LIST":
                listAllEvent(request, response);
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

    private void listAllEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Event> event = new EventDao().listAllEvent();
        request.setAttribute("event", event);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-event.jsp");
        dispatcher.forward(request, response);
    }

    private void loadEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");
        Event theEvent = new EventDao().getEvent(eventId);
        request.setAttribute("The_Event", theEvent);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin-event-detail.jsp");
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
