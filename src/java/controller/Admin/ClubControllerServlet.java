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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Admin.Club;
import dao.Admin.ClubDao;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author acer
 */
public class ClubControllerServlet extends HttpServlet {

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
            out.println("<title>Servlet ClubControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClubControllerServlet at " + request.getContextPath() + "</h1>");
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
            response.sendRedirect(request.getContextPath() + "/admin-login.jsp");
            return;
        }
        String theCommand = request.getParameter("command");
        if (theCommand == null) {
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "LIST":
                listAllClub(request, response);
                break;
            case "LOAD":
                loadClub(request, response);
                break;
            case "CLUBREQUEST":
                listClubRequest(request, response);
                break;
            case "CREATE":
                createClub(request, response);
                break;
            case "COUNT":
                countClub(request, response);
                break;
            case "UPDATE":
                updateClub(request, response);
                break;
            default:
                listAllClub(request, response);
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

    private void listAllClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Club> cl = new ClubDao().listAllClub();
        request.setAttribute("cl", cl);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-club.jsp");
        dispatcher.forward(request, response);
    }

    private void countClub(HttpServletRequest request, HttpServletResponse response) {
        int count = new ClubDao().countClub();
        request.setAttribute("count", count);
    }

    private void loadClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clubId = request.getParameter("clubId");
        Club theClub = new ClubDao().getClub(clubId);
        request.setAttribute("The_Club", theClub);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin-club-detail.jsp");
        dispathcher.forward(request, response);
    }

    private void updateClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clubId = Integer.parseInt(request.getParameter("clubId"));
        String clubName = request.getParameter("clubName");
        String clubDesription = request.getParameter("clubDesription");
        int clubCreatorID = Integer.parseInt(request.getParameter("clubCreatorID"));
        String dateCreatedstr = request.getParameter("dateCreated");
        Date dateCreated = null;
        if (dateCreatedstr != null && !dateCreatedstr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                dateCreated = sdf.parse(dateCreatedstr);
            } catch (ParseException e) {
            }
        }
        Club theClub = new Club(clubId, clubName, clubDesription, clubCreatorID, dateCreated);
        new ClubDao().updateClub(theClub);
        loadClub(request, response);
    }
    
    

//    private void countMemberOfClub(HttpServletRequest request, HttpServletResponse response) {
//        int count = new ClubDao().countMemberOfClub("clubId");
//        request.setAttribute("count", count);
//    }

    private void createClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clubId = Integer.parseInt(request.getParameter("clubId"));
        Club theClub = new Club(clubId);
        new ClubDao().createClub(theClub);
        listClubRequest(request, response);
    }

    private void listClubRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Club> clRe = new ClubDao().listClubRequest();
        request.setAttribute("clRe", clRe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-club-create.jsp");
        dispatcher.forward(request, response);
    }
      
}
