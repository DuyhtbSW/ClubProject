package controller.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Admin.Member;
import dao.Admin.MemberDao;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberControllerServlet extends HttpServlet {

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
                listAllMember(request, response);
                break;
            case "LOAD":
                loadMember(request, response);
                break;
            case "UPDATE":
                updateMember(request, response);
                break;
            case "DELETE":
                deleteMember(request, response);
                break;
            default:
                listAllMember(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void listAllMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> mb = new MemberDao().listAllMember();
        request.setAttribute("mb", mb);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin-member.jsp");
        dispatcher.forward(request, response);
    }

    private void loadMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        Member theMember = new MemberDao().getMember(userId);
        request.setAttribute("The_Member", theMember);
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin/admin-member-detail.jsp");
        dispathcher.forward(request, response);
    }

    private void updateMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String joinDateStr = request.getParameter("joinDate");
        Date joinDate = null;
        if (joinDateStr != null && !joinDateStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                joinDate = sdf.parse(joinDateStr);
            } catch (ParseException e) {
            }
        }
        Member theMember = new Member(userId, joinDate);
        new MemberDao().updateMember(theMember);
        loadMember(request, response);
    }

    private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        new MemberDao().deleteMember(userId);
        listAllMember(request, response);
    }
}
