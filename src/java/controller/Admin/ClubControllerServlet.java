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
import model.Admin.Club;
import dao.Admin.ClubDao;
import jakarta.servlet.http.HttpSession;

public class ClubControllerServlet extends HttpServlet {

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
            case "DELETE":
                declineClub(request, response);
                break;
            default:
                listAllClub(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void listAllClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Club> cl = new ClubDao().listAllClub();
        request.setAttribute("cl", cl);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin-club.jsp");
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
        RequestDispatcher dispathcher = request.getRequestDispatcher("admin/admin-club-detail.jsp");
        dispathcher.forward(request, response);
    }

    private void updateClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clubId = Integer.parseInt(request.getParameter("clubId"));
        String clubName = request.getParameter("clubName");
        String clubCode = request.getParameter("clubCode");
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
        Club theClub = new Club(clubId, clubCode, clubName, clubDesription, clubCreatorID, dateCreated);
        new ClubDao().updateClub(theClub);
        loadClub(request, response);
    }

    private void createClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clubId = Integer.parseInt(request.getParameter("clubId"));
        Club theClub = new Club(clubId);
        new ClubDao().createClub(theClub);
        listClubRequest(request, response);
    }

    private void listClubRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Club> clRe = new ClubDao().listClubRequest();
        request.setAttribute("clRe", clRe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin-club-create.jsp");
        dispatcher.forward(request, response);
    }

    private void declineClub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clubId = request.getParameter("clubId");
        new ClubDao().declineClub(clubId);
        listClubRequest(request, response);
    }
}
