package controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Admin.Admin;
import dao.Admin.AdminDao;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String theCommand = request.getParameter("command");
        if (theCommand == null) {
            theCommand = "HOME";
        }
        switch (theCommand) {
            case "LOGIN":
                loginAdmin(request, response);
                break;
            case "HOME":
                home(request, response);
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String iD = request.getParameter("username");
        String passWord = request.getParameter("password");
        Admin ad = new Admin(iD, passWord);
        if (AdminDao.login(ad)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminLogin", ad);
            session.setAttribute("loggedIn", true);
            
//            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//
//            session = request.getSession();
//            String prevUrl = request.getHeader("Referer");
//
//            session.setAttribute("prevUrl", prevUrl);
//            session = request.getSession(false);
//            if (session != null) {
//                prevUrl = (String) session.getAttribute("prevUrl");
//                if (prevUrl != null) {
//                    // Chuyển hướng người dùng về trang trước đó đã xem
//                    response.sendRedirect(prevUrl);
//                }
//            }

            response.sendRedirect("AdminControllerServlet");
        } else {
            request.setAttribute("loginFail", "Email or password is incorrect");
            request.getRequestDispatcher("admin/admin-login.jsp").forward(request, response);
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("admin/admin-home.jsp").forward(request, response);
    }
}
