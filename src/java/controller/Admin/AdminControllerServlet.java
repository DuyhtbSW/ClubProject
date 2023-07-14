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
        HttpSession session = request.getSession();
        String check = (String) request.getSession().getAttribute("check");

        if (check != null) {
            String iD = (String) request.getSession().getAttribute("username");
            String passWord = (String) request.getSession().getAttribute("password");
            Admin ad = new Admin(iD, passWord);
            if (AdminDao.login(ad)) {
                session.setAttribute("adminLogin", ad);
                session.setAttribute("loggedIn", true);
                request.getSession().removeAttribute("username");
                request.getSession().removeAttribute("password");
                request.getSession().removeAttribute("check");
                response.sendRedirect("AdminControllerServlet");
            } else {
                request.getSession().setAttribute("warning", "Incorrect account or password!");
                response.sendRedirect("user?command=rLogin");
            }
        } else {
            String iD = request.getParameter("username");
            String passWord = request.getParameter("password");
            Admin ad = new Admin(iD, passWord);
            if (AdminDao.login(ad)) {
                session.setAttribute("adminLogin", ad);
                session.setAttribute("loggedIn", true);
                response.sendRedirect("AdminControllerServlet");
            } else {
                request.setAttribute("loginFail", "Email or password is incorrect");
                request.getRequestDispatcher("admin/admin-login.jsp").forward(request, response);
            }
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("admin/admin-home.jsp").forward(request, response);
    }
}
