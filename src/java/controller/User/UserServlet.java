package controller.User;

import dao.Admin.AdminDao;
import dao.User.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Admin.Admin;
import model.User.Chat;
import model.User.Club;
import model.User.Event;
import model.User.EventAttendees;
import model.User.Member;
import model.User.Notification;
import model.User.Post;
import model.User.PostComment;
import model.User.Rating;
import model.User.SendEmail;
import model.User.User;

@MultipartConfig
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
            case "rLogin":
                rLogin(request, response);
                break;
            case "Login":
                Login(request, response);
                break;
            case "Logout":
                Logout(request, response);
                break;
            case "Regist":
                Regist(request, response);
                break;
            case "rRegister":
                rRegister(request, response);
                break;
            case "Register":
                Register(request, response);
                break;
            case "RegisterAccount":
                RegisterAccount(request, response);
                break;
            case "rChangePass":
                rChangePass(request, response);
                break;
            case "ChangePass":
                ChangePass(request, response);
                break;
            case "rForgotPass":
                rForgotPass(request, response);
                break;
            case "rForgotsPass":
                rForgotsPass(request, response);
                break;
            case "NextForgotPass":
                NextForgotPass(request, response);
                break;
            case "ConfirmForgotPass":
                ConfirmForgotPass(request, response);
                break;
            case "ForgotPass":
                ForgotPass(request, response);
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
            case "Notification":
                Notification(request, response);
                break;
            case "ViewDetailsClubs":
                ViewDetailsClubs(request, response);
                break;
            case "LoadDetailsClubs":
                LoadDetailsClubs(request, response);
                break;
            case "EditDetailsClubs":
                EditDetailsClubs(request, response);
                break;
            case "CancelRequestClub":
                CancelRequestClub(request, response);
                break;
            case "ResendRequestClub":
                ResendRequestClub(request, response);
                break;
            case "ViewDetailsJoins":
                ViewDetailsJoins(request, response);
                break;
            case "CancelRequestJoin":
                CancelRequestJoin(request, response);
                break;
            case "ResendRequestJoin":
                ResendRequestJoin(request, response);
                break;
            case "ViewDetailsPosts":
                ViewDetailsPosts(request, response);
                break;
            case "LoadDetailsPosts":
                LoadDetailsPosts(request, response);
                break;
            case "EditDetailsPosts":
                EditDetailsPosts(request, response);
                break;
            case "CancelRequestPost":
                CancelRequestPost(request, response);
                break;
            case "ResendRequestPost":
                ResendRequestPost(request, response);
                break;
            case "ViewDetailsEvents":
                ViewDetailsEvents(request, response);
                break;
            case "LoadDetailsEvents":
                LoadDetailsEvents(request, response);
                break;
            case "EditDetailsEvents":
                EditDetailsEvents(request, response);
                break;
            case "CancelRequestEvent":
                CancelRequestEvent(request, response);
                break;
            case "ResendRequestEvent":
                ResendRequestEvent(request, response);
                break;
            case "ClubsList":
                ClubsList(request, response);
                break;
            case "ViewDetailsClub":
                ViewDetailsClub(request, response);
                break;
            case "SearchClub":
                SearchClub(request, response);
                break;
            case "rCreateClub":
                rCreateClub(request, response);
                break;
            case "CreateClub":
                CreateClub(request, response);
                break;
            case "JoinClub":
                JoinClub(request, response);
                break;
            case "ForCreator":
                ForCreator(request, response);
                break;
            case "ForManager":
                ForManager(request, response);
                break;
            case "ForMember":
                ForMember(request, response);
                break;
            case "IsCreator":
                IsCreator(request, response);
                break;
            case "IsManager":
                IsManager(request, response);
                break;
            case "IsMember":
                IsMember(request, response);
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
            case "ClubEvent":
                ClubEvent(request, response);
                break;
            case "ClubRating":
                ClubRating(request, response);
                break;
            case "SetToPublic":
                SetToPublic(request, response);
                break;
            case "SetToPrivate":
                SetToPrivate(request, response);
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
            case "rVerification":
                rVerification(request, response);
                break;
            case "Verification":
                Verification(request, response);
                break;
            case "VerificationOTP":
                VerificationOTP(request, response);
                break;
            case "DeleteClub":
                DeleteClub(request, response);
                break;
            case "JoinClubRequestList":
                JoinClubRequestList(request, response);
                break;
            case "JoinRequestAccept":
                JoinRequestAccept(request, response);
                break;
            case "JoinRequestDecline":
                JoinRequestDecline(request, response);
                break;
            case "SetToManager":
                SetToManager(request, response);
                break;
            case "KickMember":
                KickMember(request, response);
                break;
            case "SetToMember":
                SetToMember(request, response);
                break;
            case "KickManager":
                KickManager(request, response);
                break;
            case "rCreatePost":
                rCreatePost(request, response);
                break;
            case "CreatePost":
                CreatePost(request, response);
                break;
            case "PostManage":
                PostManage(request, response);
                break;
            case "LoadEditPost":
                LoadEditPost(request, response);
                break;
            case "EditPost":
                EditPost(request, response);
                break;
            case "DeletePost":
                DeletePost(request, response);
                break;
            case "PostClubRequestList":
                PostClubRequestList(request, response);
                break;
            case "PostRequestAccept":
                PostRequestAccept(request, response);
                break;
            case "PostRequestDecline":
                PostRequestDecline(request, response);
                break;
            case "ViewComment":
                ViewComment(request, response);
                break;
            case "SetToComment":
                SetToComment(request, response);
                break;
            case "Comment":
                Comment(request, response);
                break;
            case "LoadEditComment":
                LoadEditComment(request, response);
                break;
            case "EditComment":
                EditComment(request, response);
                break;
            case "DeleteComment":
                DeleteComment(request, response);
                break;
            case "rCreateEvent":
                rCreateEvent(request, response);
                break;
            case "CreateEvent":
                CreateEvent(request, response);
                break;
            case "EventManage":
                EventManage(request, response);
                break;
            case "LoadEditEvent":
                LoadEditEvent(request, response);
                break;
            case "EditEvent":
                EditEvent(request, response);
                break;
            case "DeleteEvent":
                DeleteEvent(request, response);
                break;
            case "EventAttendeesList":
                EventAttendeesList(request, response);
                break;
            case "JoinEvent":
                JoinEvent(request, response);
                break;
            case "CancelEvent":
                CancelEvent(request, response);
                break;
            case "rCreateRating":
                rCreateRating(request, response);
                break;
            case "CreateRating":
                CreateRating(request, response);
                break;
            case "LoadEditRating":
                LoadEditRating(request, response);
                break;
            case "EditRating":
                EditRating(request, response);
                break;
            case "DeleteRating":
                DeleteRating(request, response);
                break;
            case "LoadChat":
                LoadChat(request, response);
                break;
            case "ExitClub":
                ExitClub(request, response);
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
        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        request.getRequestDispatcher("user/Home.jsp").forward(request, response);
    }

    private void rLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        request.getRequestDispatcher("user/Login.jsp").forward(request, response);
    }

    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String acc = request.getParameter("acc");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.checkUserLogin(acc, pass);
        Admin admin = new Admin(acc, pass);
        boolean check = AdminDao.login(admin);

        if (user == null && check == false) {
            request.getSession().setAttribute("warning", "Incorrect account or password!");
            response.sendRedirect("user?command=rLogin");
        } else if (check) {
            request.getSession().setAttribute("username", acc);
            request.getSession().setAttribute("password", pass);
            request.getSession().setAttribute("check", "check");
            response.sendRedirect("AdminControllerServlet?command=LOGIN");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("account", user);
            session.setMaxInactiveInterval(999999);

            if (remember != null && remember.equals("on")) {
                Cookie rememberUser = new Cookie("rAcc", acc);
                Cookie rememberPass = new Cookie("rPass", pass);
                rememberUser.setMaxAge(60000);
                rememberPass.setMaxAge(60000);
                response.addCookie(rememberUser);
                response.addCookie(rememberPass);
                session.setAttribute("password", pass);
                session.setAttribute("remember", remember);
            }
            CheckClubCreatorOrManagerOrMember(request, response);
        }
    }

    private void CheckClubCreatorOrManagerOrMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String recipientEmail = (String) session.getAttribute("recipientEmail");

        UserDAO userDAO = new UserDAO();
        LocalDate currentDate = LocalDate.now();

        if (recipientEmail != null && recipientEmail.equals(user.getEmail())) {
            userDAO.insertNotification("Register Success", "Wish you have a really good experience", user.getID(), 1, 1, 1, 1, java.sql.Date.valueOf(currentDate));
        }

        if (user != null) {
            Club clubCreator = userDAO.getClubCreatorFromUserID(user.getID());
            String isManager = userDAO.getClubManagerFromUserID(user.getID());
            String isMember = userDAO.getClubMemberFromUserID(user.getID());
            if (clubCreator != null && isManager != null && isMember != null) {
                session.setAttribute("clubCreator", clubCreator);
                session.setAttribute("clubManager", isManager);
                session.setAttribute("clubMember", isMember);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else if (clubCreator != null && isManager != null && isMember == null) {
                session.setAttribute("clubCreator", clubCreator);
                session.setAttribute("clubManager", isManager);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else if (clubCreator != null && isManager == null && isMember != null) {
                session.setAttribute("clubCreator", clubCreator);
                session.setAttribute("clubMember", isMember);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else if (clubCreator != null && isManager == null && isMember == null) {
                session.setAttribute("clubCreator", clubCreator);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else if (clubCreator == null && isManager != null && isMember != null) {
                session.setAttribute("clubManager", isManager);
                session.setAttribute("clubMember", isMember);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else if (clubCreator == null && isManager != null && isMember == null) {
                session.setAttribute("clubManager", isManager);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else if (clubCreator == null && isManager == null && isMember != null) {
                session.setAttribute("clubMember", isMember);
                session.setMaxInactiveInterval(999999);
                response.sendRedirect("user?command=Home");
            } else {
                response.sendRedirect("user?command=Home");
            }
        } else {
            response.sendRedirect("user?command=rLogin");
        }
    }

    private void Logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("user?command=Home");
    }

    private void Regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        String next = (String) request.getSession().getAttribute("next");
        if (next != null && !next.isBlank()) {
            request.getSession().removeAttribute("next");
        }
        request.getRequestDispatcher("user/Register.jsp").forward(request, response);
    }

    private void rRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        request.getRequestDispatcher("user/Register.jsp").forward(request, response);
    }

    private String extractUsername(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex != -1) {
            return email.substring(0, atIndex);
        }
        return email;
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 32) {
            return false;
        }

        if (!Character.isUpperCase(password.charAt(0))) {
            return false;
        }

        if (!password.matches(".*\\d.*")) {
            return false;
        }

        Pattern pattern = Pattern.compile("[!@#$%^&*()_+=|<>?{}\\[\\]~-]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }

    private boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private void Register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String acc = request.getParameter("acc");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");

        if (acc == null || acc.isBlank() || pass == null || pass.isBlank() || repass == null || repass.isBlank()) {
            request.getSession().setAttribute("warning", "Please complete all information!");
            response.sendRedirect("user?command=Regist");
        } else {
            UserDAO userDAO = new UserDAO();

            if (!pass.equals(repass)) {
                request.setAttribute("Acc", acc);
                request.getSession().setAttribute("warning", "Incorrect password or repassword!");
                response.sendRedirect("user?command=Regist");
            } else if (!isValidPassword(pass)) {
                request.getSession().setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
                response.sendRedirect("user?command=Regist");
            } else if (!containsLowercase(pass)) {
                request.getSession().setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
                response.sendRedirect("user?command=Regist");
            } else {
                User u = userDAO.checkUserEmail(acc);
                if (u == null) {
                    String recipientEmail = request.getParameter("acc");
                    String OTP = getRandom();
                    SendEmail emailSender = new SendEmail();
                    emailSender.sendEmail(recipientEmail, OTP, "OTP code to register your account");
                    request.getSession().setAttribute("next", "next");
                    session.setAttribute("userName", capitalized(extractUsername(acc)));
                    session.setAttribute("userEmail", acc);
                    session.setAttribute("userPass", pass);
                    session.setAttribute("recipientEmail", recipientEmail);
                    session.setAttribute("OTP", OTP);
                    response.sendRedirect("user?command=rRegister");
                } else {
                    request.getSession().setAttribute("warning", "Email already exists!");
                    response.sendRedirect("user?command=Regist");
                }
            }
        }
    }

    private void RegisterAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String otp = request.getParameter("otp");

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String userEmail = (String) session.getAttribute("userEmail");
        String userPass = (String) session.getAttribute("userPass");
        String recipientEmail = (String) session.getAttribute("recipientEmail");
        String OTP = (String) session.getAttribute("OTP");

        if (otp == null || otp.isBlank()) {
            request.getSession().setAttribute("next", "next");
            request.getSession().setAttribute("warning", "Please enter your otp code!");
            response.sendRedirect("user?command=rRegister");
        } else {
            if (OTP == null) {
                request.getSession().setAttribute("next", "next");
                request.getSession().setAttribute("warning", "Your otp code has expired or already used!");
                response.sendRedirect("user?command=rRegister");
            } else if (!OTP.equals(otp)) {
                request.getSession().setAttribute("next", "next");
                request.getSession().setAttribute("warning", "Incorrect verification code!");
                response.sendRedirect("user?command=rRegister");
            } else {
                if (recipientEmail != null && OTP != null && OTP.equals(otp)) {
                    UserDAO userDAO = new UserDAO();
                    userDAO.insertUser(userName, userEmail, userPass);
                    request.getSession().removeAttribute("next");
                    request.getSession().setAttribute("warning", "Register Successfully!\nPlease Login!");
                    response.sendRedirect("user?command=rLogin");
                } else {
                    request.getSession().setAttribute("warning", "Time out, please verify again!");
                    response.sendRedirect("user?command=Regist");
                }
            }
        }
    }

    private void rChangePass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            request.getRequestDispatcher("user/ChangePassword.jsp").forward(request, response);
        }
    }

    private void ChangePass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String currentPass = request.getParameter("crPass");
        String newPass = request.getParameter("nPass");
        String confirmPass = request.getParameter("cfPass");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        UserDAO userDAO = new UserDAO();

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else if (currentPass == null || currentPass.isBlank() || newPass == null || newPass.isBlank() || confirmPass == null || confirmPass.isBlank()) {
            request.getSession().setAttribute("warning", "Please complete all information!");
            response.sendRedirect("user?command=rChangePass");
        } else if (!newPass.equals(confirmPass)) {
            request.getSession().setAttribute("warning", "Incorrect new password or confirm password!");
            response.sendRedirect("user?command=rChangePass");
        } else if (!isValidPassword(newPass)) {
            request.getSession().setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
            response.sendRedirect("user?command=rChangePass");
        } else if (!containsLowercase(newPass)) {
            request.getSession().setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
            response.sendRedirect("user?command=rChangePass");
        } else {
            User check = userDAO.checkUserLogin(user.getEmail(), currentPass);
            if (check == null) {
                request.getSession().setAttribute("warning", "Incorrect current password!");
                response.sendRedirect("user?command=rChangePass");
            } else {
                userDAO.changePassword(user.getEmail(), newPass);
                request.getSession().setAttribute("warning", "Change password success!");
                response.sendRedirect("user?command=rChangePass");
            }
        }
    }

    private String getRandom() {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        return String.format("%06d", number);
    }

    private boolean isValidOTP(String otp) {
        if (!otp.matches("\\d+")) {
            return false;
        }
        if (otp.length() != 6) {
            return false;
        }
        return true;
    }

    private void rForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String back = request.getParameter("fr");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        String next = (String) request.getSession().getAttribute("next");
        if (next != null && !next.isBlank()) {
            request.getSession().removeAttribute("next");
        }
        if (back != null && back.equals("FCP")) {
            session.setAttribute("fr", "rChangePass");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        } else if (back != null && back.equals("FL")) {
            session.setAttribute("fr", "rLogin");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        }
    }

    private void rForgotsPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        String otp = (String) request.getSession().getAttribute("otp");
        if (otp != null && !otp.isBlank()) {
            request.getSession().setAttribute("next", "next");
            request.getSession().removeAttribute("otp");
        }
        request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
    }

    private void NextForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String recipientEmail = request.getParameter("email");
        String OTP = getRandom();

        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        User email = userDAO.checkUserEmail(recipientEmail);

        if (recipientEmail == null || recipientEmail.isBlank()) {
            request.getSession().setAttribute("warning", "Please enter your email!");
            response.sendRedirect("user?command=rForgotPass");
        } else {
            if (email == null) {
                request.getSession().setAttribute("warning", "Email does not exist!");
                response.sendRedirect("user?command=rForgotPass");
            } else {
                SendEmail emailSender = new SendEmail();
                emailSender.sendEmail(recipientEmail, OTP, "OTP code to reset your password");
                request.getSession().setAttribute("next", "next");
                session.setAttribute("email", recipientEmail);
                session.setAttribute("OTP", OTP);
                response.sendRedirect("user?command=rForgotsPass");
            }
        }
    }

    private void ConfirmForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String otp = request.getParameter("otp");

        HttpSession session = request.getSession();
        String OTP = (String) session.getAttribute("OTP");

        if (otp == null || otp.isBlank()) {
            request.getSession().setAttribute("next", "next");
            request.getSession().setAttribute("warning", "Please enter your OTP code!");
            response.sendRedirect("user?command=rForgotsPass");
        } else if (!isValidOTP(otp)) {
            request.getSession().setAttribute("next", "next");
            request.getSession().setAttribute("warning", "Your OTP code consists of 6 digits!");
            response.sendRedirect("user?command=rForgotsPass");
        } else {
            if (OTP == null) {
                request.getSession().setAttribute("next", "next");
                request.getSession().setAttribute("warning", "Your OTP code has expired or already used!");
                response.sendRedirect("user?command=rForgotsPass");
            } else if (!OTP.equals(otp)) {
                request.getSession().setAttribute("next", "next");
                request.getSession().setAttribute("warning", "Incorrect verification code!");
                response.sendRedirect("user?command=rForgotsPass");
            } else {
                session.setAttribute("otps", otp);
                request.getSession().setAttribute("otp", "otp");
                response.sendRedirect("user?command=rForgotPass");
            }
        }
    }

    private void ForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String newPass = request.getParameter("nPass");
        String confirmPass = request.getParameter("cfPass");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String OTP = (String) session.getAttribute("OTP");
        String otps = (String) session.getAttribute("otps");

        if (newPass == null || newPass.isBlank() || confirmPass == null || confirmPass.isBlank()) {
            request.getSession().setAttribute("otp", "otp");
            request.getSession().setAttribute("warning", "Please complete all information!");
            response.sendRedirect("user?command=rForgotPass");
        } else if (!newPass.equals(confirmPass)) {
            request.getSession().setAttribute("otp", "otp");
            request.getSession().setAttribute("warning", "Incorrect new password or confirm password!");
            response.sendRedirect("user?command=rForgotPass");
        } else if (!isValidPassword(newPass)) {
            request.getSession().setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
            response.sendRedirect("user?command=rForgotPass");
        } else if (!containsLowercase(newPass)) {
            request.getSession().setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
            response.sendRedirect("user?command=rForgotPass");
        } else {
            if (email != null && OTP != null && OTP.equals(otps)) {
                UserDAO userDAO = new UserDAO();
                userDAO.changePassword(email, newPass);
                request.getSession().removeAttribute("next");
                request.getSession().removeAttribute("otp");
                request.getSession().setAttribute("warning", "Change password success!\nPlease login!");
                response.sendRedirect("user?command=rLogin");
            } else {
                request.getSession().removeAttribute("otp");
                request.getSession().setAttribute("warning", "Time out, please verify again!");
                response.sendRedirect("user?command=rForgotPass");
            }
        }
    }

    private void LoadProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            int ID = user.getID();
            UserDAO userDAO = new UserDAO();

            User users = userDAO.getUserByID(ID);
            request.setAttribute("user", users);
            request.getRequestDispatcher("user/Profile.jsp").forward(request, response);
        }
    }

    private void LoadEditProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            int ID = user.getID();
            UserDAO userDAO = new UserDAO();

            User users = userDAO.getUserByID(ID);
            request.setAttribute("user", users);
            request.getRequestDispatcher("user/EditProfile.jsp").forward(request, response);
        }
    }

    private String capitalize(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }

        String firstLetter = input.substring(0, 1);
        String remainingLetters = input.substring(1);

        return firstLetter.toUpperCase() + remainingLetters.toLowerCase();
    }

    private String capitalized(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }

        String[] words = input.split("\\s+");
        StringBuilder capitalizedSentence = new StringBuilder();

        for (String word : words) {
            if (!word.isBlank()) {
                String firstLetter = word.substring(0, 1);
                String remainingLetters = word.substring(1);
                String capitalizedWord = firstLetter.toUpperCase() + remainingLetters.toLowerCase();
                capitalizedSentence.append(capitalizedWord).append(" ");
            }
        }
        return capitalizedSentence.toString().trim();
    }

    private boolean isValidDOB(String dateString) {
        try {
            LocalDate birthDate = LocalDate.parse(dateString);
            LocalDate currentDate = LocalDate.now();

            if (birthDate.isAfter(currentDate)) {
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidYear(String dateString, int minYear, int maxYear) {
        try {
            LocalDate birthDate = LocalDate.parse(dateString);

            int year = birthDate.getYear();

            if (year <= minYear) {
                return false;
            }

            if (year >= maxYear) {
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private void EditProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DateTimeParseException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String image = request.getParameter("image");

        User user = (User) session.getAttribute("account");

        boolean isValidPhone = phone.matches("0[35789]\\d{8}");

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            int ID = user.getID();
            UserDAO userDAO = new UserDAO();

            if (name == null || email == null || phone == null || dob == null || gender == null
                    || name.isBlank() || email.isBlank() || phone.isBlank() || dob.isBlank() || gender.isBlank()) {
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditProfile");
            } else {
                String dateStr = dob;
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
                String formattedDate = localDate.format(outputFormatter);
                if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
                    request.getSession().setAttribute("warning", "Please type 'Male' or 'Female' or 'Other'");
                    response.sendRedirect("user?command=LoadEditProfile");
                } else if (!isValidPhone) {
                    request.getSession().setAttribute("warning", "Please type correct phone number format!");
                    response.sendRedirect("user?command=LoadEditProfile");
                } else if (!isValidDOB(formattedDate) || !isValidYear(formattedDate, 1995, 2006)) {
                    request.getSession().setAttribute("warning", "Please type correct birthDay and birthYear must be before 2005 and after 1995!");
                    response.sendRedirect("user?command=LoadEditProfile");
                } else {
                    userDAO.editUser(capitalized(name), email, phone, formattedDate, capitalize(gender), image, ID);
                    response.sendRedirect("user?command=LoadProfile");
                }
            }
        }
    }

    private void Notification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("memberID");
        session.removeAttribute("postID");
        session.removeAttribute("eventID");
        User user = (User) session.getAttribute("account");

        UserDAO userDAO = new UserDAO();

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            ArrayList<Notification> notification = userDAO.getAllNotification(user.getID());
            request.setAttribute("notification", notification);
            request.setAttribute("notifications", notification.size());
            request.getRequestDispatcher("user/Notification.jsp").forward(request, response);
        }
    }

    private void ViewDetailsClubs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubID = request.getParameter("cID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String checkClubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (checkClubID == null || checkClubID.isBlank()) {
            if (user == null) {
                response.sendRedirect("user?command=rLogin");
            } else if (clubID == null || clubID.isBlank()) {
                response.sendRedirect("user?command=Notification");
            } else {
                Club clubDetails = userDAO.getClubDetails(clubID);
                request.setAttribute("club", clubDetails);
                request.setAttribute("vclub", "club");
                session.setAttribute("clubID", clubID);
                request.getSession().removeAttribute("code");
                request.getSession().removeAttribute("name");
                request.getSession().removeAttribute("description");
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        } else {
            if (!checkClubID.equals(clubID)) {
                response.sendRedirect("user?command=Notification");
            } else {
                if (user == null) {
                    response.sendRedirect("user?command=rLogin");
                } else if (clubID == null || clubID.isBlank()) {
                    response.sendRedirect("user?command=Notification");
                } else {
                    Club clubDetails = userDAO.getClubDetails(clubID);
                    request.setAttribute("club", clubDetails);
                    request.setAttribute("vclub", "club");
                    request.getSession().removeAttribute("code");
                    request.getSession().removeAttribute("name");
                    request.getSession().removeAttribute("description");
                    request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
                }
            }
        }
    }

    private void LoadDetailsClubs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            if (clubID == null) {
                response.sendRedirect("user?command=Notification");
            } else {
                Club clubDetails = userDAO.getClubDetails(clubID);
                request.setAttribute("club", clubDetails);
                request.setAttribute("vclub", "club");
                request.setAttribute("eclub", "club");
                session.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        }
    }

    private void EditDetailsClubs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();

            if (code == null || code.isBlank()) {
                request.getSession().setAttribute("code", "code");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadDetailsClubs");
            } else if (name == null || name.isBlank()) {
                request.getSession().setAttribute("name", "name");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadDetailsClubs");
            } else if (description == null || description.isBlank()) {
                request.getSession().setAttribute("description", "description");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadDetailsClubs");
            } else if (code.length() != 3) {
                request.getSession().setAttribute("warning", "Club Code must be 3 letters!");
                response.sendRedirect("user?command=LoadDetailsClubs");
            } else if (!isString(code)) {
                request.getSession().setAttribute("warning", "Club Code must be letters!");
                response.sendRedirect("user?command=LoadDetailsClubs");
            } else {
                userDAO.editClub(code.toUpperCase(), name, description, clubID);
                response.sendRedirect("user?command=ViewDetailsClubs&cID=" + clubID);
            }
        }
    }

    private void CancelRequestClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.cancelRequestClub(clubID);
            response.sendRedirect("user?command=ViewDetailsClubs&cID=" + clubID);
        }
    }

    private void ResendRequestClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.resendRequestClub(clubID);
            response.sendRedirect("user?command=ViewDetailsClubs&cID=" + clubID);
        }
    }

    private void ViewDetailsJoins(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String checkMemberID = (String) session.getAttribute("memberID");

        UserDAO userDAO = new UserDAO();

        if (checkMemberID == null || checkMemberID.isBlank()) {
            if (user == null) {
                response.sendRedirect("user?command=rLogin");
            } else if (memberID == null || memberID.isBlank()) {
                response.sendRedirect("user?command=Notification");
            } else {
                Member memberDetails = userDAO.getMemberDetails(memberID);
                request.setAttribute("member", memberDetails);
                request.setAttribute("vmember", "member");
                session.setAttribute("memberID", memberID);
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        } else {
            if (!checkMemberID.equals(memberID)) {
                response.sendRedirect("user?command=Notification");
            } else {
                if (user == null) {
                    response.sendRedirect("user?command=rLogin");
                } else if (memberID == null || memberID.isBlank()) {
                    response.sendRedirect("user?command=Notification");
                } else {
                    Member memberDetails = userDAO.getMemberDetails(memberID);
                    request.setAttribute("member", memberDetails);
                    request.setAttribute("vmember", "member");
                    request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
                }
            }
        }
    }

    private void CancelRequestJoin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String memberID = (String) session.getAttribute("memberID");

        if (memberID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.cancelRequestJoin(memberID);
            response.sendRedirect("user?command=ViewDetailsJoins&mID=" + memberID);
        }
    }

    private void ResendRequestJoin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String memberID = (String) session.getAttribute("memberID");

        if (memberID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.resendRequestJoin(memberID);
            response.sendRedirect("user?command=ViewDetailsJoins&mID=" + memberID);
        }
    }

    private void ViewDetailsPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String checkPostID = (String) session.getAttribute("postID");

        UserDAO userDAO = new UserDAO();
        if (checkPostID == null || checkPostID.isBlank()) {
            if (user == null) {
                response.sendRedirect("user?command=rLogin");
            } else if (postID == null || postID.isBlank()) {
                response.sendRedirect("user?command=Notification");
            } else {
                Post postDetails = userDAO.getPostDetails(postID);
                request.setAttribute("post", postDetails);
                request.setAttribute("vpost", "post");
                session.setAttribute("postID", postID);
                request.getSession().removeAttribute("title");
                request.getSession().removeAttribute("description");
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        } else {
            if (!checkPostID.equals(postID)) {
                response.sendRedirect("user?command=Notification");
            } else {
                if (user == null) {
                    response.sendRedirect("user?command=rLogin");
                } else if (postID == null || postID.isBlank()) {
                    response.sendRedirect("user?command=Notification");
                } else {
                    Post postDetails = userDAO.getPostDetails(postID);
                    request.setAttribute("post", postDetails);
                    request.setAttribute("vpost", "post");
                    request.getSession().removeAttribute("title");
                    request.getSession().removeAttribute("description");
                    request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
                }
            }
        }
    }

    private void LoadDetailsPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String postID = (String) session.getAttribute("postID");

        UserDAO userDAO = new UserDAO();
        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            if (postID == null) {
                response.sendRedirect("user?command=Notification");
            } else {
                Post postDetails = userDAO.getPostDetails(postID);
                request.setAttribute("post", postDetails);
                request.setAttribute("vpost", "post");
                request.setAttribute("epost", "post");
                session.setAttribute("postID", postID);
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        }
    }

    private void EditDetailsPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        String postID = (String) session.getAttribute("postID");

        UserDAO userDAO = new UserDAO();

        if (postID != null) {
            if (title == null || title.isBlank()) {
                request.getSession().setAttribute("title", "title");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadDetailsPosts");
            } else if (description == null || description.isBlank()) {
                request.getSession().setAttribute("description", "description");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadDetailsPosts");
            } else {
                userDAO.editPost(title, description, postID);
                response.sendRedirect("user?command=ViewDetailsPosts&pID=" + postID);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void CancelRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String postID = (String) session.getAttribute("postID");

        if (postID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.cancelRequestPost(postID);
            response.sendRedirect("user?command=ViewDetailsPosts&pID=" + postID);
        }
    }

    private void ResendRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String postID = (String) session.getAttribute("postID");

        if (postID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.resendRequestPost(postID);
            response.sendRedirect("user?command=ViewDetailsPosts&pID=" + postID);
        }
    }

    private void ViewDetailsEvents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String checkEventID = (String) session.getAttribute("eventID");

        UserDAO userDAO = new UserDAO();
        if (checkEventID == null || checkEventID.isBlank()) {
            if (user == null) {
                response.sendRedirect("user?command=rLogin");
            } else if (eventID == null || eventID.isBlank()) {
                response.sendRedirect("user?command=Notification");
            } else {
                Event eventDetails = userDAO.getEventDetails(eventID);
                request.setAttribute("event", eventDetails);
                request.setAttribute("vevent", "event");
                session.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        } else {
            if (!checkEventID.equals(eventID)) {
                response.sendRedirect("user?command=Notification");
            } else {
                if (user == null) {
                    response.sendRedirect("user?command=rLogin");
                } else if (eventID == null || eventID.isBlank()) {
                    response.sendRedirect("user?command=Notification");
                } else {
                    Event eventDetails = userDAO.getEventDetails(eventID);
                    request.setAttribute("event", eventDetails);
                    request.setAttribute("vevent", "event");
                    request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
                }
            }
        }
    }

    private void LoadDetailsEvents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String eventID = (String) session.getAttribute("eventID");

        UserDAO userDAO = new UserDAO();
        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            if (eventID == null) {
                response.sendRedirect("user?command=Notification");
            } else {
                Event eventDetails = userDAO.getEventDetails(eventID);
                request.setAttribute("event", eventDetails);
                request.setAttribute("vevent", "event");
                request.setAttribute("eevent", "event");
                session.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/ViewDetailsNotification.jsp").forward(request, response);
            }
        }
    }

    private void EditDetailsEvents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String olddate = request.getParameter("olddate");
        String newdate = request.getParameter("newdate");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        String eventID = (String) session.getAttribute("eventID");

        UserDAO userDAO = new UserDAO();
        String dateStr = olddate;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        if (eventID != null) {
            if (name == null || name.isBlank()) {
                request.getSession().setAttribute("name", "name");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
            } else if (description == null || description.isBlank()) {
                request.getSession().setAttribute("description", "description");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
            } else if (newdate == null || newdate.isBlank()) {
                userDAO.editEvent(name, formattedDate, description, eventID);
                response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
            } else if (!newdate.isBlank() && isDateAfterToday(newdate)) {
                userDAO.editEvent(name, newdate, description, eventID);
                response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
            } else {
                request.getSession().setAttribute("warning", "Please select after current date!");
                response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void CancelRequestEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String eventID = (String) session.getAttribute("eventID");

        if (eventID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.cancelRequestEvent(eventID);
            response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
        }
    }

    private void ResendRequestEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String eventID = (String) session.getAttribute("eventID");

        if (eventID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.resendRequestEvent(eventID);
            response.sendRedirect("user?command=ViewDetailsEvents&eID=" + eventID);
        }
    }

    private void ClubsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        session.removeAttribute("notfound");

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
        String clubCreatorID = request.getParameter("cCID");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");
        UserDAO userDAO = new UserDAO();

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else if (clubID == null || clubID.isBlank() || clubCreatorID == null || clubCreatorID.isBlank()) {
            response.sendRedirect("user?command=ClubsList");
        } else {
            Club club = userDAO.getClubByID(clubID);
            String ClubCreatorName = userDAO.getClubCreatorName(clubCreatorID);
            request.setAttribute("club", club);
            request.setAttribute("clubCreatorName", ClubCreatorName);
            request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
        }
    }

    private boolean isString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private void SearchClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");

        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();

        if (search == null || search.isBlank()) {
            session.removeAttribute("notfound");
            response.sendRedirect("user?command=ClubsList");
        } else {
            ArrayList<Club> clubs = userDAO.searchClubs(search);
            Club club = userDAO.searchClub(search);
            if (club == null) {
                request.setAttribute("search", search);
                session.setAttribute("notfound", "notfound");
                request.getRequestDispatcher("user/ClubsList.jsp").forward(request, response);
            } else {
                request.setAttribute("club", clubs);
                request.setAttribute("clubs", clubs.size());
                request.setAttribute("search", search);
                session.removeAttribute("notfound");
                request.getRequestDispatcher("user/ClubsList.jsp").forward(request, response);
            }
        }
    }

    private void rCreateClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        request.getRequestDispatcher("user/CreateClub.jsp").forward(request, response);
    }

    private void CreateClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubCode = request.getParameter("cCode");
        String clubName = request.getParameter("cName");
        String clubDescription = request.getParameter("cDescription");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        UserDAO userDAO = new UserDAO();
        LocalDate currentDate = LocalDate.now();

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            if (clubCode == null || clubName == null || clubDescription == null
                    || clubCode.isBlank() || clubName.isBlank() || clubDescription.isBlank()) {
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=rCreateClub");
            } else if (clubCode.length() != 3) {
                request.getSession().setAttribute("warning", "Club Code must be 3 letters!");
                response.sendRedirect("user?command=rCreateClub");
            } else if (!isString(clubCode)) {
                request.getSession().setAttribute("warning", "Club Code must be letters!");
                response.sendRedirect("user?command=rCreateClub");
            } else {
                int clubID = userDAO.checkClubID(clubCode.toUpperCase(), clubName, clubDescription, user.getID(), java.sql.Date.valueOf(currentDate));
//                int clubID = userDAO.checkClubID();
                userDAO.insertNotification("Create Club", "Pending", user.getID(), clubID, 1, 1, 1, java.sql.Date.valueOf(currentDate));
                request.getSession().setAttribute("warning", "Please wait for admin to accept!");
                response.sendRedirect("user?command=rCreateClub");
            }
        }
    }

    private void JoinClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubID = request.getParameter("cID");
        String clubName = request.getParameter("cN");
        String clubCreatorID = request.getParameter("cCID");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        LocalDate currentDate = LocalDate.now();

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else if (clubID == null || clubID.isBlank() || clubName == null || clubName.isBlank() || clubCreatorID == null || clubCreatorID.isBlank()) {
            response.sendRedirect("user?command=ClubsList");
        } else {
            UserDAO userDAO = new UserDAO();
            User checkUserIsMember = userDAO.checkUserIsMember(clubID, user.getID());
            User checkJoinRequestExist = userDAO.checkJoinRequestExist(clubID, user.getID());
            Club club = userDAO.getClubByID(clubID);
            Club clubStatus = userDAO.checkClubStatus(clubID);
            String ClubCreatorName = userDAO.getClubCreatorName(clubCreatorID);

            if (checkUserIsMember == null) {
                if (checkJoinRequestExist == null) {
                    if (clubStatus != null) {
                        userDAO.joinClubRequest(user.getID(), clubID, java.sql.Date.valueOf(currentDate));
                        int memberID = userDAO.getMemberID(user.getID(), clubID);
                        userDAO.insertNotification("Join Club", "Pending", user.getID(), Integer.parseInt(clubID), memberID, 1, 1, java.sql.Date.valueOf(currentDate));
                        request.setAttribute("club", club);
                        request.setAttribute("clubCreatorName", ClubCreatorName);
                        request.getSession().setAttribute("warning", "Please wait for the manager to accept!");
                        response.sendRedirect("user?command=ViewDetailsClub&cID=" + clubID + "&cCID=" + clubCreatorID + "");
                    } else {
                        userDAO.joinClubSuccess(user.getID(), clubID, java.sql.Date.valueOf(currentDate));
                        int memberID = userDAO.getMemberID(user.getID(), clubID);
                        userDAO.insertNotification("Join Club", "Welcome to the " + clubName + "Club", user.getID(), Integer.parseInt(clubID), memberID, 1, 1, java.sql.Date.valueOf(currentDate));
                        request.setAttribute("club", club);
                        request.setAttribute("clubCreatorName", ClubCreatorName);
                        String isMember = userDAO.getClubMemberFromUserID(user.getID());
                        session.setAttribute("clubMember", isMember);
                        session.setMaxInactiveInterval(999999);
                        request.getSession().setAttribute("warning", "Join club success!");
                        response.sendRedirect("user?command=ViewDetailsClub&cID=" + clubID + "&cCID=" + clubCreatorID + "");
                    }
                } else {
                    request.setAttribute("club", club);
                    request.setAttribute("clubCreatorName", ClubCreatorName);
                    request.getSession().setAttribute("warning", "Request has been sent!\nPlease wait for the manager to accept!");
                    response.sendRedirect("user?command=ViewDetailsClub&cID=" + clubID + "&cCID=" + clubCreatorID + "");
                }
            } else {
                request.setAttribute("club", club);
                request.setAttribute("clubCreatorName", ClubCreatorName);
                request.getSession().setAttribute("warning", "Already a member of this club!");
                response.sendRedirect("user?command=ViewDetailsClub&cID=" + clubID + "&cCID=" + clubCreatorID + "");
            }
        }
    }

    private void ForCreator(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            ArrayList<Club> clubCreator = userDAO.getClubCreator(user.getID());
            if (clubCreator != null) {
                request.setAttribute("clubCreator", clubCreator);
                request.getRequestDispatcher("user/ForCreator.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?command=Home");
            }
        }
    }

    private void ForManager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            ArrayList<Club> clubManager = userDAO.getClubManager(user.getID());
            if (clubManager != null) {
                request.setAttribute("clubManager", clubManager);
                request.getRequestDispatcher("user/ForManager.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?command=Home");
            }
        }
    }

    private void ForMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            ArrayList<Club> clubMember = userDAO.getClubMember(user.getID());
            if (clubMember != null) {
                request.setAttribute("clubMember", clubMember);
                request.getRequestDispatcher("user/ForMember.jsp").forward(request, response);
            } else {
                response.sendRedirect("user?command=Home");
            }
        }
    }

    private void IsCreator(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubID = request.getParameter("cID");
        String clubCreatorID = request.getParameter("cCID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else if (clubID == null || clubID.isBlank() || clubCreatorID == null || clubCreatorID.isBlank()) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int totalManager = userDAO.getTotalManager(clubID, clubCreatorID);
            int totalMember = userDAO.getTotalMember(clubID);
            int totalPost = userDAO.getTotalPost(clubID);
            int totalEvent = userDAO.getTotalEvent(clubID);
            int totalJoinClubRequest = userDAO.getTotalJoinClubRequest(clubID);
            int totalPostClubRequest = userDAO.getTotalPostClubRequest(clubID);
//            request.setAttribute("clubID", clubID);
            request.setAttribute("totalManager", totalManager);
            request.setAttribute("totalMember", totalMember);
            request.setAttribute("totalPost", totalPost);
            request.setAttribute("totalEvent", totalEvent);
            request.setAttribute("totalJoinClubRequest", totalJoinClubRequest);
            request.setAttribute("totalPostClubRequest", totalPostClubRequest);
            session.setAttribute("clubID", clubID);
            session.setAttribute("clubCreatorID", clubCreatorID);
            session.setAttribute("IsCreator", "IsCreator");
            session.setMaxInactiveInterval(999999);
            request.getRequestDispatcher("user/ClubHome.jsp").forward(request, response);
        }
    }

    private void IsManager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubID = request.getParameter("cID");
        String clubCreatorID = request.getParameter("cCID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else if (clubID == null || clubID.isBlank() || clubCreatorID == null || clubCreatorID.isBlank()) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int totalManager = userDAO.getTotalManager(clubID, clubCreatorID);
            int totalMember = userDAO.getTotalMember(clubID);
            int totalPost = userDAO.getTotalPost(clubID);
            int totalEvent = userDAO.getTotalEvent(clubID);
            int totalJoinClubRequest = userDAO.getTotalJoinClubRequest(clubID);
            int totalPostClubRequest = userDAO.getTotalPostClubRequest(clubID);
//            request.setAttribute("clubID", clubID);
            request.setAttribute("totalManager", totalManager);
            request.setAttribute("totalMember", totalMember);
            request.setAttribute("totalPost", totalPost);
            request.setAttribute("totalEvent", totalEvent);
            request.setAttribute("totalJoinClubRequest", totalJoinClubRequest);
            request.setAttribute("totalPostClubRequest", totalPostClubRequest);
            session.setAttribute("clubID", clubID);
            session.setAttribute("clubCreatorID", clubCreatorID);
            session.setAttribute("IsManager", "IsManager");
            session.setMaxInactiveInterval(999999);
            request.getRequestDispatcher("user/ClubHome.jsp").forward(request, response);
        }
    }

    private void IsMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clubID = request.getParameter("cID");
        String clubCreatorID = request.getParameter("cCID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else if (clubID == null || clubID.isBlank() || clubCreatorID == null || clubCreatorID.isBlank()) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int totalManager = userDAO.getTotalManager(clubID, clubCreatorID);
            int totalMember = userDAO.getTotalMember(clubID);
            int totalPost = userDAO.getTotalPost(clubID);
            int totalEvent = userDAO.getTotalEvent(clubID);
            int totalJoinClubRequest = userDAO.getTotalJoinClubRequest(clubID);
            int totalPostClubRequest = userDAO.getTotalPostClubRequest(clubID);
//            request.setAttribute("clubID", clubID);
            request.setAttribute("totalManager", totalManager);
            request.setAttribute("totalMember", totalMember);
            request.setAttribute("totalPost", totalPost);
            request.setAttribute("totalEvent", totalEvent);
            request.setAttribute("totalJoinClubRequest", totalJoinClubRequest);
            request.setAttribute("totalPostClubRequest", totalPostClubRequest);
            session.setAttribute("clubID", clubID);
            session.setAttribute("clubCreatorID", clubCreatorID);
            session.setAttribute("IsMember", "IsMember");
            session.setMaxInactiveInterval(999999);
            request.getRequestDispatcher("user/ClubHome.jsp").forward(request, response);
        }
    }

    private void ClubManage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int joinRequest = userDAO.getJoinRequest(clubID);
            Club club = userDAO.getClubToManage(clubID);
            request.setAttribute("club", club);
            request.setAttribute("clubID", clubID);
            request.setAttribute("joinRequest", joinRequest);
            request.getRequestDispatcher("user/ClubManage.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ClubManager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");
        String clubCreatorID = (String) session.getAttribute("clubCreatorID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null || clubCreatorID != null) {
            ArrayList<Member> manager = userDAO.getClubManagersWithoutCreator(clubID, clubCreatorID);
            if (manager == null) {
                request.setAttribute("warning", "No manager yet");
                request.getRequestDispatcher("user/ClubManager.jsp").forward(request, response);
            } else {
                request.setAttribute("manager", manager);
                request.setAttribute("managers", manager.size());
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/ClubManager.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ClubMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");
        String clubCreatorID = (String) session.getAttribute("clubCreatorID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null || clubCreatorID != null) {
            ArrayList<Member> member = userDAO.getClubMembersWithoutCreator(clubID, clubCreatorID);
            if (member == null) {
                request.setAttribute("warning", "No member yet");
                request.getRequestDispatcher("user/ClubMember.jsp").forward(request, response);
            } else {
                request.setAttribute("member", member);
                request.setAttribute("members", member.size());
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/ClubMember.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ClubPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            ArrayList<Post> post = userDAO.getPostFromClubID(clubID);
            Post myPost = userDAO.getMyPost(memberID);
            if (post == null) {
                request.setAttribute("warning", "No post yet");
                request.getRequestDispatcher("user/ClubPost.jsp").forward(request, response);
            } else {
                request.setAttribute("post", post);
                request.setAttribute("posts", post.size());
                request.setAttribute("myPost", myPost);
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/ClubPost.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ClubEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            ArrayList<Event> event = userDAO.getEventFromClubID(clubID, memberID);
//            ArrayList<EventAttendees> joinEvents = userDAO.getEventAttendees(clubID, memberID);
//            EventAttendees joinEvent = userDAO.getEventAttendeess(clubID, memberID);
            if (event == null) {
                request.setAttribute("warning", "No event yet");
                request.getRequestDispatcher("user/ClubEvent.jsp").forward(request, response);
            } else {
                request.setAttribute("event", event);
                request.setAttribute("events", event.size());
                request.setAttribute("joinEvent", memberID);
//                request.setAttribute("joinEvents", joinEvents);
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/ClubEvent.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ClubRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            ArrayList<Rating> rating = userDAO.getRatingFromClubID(clubID);
            Rating myRating = userDAO.getMyRating(memberID);
            if (rating == null) {
                request.setAttribute("warning", "No rating yet");
                request.getRequestDispatcher("user/ClubRating.jsp").forward(request, response);
            } else {
                request.setAttribute("rating", rating);
                request.setAttribute("ratings", rating.size());
                request.setAttribute("myRating", myRating);
                request.setAttribute("clubID", clubID);
                request.getSession().removeAttribute("note");
                request.getRequestDispatcher("user/ClubRating.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void SetToPublic(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            userDAO.setClubToPublic(clubID);
            response.sendRedirect("user?command=ClubManage");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void SetToPrivate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            userDAO.setClubToPrivate(clubID);
            response.sendRedirect("user?command=ClubManage");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ViewClubDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Club clubs = userDAO.getClubToManage(clubID);
            request.setAttribute("club", clubs);
            request.setAttribute("clubID", clubID);
            request.getSession().removeAttribute("code");
            request.getSession().removeAttribute("name");
            request.getSession().removeAttribute("description");
            request.getRequestDispatcher("user/ViewClubDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void LoadEditClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Club clubs = userDAO.getClubToManage(clubID);
            request.setAttribute("club", clubs);
            request.setAttribute("clubID", clubID);
            request.getRequestDispatcher("user/EditClubDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EditClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {

            UserDAO userDAO = new UserDAO();

            if (code == null || code.isBlank()) {
                request.getSession().setAttribute("code", "code");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditClub");
            } else if (name == null || name.isBlank()) {
                request.getSession().setAttribute("name", "name");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditClub");
            } else if (description == null || description.isBlank()) {
                request.getSession().setAttribute("description", "description");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditClub");
            } else if (code.length() != 3) {
                request.getSession().setAttribute("warning", "Club Code must be 3 letters!");
                response.sendRedirect("user?command=LoadEditClub");
            } else if (!isString(code)) {
                request.getSession().setAttribute("warning", "Club Code must be letters!");
                response.sendRedirect("user?command=LoadEditClub");
            } else {
                userDAO.editClub(code.toUpperCase(), name, description, clubID);
                response.sendRedirect("user?command=ViewClubDetails");
            }
        }
    }

    private void rVerification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("user/Verification.jsp").forward(request, response);
        }
    }

    private void Verification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String otp = request.getParameter("otp");
        String getOTP = request.getParameter("getOTP");
        String verify = request.getParameter("verify");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID != null) {
            if (getOTP != null && getOTP.equals("Get OTP")) {
                if (email == null || email.isBlank()) {
                    request.getSession().setAttribute("warning", "Please add your email!");
                    response.sendRedirect("user?command=LoadProfile");
                } else {
                    String OTP = getRandom();
                    SendEmail sendEmail = new SendEmail();
                    sendEmail.sendEmail(email, OTP, "OTP code to delete your club");
                    session.setAttribute("OTP", OTP);
                    response.sendRedirect("user?command=rVerification");
                }
            } else if (verify != null && verify.equals("Verify")) {
                session.setAttribute("otp", otp);
                response.sendRedirect("user?command=VerificationOTP");
            } else {
                response.sendRedirect("user?command=Home");
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void VerificationOTP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String otp = (String) session.getAttribute("otp");
        String OTP = (String) session.getAttribute("OTP");
        String clubID = (String) session.getAttribute("clubID");

        if (clubID != null) {
            if (otp == null || otp.isBlank()) {
                request.getSession().setAttribute("warning", "Please enter your OTP code!");
                response.sendRedirect("user?command=rVerification");
            } else if (!isValidOTP(otp)) {
                request.getSession().setAttribute("warning", "Your OTP code consists of 6 digits!");
                response.sendRedirect("user?command=rVerification");
            } else {
                if (OTP == null) {
                    request.getSession().setAttribute("warning", "Your OTP code has expired or already used!");
                    response.sendRedirect("user?command=rVerification");
                } else if (!OTP.equals(otp)) {
                    request.getSession().setAttribute("warning", "Incorrect verification code!");
                    response.sendRedirect("user?command=rVerification");
                } else {
                    session.removeAttribute("otp");
                    session.removeAttribute("OTP");
                    response.sendRedirect("user?command=DeleteClub");
                }
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void DeleteClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
//            userDAO.deleteRatingClub(clubID);
//            userDAO.deleteEventAttendeesClub(clubID);
//            userDAO.deleteEventClub(clubID);
//            userDAO.deletePostCommentClub(clubID);
//            userDAO.deletePostClub(clubID);
//            userDAO.deleteChatClub(clubID);
//            userDAO.deleteMemberClub(clubID);
//            userDAO.deleteClub(clubID);
            response.sendRedirect("user?command=Home");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void JoinClubRequestList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            ArrayList<Member> joinClubRequestList = userDAO.getJoinRequestList(clubID);
            if (joinClubRequestList != null) {
                request.setAttribute("clubID", clubID);
                request.setAttribute("joinRequest", joinClubRequestList);
                request.setAttribute("joinRequests", joinClubRequestList.size());
                request.getRequestDispatcher("user/JoinClubRequest.jsp").forward(request, response);
            } else {
                request.setAttribute("warning", "No join club request yet!");
                request.getRequestDispatcher("user/JoinClubRequest.jsp").forward(request, response);
            }
        }
    }

    private void JoinRequestAccept(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        LocalDate currentDate = LocalDate.now();

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.getUserID(Integer.parseInt(memberID));
            userDAO.joinRequestAccept(java.sql.Date.valueOf(currentDate), memberID);
//            userDAO.insertNotification("Join Club", "Accepted", userID, java.sql.Date.valueOf(currentDate));
            response.sendRedirect("user?command=JoinClubRequestList");
        }
    }

    private void JoinRequestDecline(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        LocalDate currentDate = LocalDate.now();

        if (user == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.getUserID(Integer.parseInt(memberID));
            userDAO.joinRequestDecline(memberID);
//            userDAO.insertNotification("Join Club", "Not Accepted", userID, java.sql.Date.valueOf(currentDate));
            response.sendRedirect("user?command=JoinClubRequestList");
        }
    }

    private void SetToManager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.setToManager(memberID);
            response.sendRedirect("user?command=ClubManager");
        }
    }

    private void KickMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.deleteMember(memberID);
            response.sendRedirect("user?command=ClubMember");
        }
    }

    private void SetToMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String managerID = request.getParameter("mID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.setToMember(managerID);
            response.sendRedirect("user?command=ClubMember");
        }
    }

    private void KickManager(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String managerID = request.getParameter("mID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.deleteManager(managerID);
            response.sendRedirect("user?command=ClubManager");
        }
    }

    private void rCreatePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("user/CreatePost.jsp").forward(request, response);
    }

    private void CreatePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();
        LocalDate currentDate = LocalDate.now();

        if (clubID != null) {
            if (title == null || title.isBlank() || description == null || description.isBlank()) {
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=rCreatePost");
            } else {
                int memberID = userDAO.getMemberID(user.getID(), clubID);
                int isClubManager = userDAO.isClubManager(memberID);
                if (isClubManager == 1) {
                    userDAO.insertPost(title, description, java.sql.Date.valueOf(currentDate), memberID, clubID, "1", "0", "0");
                    response.sendRedirect("user?command=ClubPost");
                } else {
                    int postID = userDAO.checkPostID(title, description, java.sql.Date.valueOf(currentDate), memberID, clubID, "0", "1", "1");
//                    int postID = userDAO.checkPostID();
//                    System.out.println(postID);
                    userDAO.insertNotification("Create Post", "Pending", user.getID(), Integer.parseInt(clubID), memberID, postID, 1, java.sql.Date.valueOf(currentDate));
                    request.getSession().setAttribute("warning", "Please wait for the manager to accept!");
                    response.sendRedirect("user?command=rCreatePost");
                }
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void PostManage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            int clubCreatorID = userDAO.getClubCreatorID(clubID);
            int isClubCreatorID = userDAO.getMemberID(clubCreatorID, clubID);
            Post post = userDAO.getPost(clubID, postID);
            Post myPost = userDAO.getMyPost(postID, memberID);
            Post postOfClubCreator = userDAO.getPostOfClubCreator(postID, isClubCreatorID);
            if (post == null) {
                request.setAttribute("warning", "No post yet");
                request.getRequestDispatcher("user/PostManage.jsp").forward(request, response);
            } else if (postID == null || postID.isBlank()) {
                request.getSession().removeAttribute("title");
                request.getSession().removeAttribute("description");
                response.sendRedirect("user?command=ClubPost");
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                request.setAttribute("myPost", myPost);
                request.setAttribute("postOfClubCreator", postOfClubCreator);
                request.getSession().removeAttribute("title");
                request.getSession().removeAttribute("description");
                request.getRequestDispatcher("user/PostManage.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void LoadEditPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Post post = userDAO.getPost(clubID, postID);
            if (post == null) {
                request.setAttribute("warning", "No post yet");
                request.getRequestDispatcher("user/EditPost.jsp").forward(request, response);
            } else if (postID == null || postID.isBlank()) {
                request.getSession().removeAttribute("title");
                request.getSession().removeAttribute("description");
                response.sendRedirect("user?command=ClubPost");
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/EditPost.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EditPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            if (title == null || title.isBlank()) {
                request.getSession().setAttribute("title", "title");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditPost&pID=" + postID);
            } else if (description == null || description.isBlank()) {
                request.getSession().setAttribute("description", "description");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditPost&pID=" + postID);
            } else {
                userDAO.editPost(title, description, postID);
                response.sendRedirect("user?command=PostManage&pID=" + postID);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void DeletePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            userDAO.deletePostComment(postID);
            userDAO.deletePost(postID);
            response.sendRedirect("user?command=ClubPost");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void PostClubRequestList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            ArrayList<Post> postClubRequestList = userDAO.getPostRequestList(clubID);
            if (postClubRequestList != null) {
                request.setAttribute("clubID", clubID);
                request.setAttribute("postRequest", postClubRequestList);
                request.setAttribute("postRequests", postClubRequestList.size());
                request.getRequestDispatcher("user/PostClubRequest.jsp").forward(request, response);
            } else {
                request.setAttribute("warning", "No post club request yet!");
                request.getRequestDispatcher("user/PostClubRequest.jsp").forward(request, response);
            }
        }
    }

    private void PostRequestAccept(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");
        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        LocalDate currentDate = LocalDate.now();

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.getUserID(Integer.parseInt(memberID));
            userDAO.postRequestAccept(postID);
//            userDAO.insertNotification("Create Post", "Accepted", userID, java.sql.Date.valueOf(currentDate));
            response.sendRedirect("user?command=PostClubRequestList");
        }
    }

    private void PostRequestDecline(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");
        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        LocalDate currentDate = LocalDate.now();

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
        } else {
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.getUserID(Integer.parseInt(memberID));
            userDAO.postRequestDecline(postID);
//            userDAO.insertNotification("Create Post", "Not Accepted", userID, java.sql.Date.valueOf(currentDate));
            response.sendRedirect("user?command=PostClubRequestList");
        }
    }

    private void ViewComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            Post post = userDAO.getPost(clubID, postID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            PostComment myComment = userDAO.getMyComment(memberID);
//            ArrayList<PostComment> postComment = userDAO.getPostCommentTest(postID);
//            ArrayList<PostComment> myComments = userDAO.getMyComments(postID, memberID);
//            ArrayList<PostComment> notMyComments = userDAO.getNotMyComments(postID, memberID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else if (postID == null || postID.isBlank()) {
                request.getSession().removeAttribute("comments");
                response.sendRedirect("user?command=ClubPost");
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("postComment", postComment);
                request.setAttribute("postComments", postComment.size());
                request.setAttribute("clubID", clubID);
                request.setAttribute("commenterID", memberID);
                request.getSession().removeAttribute("comments");
//                request.setAttribute("myComment", myComment);
//                request.setAttribute("myComments", myComments);
//                request.setAttribute("notMyComments", notMyComments);
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void SetToComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
//            int memberID = userDAO.getMemberID(user.getID(), clubID);
            Post post = userDAO.getPost(clubID, postID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            PostComment myComment = userDAO.getMyComment(memberID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                request.setAttribute("postComment", postComment);
                request.setAttribute("comment", "comment");
//                request.setAttribute("myComment", myComment);
                ViewComment(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void Comment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();
        LocalDate currentDate = LocalDate.now();

        if (clubID != null) {
            int memberID = userDAO.getMemberIDFromPost(user.getID(), clubID);
            Post post = userDAO.getPost(clubID, postID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else {
                if (comment == null || comment.isBlank()) {
                    request.setAttribute("post", post);
                    request.setAttribute("pID", postID);
                    request.setAttribute("clubID", clubID);
                    request.setAttribute("postComment", postComment);
                    request.setAttribute("comment", "comment");
                    request.getSession().setAttribute("warning", "Please type a comment before send!");
                    response.sendRedirect("user?command=SetToComment&pID=" + postID);
                } else {
                    userDAO.insertComment(comment, java.sql.Date.valueOf(currentDate), postID, memberID);
                    request.setAttribute("post", post);
                    request.setAttribute("pID", postID);
                    request.setAttribute("postComment", postComment);
                    response.sendRedirect("user?command=ViewComment&pID=" + postID);
                }
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void LoadEditComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pcID = request.getParameter("pcID");
        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            Post post = userDAO.getPost(clubID, postID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            PostComment myComment = userDAO.getMyComment(memberID);
//            ArrayList<PostComment> postComment = userDAO.getPostCommentTest(postID);
//            ArrayList<PostComment> myComments = userDAO.getMyComments(postID, memberID);
//            ArrayList<PostComment> notMyComments = userDAO.getNotMyComments(postID, memberID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else if (pcID == null || pcID.isBlank() || postID == null || postID.isBlank()) {
                response.sendRedirect("user?command=ClubPost");
            } else {
                PostComment comment = userDAO.getComment(pcID);
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("postComment", postComment);
                request.setAttribute("thisComment", comment);
                request.setAttribute("clubID", clubID);
//                request.setAttribute("myComment", myComment);
//                request.setAttribute("myComments", myComments);
//                request.setAttribute("notMyComments", notMyComments);
                request.setAttribute("commenterID", memberID);
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EditComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");
        String pcID = request.getParameter("pcID");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
//            int memberID = userDAO.getMemberID(user.getID(), clubID);
            Post post = userDAO.getPost(clubID, postID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            PostComment myComment = userDAO.getMyComment(memberID);
//            ArrayList<PostComment> myComments = userDAO.getMyComments(postID, memberID);
//            ArrayList<PostComment> notMyComments = userDAO.getNotMyComments(postID, memberID);
            if (comment == null || comment.isBlank()) {
                PostComment thisComment = userDAO.getComment(pcID);
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("postComment", postComment);
                request.setAttribute("thisComment", thisComment);
                request.setAttribute("clubID", clubID);
                request.getSession().setAttribute("comments", "comment");
                request.getSession().setAttribute("warning", "Do not leave blank!");
//                request.setAttribute("myComment", myComment);
//                request.setAttribute("myComments", myComments);
//                request.setAttribute("notMyComments", notMyComments);
                response.sendRedirect("user?command=LoadEditComment&pID=" + postID + "&pcID=" + pcID);
            } else if (pcID == null || pcID.isBlank() || postID == null || postID.isBlank()) {
                response.sendRedirect("user?command=ClubPost");
            } else {
                userDAO.editComment(comment, pcID);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                request.getSession().removeAttribute("comments");
                response.sendRedirect("user?command=ViewComment&pID=" + postID);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void DeleteComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pcID = request.getParameter("pcID");
        String postID = request.getParameter("pID");
        int CommenterID = Integer.parseInt(request.getParameter("cmtID"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();
        LocalDate currentDate = LocalDate.now();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            int userID = userDAO.getUserID(CommenterID);
            ArrayList<Post> post = userDAO.getPostFromClubID(clubID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else {
                if (CommenterID != memberID) {
                    userDAO.deleteComment(pcID);
//                    userDAO.insertNotification("Delete Comment", "Comment content is not appropriate!", userID, Integer.parseInt(pcID), java.sql.Date.valueOf(currentDate));
                    request.setAttribute("post", post);
                    request.setAttribute("pID", postID);
                    request.setAttribute("postComment", postComment);
                    response.sendRedirect("user?command=ViewComment&pID=" + postID);
                } else {
                    userDAO.deleteComment(pcID);
                    request.setAttribute("post", post);
                    request.setAttribute("pID", postID);
                    request.setAttribute("postComment", postComment);
                    response.sendRedirect("user?command=ViewComment&pID=" + postID);
                }
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private boolean isDateAfterToday(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date selectedDate = null;
        try {
            selectedDate = dateFormat.parse(date);
        } catch (ParseException e) {
        }
        if (selectedDate != null) {
            Date currentDate = new Date();
            return selectedDate.after(currentDate);
        }
        return false;
    }

    private void rCreateEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("user/CreateEvent.jsp").forward(request, response);
    }

    private void CreateEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String date = request.getParameter("date");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        LocalDate currentDate = LocalDate.now();

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            if (name == null || name.isBlank() || description == null || description.isBlank() || date == null || date.isBlank()) {
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=rCreateEvent");
            } else if (!isDateAfterToday(date)) {
                request.getSession().setAttribute("warning", "Please select after current date!");
                response.sendRedirect("user?command=rCreateEvent");
            } else {
                int eventID = userDAO.checkEventID(name, description, java.sql.Date.valueOf(date), clubID);
//                int eventID = userDAO.checkEventID();
                userDAO.insertNotification("Create Event", "Pending", user.getID(), Integer.parseInt(clubID), memberID, 1, eventID, java.sql.Date.valueOf(currentDate));
                request.getSession().setAttribute("warning", "Please wait for admin to accept!");
                response.sendRedirect("user?command=rCreateEvent");
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EventManage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Event event = userDAO.getEvent(eventID);
            if (event == null) {
                request.setAttribute("warning", "No event yet!");
                request.getRequestDispatcher("user/EventManage.jsp").forward(request, response);
            } else if (eventID == null || eventID.isBlank()) {
                request.getSession().removeAttribute("name");
                request.getSession().removeAttribute("description");
                response.sendRedirect("user?command=ClubEvent");
            } else {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getSession().removeAttribute("name");
                request.getSession().removeAttribute("description");
                request.getRequestDispatcher("user/EventManage.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void LoadEditEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Event event = userDAO.getEvent(eventID);
            if (event == null) {
                request.setAttribute("warning", "No event yet!");
                request.getRequestDispatcher("user/EditEvent.jsp").forward(request, response);
            } else if (eventID == null || eventID.isBlank()) {
                request.getSession().removeAttribute("name");
                request.getSession().removeAttribute("description");
                response.sendRedirect("user?command=ClubEvent");
            } else {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/EditEvent.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EditEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String olddate = request.getParameter("olddate");
        String newdate = request.getParameter("newdate");
        String description = request.getParameter("description");
        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        String dateStr = olddate;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        if (clubID != null) {
            Event event = userDAO.getEvent(eventID);
            if (name == null || name.isBlank()) {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getSession().setAttribute("name", "name");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditEvent&eID=" + eventID);
            } else if (description == null || description.isBlank()) {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getSession().setAttribute("description", "description");
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=LoadEditEvent&eID=" + eventID);
            } else if (newdate.isBlank()) {
                userDAO.editEvent(name, formattedDate, description, eventID);
                response.sendRedirect("user?command=EventManage&eID=" + eventID);
            } else if (!newdate.isBlank() && isDateAfterToday(newdate)) {
                userDAO.editEvent(name, newdate, description, eventID);
                response.sendRedirect("user?command=EventManage&eID=" + eventID);
            } else if (eventID == null || eventID.isBlank()) {
                response.sendRedirect("user?command=ClubEvent");
            } else {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getSession().setAttribute("warning", "Please select after current date!");
                response.sendRedirect("user?command=LoadEditEvent&eID=" + eventID);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void DeleteEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            userDAO.deleteEventAttendeesList(eventID);
            userDAO.deleteEvent(eventID);
            response.sendRedirect("user?command=ClubEvent");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EventAttendeesList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            Event event = userDAO.getEvent(eventID);
            ArrayList<User> eventAttendees = userDAO.getEventAttendeesList(eventID);
            if (eventAttendees == null) {
                request.setAttribute("warning", "No attendees this event!");
                request.getRequestDispatcher("user/EventAttendeesList.jsp").forward(request, response);
            } else {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.setAttribute("eventAttendees", eventAttendees);
                request.setAttribute("eventAttendeess", eventAttendees.size());
                request.getRequestDispatcher("user/EventAttendeesList.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void JoinEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            EventAttendees check = userDAO.checkEventAttendees(eventID, memberID);
            if (check == null) {
                userDAO.insertEventAttendees(eventID, memberID);
                request.setAttribute("warning", "Join event success!");
                response.sendRedirect("user?command=ClubEvent");
            } else {
                userDAO.joinEventAttendees(eventID, memberID);
                request.setAttribute("warning", "Join event success!");
                response.sendRedirect("user?command=ClubEvent");
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void CancelEvent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String eventID = request.getParameter("eID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            userDAO.deleteEventAttendees(eventID, memberID);
            request.setAttribute("warning", "Canceled join event!");
            response.sendRedirect("user?command=ClubEvent");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void rCreateRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID != null) {
            request.getRequestDispatcher("user/CreateRating.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void CreateRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String vote = request.getParameter("vote");
        String note = request.getParameter("note");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            if (vote == null || vote.isBlank() || note == null || note.isBlank()) {
                request.getSession().setAttribute("warning", "Please complete all information!");
                response.sendRedirect("user?command=rCreateRating");
            } else {
                userDAO.insertRating(vote.replaceAll("[^\\d]", ""), note, memberID, clubID);
                response.sendRedirect("user?command=ClubRating");
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void LoadEditRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String ratingID = request.getParameter("rID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            ArrayList<Rating> rating = userDAO.getRatingFromClubID(clubID);
            Rating myRating = userDAO.getMyRating(memberID);
            Rating thisRating = userDAO.getRating(ratingID);
            if (rating == null) {
                request.setAttribute("warning", "No rating yet");
                request.getRequestDispatcher("user/ClubRating.jsp").forward(request, response);
            } else if (ratingID == null || ratingID.isBlank()) {
                response.sendRedirect("user?command=ClubRating");
            } else {
                request.setAttribute("rating", rating);
                request.setAttribute("ratings", rating.size());
                request.setAttribute("myRating", myRating);
                request.setAttribute("thisRating", thisRating);
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/ClubRating.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void EditRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String ratingID = request.getParameter("rID");
        String oldVote = request.getParameter("ovote");
        String newVote = request.getParameter("nvote");
        String note = request.getParameter("note");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int memberID = userDAO.getMemberID(user.getID(), clubID);
            ArrayList<Rating> rating = userDAO.getRatingFromClubID(clubID);
            Rating myRating = userDAO.getMyRating(memberID);
            Rating thisRating = userDAO.getRating(ratingID);
            if (note == null || note.isBlank()) {
                request.setAttribute("rating", rating);
                request.setAttribute("ratings", rating.size());
                request.setAttribute("myRating", myRating);
                request.setAttribute("thisRating", thisRating);
                request.setAttribute("clubID", clubID);
                request.getSession().setAttribute("note", "note");
                request.getSession().setAttribute("warning", "Please enter a note!");
                response.sendRedirect("user?command=LoadEditRating&rID=" + ratingID);
            } else if (ratingID == null || ratingID.isBlank()) {
                request.getSession().removeAttribute("note");
                response.sendRedirect("user?command=ClubRating");
            } else if (newVote == null || newVote.isBlank()) {
                userDAO.editRating(oldVote.replaceAll("[^\\d]", ""), note, ratingID);
                request.getSession().removeAttribute("note");
                response.sendRedirect("user?command=ClubRating");
            } else {
                userDAO.editRating(newVote.replaceAll("[^\\d]", ""), note, ratingID);
                request.getSession().removeAttribute("note");
                response.sendRedirect("user?command=ClubRating");
            }
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void DeleteRating(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String ratingID = request.getParameter("rID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null && ratingID != null && !ratingID.isBlank()) {
            userDAO.deleteRating(ratingID);
            response.sendRedirect("user?command=ClubRating");
        } else if (ratingID == null || ratingID.isBlank()) {
            response.sendRedirect("user?command=ClubRating");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void LoadChat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String recipientID = request.getParameter("mID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            int senderID = userDAO.getMemberID(user.getID(), clubID);
            String recipientName = userDAO.getNameFromMemberID(recipientID);
            ArrayList<Chat> chat = userDAO.getChat(senderID, recipientID, clubID);
            request.setAttribute("chat", chat);
            request.setAttribute("senderID", senderID);
            request.setAttribute("recipientID", recipientID);
            request.setAttribute("recipientName", recipientName);
            request.getRequestDispatcher("user/Chat.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
        }
    }

    private void ExitClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String IsCreator = (String) session.getAttribute("IsCreator");
        String IsManager = (String) session.getAttribute("IsManager");
        String IsMember = (String) session.getAttribute("IsMember");
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        if (IsCreator != null && IsManager != null && IsMember != null) {
            session.removeAttribute("IsCreator");
            session.removeAttribute("IsManager");
            session.removeAttribute("IsMember");
            response.sendRedirect("user?command=Home");
        } else if (IsCreator != null && IsManager != null && IsMember == null) {
            session.removeAttribute("IsCreator");
            session.removeAttribute("IsManager");
            response.sendRedirect("user?command=Home");
        } else if (IsCreator != null && IsManager == null && IsMember != null) {
            session.removeAttribute("IsCreator");
            session.removeAttribute("IsMember");
            response.sendRedirect("user?command=Home");
        } else if (IsCreator != null && IsManager == null && IsMember == null) {
            session.removeAttribute("IsCreator");
            response.sendRedirect("user?command=ForCreator");
        } else if (IsCreator == null && IsManager != null && IsMember != null) {
            session.removeAttribute("IsManager");
            session.removeAttribute("IsMember");
            response.sendRedirect("user?command=Home");
        } else if (IsCreator == null && IsManager != null && IsMember == null) {
            session.removeAttribute("IsManager");
            response.sendRedirect("user?command=ForManager");
        } else if (IsCreator == null && IsManager == null && IsMember != null) {
            session.removeAttribute("IsMember");
            response.sendRedirect("user?command=ForMember");
        } else {
            response.sendRedirect("user?command=Home");
        }
    }
}
