package controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Admin.Admin;
import dao.Admin.AdminDao;

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
            theCommand = "LIST";
        }
        switch (theCommand) {
            case "LOGIN":
                loginAdmin(request, response);
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
            response.sendRedirect("admin/admin-home.jsp");
            return;
        }
        request.setAttribute("loginFail", "ID or Password is incorrect");
        request.getRequestDispatcher("admin/admin-login.jsp").forward(request, response);
    }

}
