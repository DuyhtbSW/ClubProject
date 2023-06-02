package controller.User;

import dao.User.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import model.User.Club;
import model.User.Post;
import model.User.User;

public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        switch (command) {
            case "Home":
                Home(request, response);
                break;
            case "Login":
                Login(request, response);
                break;
            case "Logout":
                Logout(request, response);
                break;
            case "Register":
                Register(request, response);
                break;
            case "LoadProfile":
                LoadProfile(request, response);
                break;
            case "LoadEditProfile":
                LoadEditProfile(request, response);
                break;
            case "EditProfile":
                EditProfile(request, response);
                break;
            case "ClubsList":
                ClubsList(request, response);
                break;
            case "ViewDetailsClub":
                ViewDetailsClub(request, response);
                break;
            case "CreateClub":
                CreateClub(request, response);
                break;
            case "JoinClub":
                JoinClub(request, response);
                break;
            case "ClubManage":
                ClubManage(request, response);
                break;
            case "ClubManager":
                ClubManager(request, response);
                break;
            case "ClubMember":
                ClubMember(request, response);
                break;
            case "ClubPost":
                ClubPost(request, response);
                break;
            case "ViewClubDetails":
                ViewClubDetails(request, response);
                break;
            case "LoadEditClub":
                LoadEditClub(request, response);
                break;
            case "EditClub":
                EditClub(request, response);
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void Home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("user/Home.jsp").forward(request, response);
    }

    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String acc = request.getParameter("acc");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");

        UserDAO userDAO = new UserDAO();
        User u = userDAO.checkUserLogin(acc, pass);

        if (u == null) {
            request.setAttribute("warning", "Incorrect account or password!");
            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("account", u);
            session.setMaxInactiveInterval(999999);

            if (remember != null && remember.equals("on")) {
                Cookie rememberUser = new Cookie("rAcc", acc);
                Cookie rememberPass = new Cookie("rPass", pass);
                rememberUser.setMaxAge(6000);
                rememberPass.setMaxAge(6000);
                response.addCookie(rememberUser);
                response.addCookie(rememberPass);
                session.setAttribute("password", pass);
                session.setAttribute("remember", remember);
            }
            CheckClubCreator(request, response);
//            response.sendRedirect("Home.jsp");
        }
    }

    private void CheckClubCreator(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User userID = (User) session.getAttribute("account");

        UserDAO userDAO = new UserDAO();

        if (userID != null) {
            Club clubCreatorID = userDAO.getClubCreatorFromUserID(userID.getID());
            if (clubCreatorID != null) {
                session.setAttribute("clubCreator", clubCreatorID);
                session.setMaxInactiveInterval(999999);
            }
        } else {
            response.sendRedirect("user/Login.jsp");
        }
        response.sendRedirect("user/Home.jsp");
    }

    private void Logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        session.removeAttribute("clubCreator");
        response.sendRedirect("user/Home.jsp");
    }

    private void Register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String acc = request.getParameter("acc");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");

        if (acc == null || acc.isEmpty() || pass == null || pass.isEmpty() || repass == null || repass.isEmpty()) {
            request.setAttribute("warning", "Please complete all information!");
            request.getRequestDispatcher("user/Register.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();

            if (!pass.equals(repass)) {
                request.setAttribute("Acc", acc);
                request.setAttribute("warning", "Incorrect password or repassword!");
                request.getRequestDispatcher("user/Register.jsp").forward(request, response);
            } else {
                User u = userDAO.checkUserEmail(acc);
                if (u == null) {
                    userDAO.insertUser(acc, pass);
                    request.setAttribute("warning", "Register Successfully!\nPlease Login!");
                    request.getRequestDispatcher("user/Register.jsp").forward(request, response);
                } else {
                    request.setAttribute("warning", "Email already exists!");
                    request.getRequestDispatcher("user/Register.jsp").forward(request, response);
                }
            }
        }
    }

    private void LoadProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        if (u == null) {
            response.sendRedirect("user/Login.jsp");
        } else {
            int ID = u.getID();
            UserDAO userDAO = new UserDAO();

            User user = userDAO.getUserByID(ID);
            request.setAttribute("user", user);
            request.getRequestDispatcher("user/Profile.jsp").forward(request, response);
        }
    }

    private void LoadEditProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        if (u == null) {
            response.sendRedirect("user/Login.jsp");
        } else {
            int ID = u.getID();
            UserDAO userDAO = new UserDAO();

            User user = userDAO.getUserByID(ID);
            request.setAttribute("user", user);
            request.getRequestDispatcher("user/EditProfile.jsp").forward(request, response);
        }
    }

    private void EditProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DateTimeParseException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        String dateStr = dob;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        if (u == null) {
            response.sendRedirect("user/Home.jsp");
        } else {
            int ID = u.getID();

            UserDAO userDAO = new UserDAO();

            if (name.equals("") || email.equals("") || phone.equals("") || dob.equals("") || gender.equals("")) {
                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("dob", formattedDate);
                request.setAttribute("gender", gender);
                request.setAttribute("warning", "Please complete all information!");
                LoadEditProfile(request, response);
//                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
            } else {
                userDAO.editUser(name, email, phone, formattedDate, gender, ID);
                LoadProfile(request, response);
            }
        }
    }

    private void ClubsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserDAO userDAO = new UserDAO();
        ArrayList<Club> club = userDAO.getAllClub();

        request.setAttribute("club", club);
        request.setAttribute("clubs", club.size());
        request.getRequestDispatcher("user/ClubsList.jsp").forward(request, response);
    }

    private void ViewDetailsClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubID = request.getParameter("cID");
        String clubCreatorID = request.getParameter("cCreatorID");

        UserDAO userDAO = new UserDAO();
        Club club = userDAO.getClubByID(clubID);
        String ClubCreatorName = userDAO.getClubCreatorName(clubCreatorID);

        request.setAttribute("club", club);
        request.setAttribute("clubCreatorName", ClubCreatorName);
        request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
    }

    private boolean isString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private void CreateClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubCode = request.getParameter("cCode");
        String clubName = request.getParameter("cName");
        String clubDescription = request.getParameter("cDescription");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        LocalDate currentDate = LocalDate.now();

        if (u == null) {
            response.sendRedirect("user/Login.jsp");
        } else {
            if (clubCode.equals("") || clubName.equals("") || clubDescription.equals("")) {
                request.setAttribute("warning", "Please complete all information!");
                request.getRequestDispatcher("user/CreateClub.jsp").forward(request, response);

            } else if (clubCode.length() != 3) {
                request.setAttribute("warning", "Club Code must be 3 letters!");
                request.getRequestDispatcher("user/CreateClub.jsp").forward(request, response);
            } else if (!isString(clubCode)) {
                request.setAttribute("warning", "Club Code must be letters!");
                request.getRequestDispatcher("user/CreateClub.jsp").forward(request, response);
            } else {
                int ID = u.getID();

                UserDAO userDAO = new UserDAO();
                userDAO.insertClub(clubCode.toUpperCase(), clubName, clubDescription, ID, java.sql.Date.valueOf(currentDate));

                request.getRequestDispatcher("user/CreateClub.jsp").forward(request, response);
            }
        }
    }

    private void JoinClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        if (u == null) {
            response.sendRedirect("user/Login.jsp");
        } else {
            String clubID = request.getParameter("clubID");
            String clubCreatorID = request.getParameter("clubCreatorID");

            UserDAO userDAO = new UserDAO();
            Club club = userDAO.getClubByID(clubID);
            String ClubCreatorName = userDAO.getClubCreatorName(clubCreatorID);

            request.setAttribute("club", club);
            request.setAttribute("clubCreatorName", ClubCreatorName);
            request.setAttribute("warning", "Please wait for the manager to accept!");
            request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
        }
    }

    private void ClubManage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Club club = userDAO.getClubToManage(clubID.getID());
            request.setAttribute("club", club);
            request.getRequestDispatcher("user/ClubManage.jsp").forward(request, response);
        } else {
            response.sendRedirect("user/Home.jsp");
        }
    }

    private void ClubManager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            ArrayList<User> manager = userDAO.getClubManagersWithoutCreator(clubID.getID(), clubID.getCreatorID());
            if (manager == null) {
                request.setAttribute("warning", "No manager yet");
                request.getRequestDispatcher("user/ClubManager.jsp").forward(request, response);
            } else {
                request.setAttribute("manager", manager);
                request.getRequestDispatcher("user/ClubManager.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user/Home.jsp");
        }
    }

    private void ClubMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            ArrayList<User> member = userDAO.getClubMembersWithoutCreator(clubID.getID(), clubID.getCreatorID());
            if (member == null) {
                request.setAttribute("warning", "No member yet");
                request.getRequestDispatcher("user/ClubMember.jsp").forward(request, response);
            } else {
                request.setAttribute("member", member);
                request.getRequestDispatcher("user/ClubMember.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user/Home.jsp");
        }
    }

    private void ClubPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            ArrayList<Post> post = userDAO.getPostFromClubID(clubID.getID());
            if (post == null) {
                request.setAttribute("warning", "No post yet");
                request.getRequestDispatcher("user/ClubPost.jsp").forward(request, response);
            } else {
                request.setAttribute("post", post);
                request.getRequestDispatcher("user/ClubPost.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user/Home.jsp");
        }
    }

    private void ViewClubDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Club club = userDAO.getClubToManage(clubID.getID());
            request.setAttribute("club", club);
            request.getRequestDispatcher("user/ViewClubDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("user/Home.jsp");
        }
    }

    private void LoadEditClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Club club = userDAO.getClubToManage(clubID.getID());
            request.setAttribute("club", club);
            request.getRequestDispatcher("user/EditClubDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("user/Home.jsp");
        }
    }

    private void EditClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        Club clubID = (Club) session.getAttribute("clubCreator");

        if (clubID == null) {
            response.sendRedirect("user/Home.jsp");
        } else {

            UserDAO userDAO = new UserDAO();

            if (code.equals("") || name.equals("") || description.equals("")) {
                request.setAttribute("code", code);
                request.setAttribute("name", name);
                request.setAttribute("description", description);
                request.setAttribute("warning", "Please complete all information!");
                LoadEditClub(request, response);
            } else if (code.length() != 3) {
                request.setAttribute("warning", "Club Code must be 3 letters!");
                LoadEditClub(request, response);
            } else if (!isString(code)) {
                request.setAttribute("warning", "Club Code must be letters!");
                LoadEditClub(request, response);
            } else {
                userDAO.editClub(code, name, description, clubID.getID());
                ViewClubDetails(request, response);
            }
        }
    }

}
