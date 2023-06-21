package controller.User;

import dao.User.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.User.Club;
import model.User.Event;
import model.User.Member;
import model.User.Post;
import model.User.PostComment;
import model.User.SendEmail;
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
            case "Register":
                Register(request, response);
                break;
            case "rChangePass":
                rChangePass(request, response);
                break;
            case "rForgotPass":
                rForgotPass(request, response);
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
            case "ClubsList":
                ClubsList(request, response);
                break;
            case "ViewDetailsClub":
                ViewDetailsClub(request, response);
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
            case "ViewClubDetails":
                ViewClubDetails(request, response);
                break;
            case "LoadEditClub":
                LoadEditClub(request, response);
                break;
            case "EditClub":
                EditClub(request, response);
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

        if (user == null) {
            request.setAttribute("warning", "Incorrect account or password!");
            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            response.sendRedirect("Home.jsp");
        }
    }

    private void CheckClubCreatorOrManagerOrMember(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        UserDAO userDAO = new UserDAO();

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
            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
//            response.sendRedirect("user/Login.jsp");
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
        session.invalidate();
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
        session.invalidate();

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
            } else if (!isValidPassword(pass)) {
                request.setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
                request.getRequestDispatcher("user/Register.jsp").forward(request, response);
            } else if (!containsLowercase(pass)) {
                request.setAttribute("warning", "Please type the first letter in uppercase, lowercase letter, number, special characters and have at least 8 characters!");
                request.getRequestDispatcher("user/Register.jsp").forward(request, response);
            } else {
                User u = userDAO.checkUserEmail(acc);
                if (u == null) {
                    userDAO.insertUser(capitalized(extractUsername(acc)), acc, pass);
                    request.setAttribute("warning", "Register Successfully!\nPlease Login!");
                    request.getRequestDispatcher("user/Register.jsp").forward(request, response);
                } else {
                    request.setAttribute("warning", "Email already exists!");
                    request.getRequestDispatcher("user/Register.jsp").forward(request, response);
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

    private String getRandom() {
        Random rd = new Random();
        int number = rd.nextInt(999999);
        return String.format("%06d", number);
    }
//
//    private void sendOTP(String recipientEmail, String OTP) {
//        // Thông tin tài khoản email của bạn
//        final String fromEmail = "student.club.management105@gmail.com";
//        final String password = "jdbuffoudhhnhcbq";
//        final String toEmail = recipientEmail;
//
//        // Cấu hình SMTP server và cổng
//        String smtpHost = "smtp.gmail.com";
//        int smtpPort = 587;
//
//        // Cấu hình các thuộc tính của email
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", smtpHost);
//        props.put("mail.smtp.port", smtpPort);
//
//        // Tạo session để xác thực tài khoản email và gửi email
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        });
//
//        try {
//            // Tạo đối tượng MimeMessage
//            Message message = new MimeMessage(session);
//
//            // Thiết lập thông tin người gửi
//            message.setFrom(new InternetAddress(fromEmail));
//
//            // Thiết lập thông tin người nhận
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//
//            // Thiết lập tiêu đề email
//            message.setSubject("OTP Verification");
//
//            // Thiết lập nội dung email
//            String emailContent = "Your OTP is: " + OTP;
//            message.setText(emailContent);
//
//            // Gửi email
//            Transport.send(message);
//
//            System.out.println("Email sent successfully!");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

    private void rForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.removeAttribute("clubID");
        session.removeAttribute("clubCreatorID");
        session.removeAttribute("IsCreator");
        session.removeAttribute("IsManager");
        session.removeAttribute("IsMember");
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

        if (email == null) {
            request.setAttribute("warning", "Email does not exist!");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        } else {
            SendEmail emailSender = new SendEmail();
            emailSender.sendEmail(recipientEmail, OTP);
            request.setAttribute("next", "next");
            session.setAttribute("email", recipientEmail);
            session.setAttribute("OTP", OTP);
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        }
    }

    private void ConfirmForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String otp = request.getParameter("otp");

        HttpSession session = request.getSession();
        String OTP = (String) session.getAttribute("OTP");

        if (!OTP.equals(otp)) {
            request.setAttribute("next", "next");
            request.setAttribute("warning", "Incorrect verification code!");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        } else {
            request.setAttribute("otp", "otp");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        }
    }

    private void ForgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String newPass = request.getParameter("nPass");
        String confirmPass = request.getParameter("cfPass");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (newPass.equals("") || confirmPass.equals("")) {
            request.setAttribute("otp", "otp");
            request.setAttribute("warning", "Please complete all information!");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        } else if (!newPass.equals(confirmPass)) {
            request.setAttribute("otp", "otp");
            request.setAttribute("warning", "Incorrect new password or confirm password!");
            request.getRequestDispatcher("user/ForgotPassword.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.changePassword(email, newPass);
            request.setAttribute("warning", "Change password success!\nPlease login!");
            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            int ID = user.getID();
            UserDAO userDAO = new UserDAO();

            User users = userDAO.getUserByID(ID);
            request.setAttribute("user", users);
            request.getRequestDispatcher("user/EditProfile.jsp").forward(request, response);
        }
    }

    private String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String firstLetter = input.substring(0, 1);
        String remainingLetters = input.substring(1);

        return firstLetter.toUpperCase() + remainingLetters.toLowerCase();
    }

    public static String capitalized(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split("\\s+");
        StringBuilder capitalizedSentence = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
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

        User user = (User) session.getAttribute("account");
        String dateStr = dob;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        boolean isValidPhone = phone.matches("0[3579]\\d{8}");

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            int ID = user.getID();

            UserDAO userDAO = new UserDAO();

            if (name.equals("") || email.equals("") || phone.equals("") || dob.equals("") || gender.equals("")) {
                request.setAttribute("warning", "Please complete all information!");
                LoadEditProfile(request, response);
//                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
            } else if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
                request.setAttribute("warning", "Please type 'Male' or 'Female' or 'Other'");
                LoadEditProfile(request, response);
            } else if (!isValidPhone) {
                request.setAttribute("warning", "Please type correct phone number format!");
                LoadEditProfile(request, response);
            } else if (!isValidDOB(formattedDate) || !isValidYear(formattedDate, 1995, 2006)) {
                request.setAttribute("warning", "Please type correct birthDay and birthYear must be before 2005 and after 1995!");
                LoadEditProfile(request, response);
            } else {
                userDAO.editUser(capitalized(name), email, phone, formattedDate, capitalize(gender), ID);
                LoadProfile(request, response);
            }
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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

        LocalDate currentDate = LocalDate.now();

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
                int ID = user.getID();
                UserDAO userDAO = new UserDAO();
                userDAO.insertClub(clubCode.toUpperCase(), clubName, clubDescription, ID, java.sql.Date.valueOf(currentDate));
                request.setAttribute("warning", "Please wait for admin to accept!");
                request.getRequestDispatcher("user/CreateClub.jsp").forward(request, response);
            }
        }
    }

    private void JoinClub(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            String clubID = request.getParameter("clubID");
            String clubCreatorID = request.getParameter("clubCreatorID");

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
                        request.setAttribute("club", club);
                        request.setAttribute("clubCreatorName", ClubCreatorName);
                        request.setAttribute("warning", "Please wait for the manager to accept!");
                        request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
                    } else {
                        userDAO.joinClubSuccess(user.getID(), clubID, java.sql.Date.valueOf(currentDate));
                        request.setAttribute("club", club);
                        request.setAttribute("clubCreatorName", ClubCreatorName);
                        String isMember = userDAO.getClubMemberFromUserID(user.getID());
                        session.setAttribute("clubMember", isMember);
                        session.setMaxInactiveInterval(999999);
                        request.setAttribute("warning", "Join club success!");
                        request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("club", club);
                    request.setAttribute("clubCreatorName", ClubCreatorName);
                    request.setAttribute("warning", "Request has been sent!\nPlease wait for the manager to accept!");
                    request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("club", club);
                request.setAttribute("clubCreatorName", ClubCreatorName);
                request.setAttribute("warning", "Already a member of this club!");
                request.getRequestDispatcher("user/ViewDetailsClub.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            Club clubs = userDAO.getClubToManage(clubID);
            request.setAttribute("club", clubs);
            request.setAttribute("clubID", clubID);
            request.getRequestDispatcher("user/ClubManage.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            request.getRequestDispatcher("user/ViewClubDetails.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
                userDAO.editClub(code, name, description, clubID);
                response.sendRedirect("user?command=ViewClubDetails");
            }
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.joinRequestAccept(java.sql.Date.valueOf(currentDate), memberID);
            response.sendRedirect("user?command=JoinClubRequestList");
//            JoinClubRequestList(request, response);
//            request.getRequestDispatcher("user/JoinClubRequest.jsp").forward(request, response);
        }
    }

    private void JoinRequestDecline(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String memberID = request.getParameter("mID");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.joinRequestDecline(memberID);
            response.sendRedirect("user?command=JoinClubRequestList");
//            JoinClubRequestList(request, response);
//            request.getRequestDispatcher("user/JoinClubRequest.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.setToManager(memberID);
//            ClubManager(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.deleteMember(memberID);
//            ClubMember(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.setToMember(managerID);
//            ClubMember(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.deleteManager(managerID);
//            ClubManager(request, response);
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

        if (user != null && clubID != null) {
            if (title.equals("") || description.equals("")) {
                request.setAttribute("warning", "Please complete all information!");
                request.getRequestDispatcher("user/CreatePost.jsp").forward(request, response);
            } else {
                int memberID = userDAO.getMemberID(user.getID(), clubID);
                int isClubManager = userDAO.isClubManager(memberID);
                if (isClubManager == 1) {
                    userDAO.insertPost(title, description, java.sql.Date.valueOf(currentDate), memberID, clubID, "1");
                    response.sendRedirect("user?command=ClubPost");
                } else {
                    userDAO.insertPost(title, description, java.sql.Date.valueOf(currentDate), memberID, clubID, "0");
                    request.setAttribute("warning", "Please wait for the manager to accept!");
                    request.getRequestDispatcher("user/CreatePost.jsp").forward(request, response);
                }
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                request.setAttribute("myPost", myPost);
                request.setAttribute("postOfClubCreator", postOfClubCreator);
                request.getRequestDispatcher("user/PostManage.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                request.getRequestDispatcher("user/EditPost.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            if (title.equals("") || description.equals("")) {
                request.setAttribute("title", title);
                request.setAttribute("description", description);
                request.setAttribute("warning", "Please complete all information!");
//                LoadEditPost(request, response);
                response.sendRedirect("user?command=LoadEditPost&pID=" + postID);
            } else {
                userDAO.editPost(title, description, postID);
                response.sendRedirect("user?command=PostManage&pID=" + postID);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            userDAO.deletePost(postID);
            response.sendRedirect("user?command=ClubPost");
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        }
    }

    private void PostClubRequestList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.postRequestAccept(postID);
//            PostClubRequestList(request, response);
            response.sendRedirect("user?command=PostClubRequestList");
        }
    }

    private void PostRequestDecline(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        if (clubID == null) {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            userDAO.postRequestDecline(postID);
//            PostClubRequestList(request, response);
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
//            PostComment myComment = userDAO.getMyComment(memberID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            ArrayList<PostComment> postComment = userDAO.getPostCommentTest(postID);
//            ArrayList<PostComment> myComments = userDAO.getMyComments(postID, memberID);
//            ArrayList<PostComment> notMyComments = userDAO.getNotMyComments(postID, memberID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else {
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("postComment", postComment);
                request.setAttribute("postComments", postComment.size());
                request.setAttribute("clubID", clubID);
//                request.setAttribute("myComment", myComment);
//                request.setAttribute("myComments", myComments);
//                request.setAttribute("notMyComments", notMyComments);
                request.setAttribute("commenterID", memberID);
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
//                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
                request.setAttribute("postComment", postComment);
                request.setAttribute("comment", "comment");
                request.setAttribute("clubID", clubID);
//                request.setAttribute("myComment", myComment);
                ViewComment(request, response);
//                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        }
    }

    private void Comment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String comment = request.getParameter("comment");
        String postID = request.getParameter("pID");

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
                if (!comment.isEmpty()) {
                    userDAO.insertComment(comment, java.sql.Date.valueOf(currentDate), postID, memberID);
                    request.setAttribute("post", post);
                    request.setAttribute("pID", postID);
                    request.setAttribute("postComment", postComment);
                    response.sendRedirect("user?command=ViewComment&pID=" + postID);
                } else {
                    request.setAttribute("warning", "Please type a comment before send!");
                    request.setAttribute("post", post);
                    request.setAttribute("pID", postID);
                    request.setAttribute("comment", "comment");
                    request.setAttribute("postComment", postComment);
                    ViewComment(request, response);
                }
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            PostComment myComment = userDAO.getMyComment(memberID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            ArrayList<PostComment> postComment = userDAO.getPostCommentTest(postID);
//            ArrayList<PostComment> myComments = userDAO.getMyComments(postID, memberID);
//            ArrayList<PostComment> notMyComments = userDAO.getNotMyComments(postID, memberID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
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
//                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        }
    }

    private void EditComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pcID = request.getParameter("pcID");
        String postID = request.getParameter("pID");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
//            int memberID = userDAO.getMemberID(user.getID(), clubID);
            Post post = userDAO.getPost(clubID, postID);
//            PostComment myComment = userDAO.getMyComment(memberID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
//            ArrayList<PostComment> myComments = userDAO.getMyComments(postID, memberID);
//            ArrayList<PostComment> notMyComments = userDAO.getNotMyComments(postID, memberID);
            if (comment.equals("")) {
                PostComment thisComment = userDAO.getComment(pcID);
                request.setAttribute("warning", "Do not leave blank!");
                request.setAttribute("post", post);
                request.setAttribute("postID", postID);
                request.setAttribute("postComment", postComment);
                request.setAttribute("thisComment", thisComment);
                request.setAttribute("clubID", clubID);
//                request.setAttribute("myComment", myComment);
//                request.setAttribute("myComments", myComments);
//                request.setAttribute("notMyComments", notMyComments);
                LoadEditComment(request, response);
            } else {
                userDAO.editComment(comment, pcID);
                request.setAttribute("postID", postID);
                request.setAttribute("clubID", clubID);
                response.sendRedirect("user?command=ViewComment&pID=" + postID);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
        }
    }

    private void DeleteComment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pcID = request.getParameter("pcID");
        String postID = request.getParameter("pID");

        HttpSession session = request.getSession();
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            ArrayList<Post> post = userDAO.getPostFromClubID(clubID);
            ArrayList<PostComment> postComment = userDAO.getPostComment(postID);
            if (postComment == null) {
                request.setAttribute("warning", "No comment yet");
                request.getRequestDispatcher("user/ViewComment.jsp").forward(request, response);
            } else {
                userDAO.deleteComment(pcID);
                request.setAttribute("post", post);
                request.setAttribute("pID", postID);
                request.setAttribute("postComment", postComment);
                response.sendRedirect("user?command=ViewComment&pID=" + postID);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
        String clubID = (String) session.getAttribute("clubID");

        UserDAO userDAO = new UserDAO();

        if (clubID != null) {
            if (name.equals("") || description.equals("") || date.equals("")) {
                request.setAttribute("warning", "Please complete all information!");
                request.getRequestDispatcher("user/CreateEvent.jsp").forward(request, response);
            } else if (!isDateAfterToday(date)) {
                request.setAttribute("warning", "Please select before current date!");
                request.getRequestDispatcher("user/CreateEvent.jsp").forward(request, response);
            } else {
                userDAO.insertEvent(name, description, java.sql.Date.valueOf(date), clubID);
                request.setAttribute("warning", "Please wait for admin to accept!");
                request.getRequestDispatcher("user/CreateEvent.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            } else {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/EventManage.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            } else {
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/EditEvent.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            if (name.equals("") || description.equals("")) {
                request.setAttribute("warning", "Please complete all information!");
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/EditEvent.jsp").forward(request, response);
            } else if (newdate.equals("")) {
                userDAO.editEvent(name, formattedDate, description, eventID);
                response.sendRedirect("user?command=EventManage&eID=" + eventID);
            } else if (!newdate.isEmpty() && isDateAfterToday(newdate)) {
                userDAO.editEvent(name, newdate, description, eventID);
                response.sendRedirect("user?command=EventManage&eID=" + eventID);
            } else {
                request.setAttribute("warning", "Please select before current date!");
                request.setAttribute("event", event);
                request.setAttribute("eventID", eventID);
                request.getRequestDispatcher("user/EditEvent.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            userDAO.deleteEvent(eventID);
            response.sendRedirect("user?command=ClubEvent");
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
            userDAO.insertEventAttendees(eventID, memberID);
            request.setAttribute("warning", "Join event success!");
            response.sendRedirect("user?command=ClubEvent");
//            ClubEvent(request, response);
//            request.getRequestDispatcher("user/ClubEvent.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
//            ClubEvent(request, response);
//            request.getRequestDispatcher("user/ClubEvent.jsp").forward(request, response);
        } else {
            response.sendRedirect("user?command=Home");
//            request.getRequestDispatcher("user/Login.jsp").forward(request, response);
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
