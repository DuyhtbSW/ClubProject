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
import model.Admin.User;
import dao.Admin.UserDao;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author acer
 */
public class UserControllerServlet extends HttpServlet {

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
            out.println("<title>Servlet UserControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserControllerServlet at " + request.getContextPath() + "</h1>");
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
                listAllUser(request, response);
                break;
            case "LOAD":
                loadUser(request, response);
                break;
            case "COUNT":
                countUser(request, response);
                break;
            case "UPDATE":
                updateUser(request, response);
                break;
            case "DELETE":
                deleteUser(request, response);
                break;
            default:
                listAllUser(request, response);
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

    private void listAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> user = new UserDao().listAllUser();
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-user.jsp");
        dispatcher.forward(request, response);
    }

    private void countUser(HttpServletRequest request, HttpServletResponse response) {
        int count = new UserDao().countUser();
        request.setAttribute("count", count);
    }

    private void loadUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        User theUser = new UserDao().getUser(userId);
        request.setAttribute("The_User", theUser);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin-user-detail.jsp");
        dispathcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPassword");
        String userPhone = request.getParameter("userPhone");
        String userDOBSrt = request.getParameter("userDOB");
        String userGender = request.getParameter("userGender");
        Date userDOB = null;
        if (userDOBSrt != null && !userDOBSrt.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                userDOB = sdf.parse(userDOBSrt);
            } catch (ParseException e) {
            }
        }

        User theUser = new User(userId, userName, userEmail, userPass, userPhone, userGender, userDOB);
        new UserDao().updateUser(theUser);
        loadUser(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        new UserDao().deleteUser(userId);
        listAllUser(request, response);
    }

}
