package controller.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Admin.User;
import dao.Admin.UserDao;
import jakarta.servlet.http.HttpSession;

public class UserControllerServlet extends HttpServlet {

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
            response.sendRedirect(request.getContextPath() + "/admin/admin-login.jsp");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void listAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> user = new UserDao().listAllUser();
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin-user.jsp");
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
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin/admin-user-detail.jsp");
        dispathcher.forward(request, response);
    }

    public enum Gender {
        MALE, FEMALE
    };

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPass = request.getParameter("userPassword");
        String userPhone = request.getParameter("userPhone");
        String userDOBSrt = request.getParameter("userDOB");
        String userGender = request.getParameter("userGender");
        Date userDOB = null;

        // Kiểm tra xem input có null hoặc rỗng hay không
        if (userName != null && !userName.trim().isEmpty()
                && userEmail != null && !userEmail.trim().isEmpty()
                && userPass != null && !userPass.trim().isEmpty()
                && userGender != null && !userGender.trim().isEmpty()) {

            // Kiểm tra giá trị gender có hợp lệ hay không
            if ("Male".equalsIgnoreCase(userGender) || "Female".equalsIgnoreCase(userGender)) {

                // Kiểm tra định dạng của ngày sinh và chuyển đổi thành kiểu dữ liệu Date
                if (userDOBSrt != null && !userDOBSrt.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.setLenient(false);
                    try {
                        userDOB = sdf.parse(userDOBSrt);
                    } catch (ParseException e) {
                        throw new IllegalArgumentException("Ngày sinh không hợp lệ"); // nếu định dạng không hợp lệ, throw một IllegalArgumentException
                    }
                } else {
                    throw new IllegalArgumentException("Ngày sinh không được bỏ trống"); // nếu ngày sinh bị bỏ trống, throw một IllegalArgumentException
                }
            } else {
                throw new IllegalArgumentException("Giới tính không hợp lệ"); // nếu giới tính không hợp lệ, throw một IllegalArgumentException
            }
        User theUser = new User(userId, userName, userEmail, userPass, userPhone, userGender, userDOB);

        new UserDao().updateUser(theUser);
        loadUser(request, response);
        }else {
            throw new IllegalArgumentException("Thông tin người dùng không hợp lệ"); // nếu thông tin người dùng không hợp lệ, throw một IllegalArgumentException
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        new UserDao().deleteUser(userId);
        listAllUser(request, response);
    }

}
