package controller.User;

import dao.User.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import model.User.Event;
import model.User.User;

@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String editProfile = (String) session.getAttribute("editProfile");
        String createClub = (String) session.getAttribute("createClub");
        String editClub = (String) session.getAttribute("editClub");
        String createPost = (String) session.getAttribute("createPost");
        String editPost = (String) session.getAttribute("editPost");
        String createEvent = (String) session.getAttribute("createEvent");
        String editEvent = (String) session.getAttribute("editEvent");

        System.out.println(editPost);
        UserDAO userDAO = new UserDAO();

        if (editProfile != null) {
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

            if (user == null) {
                response.sendRedirect("user?command=rLogin");
                String newName = "";
                String newEmail = "";
                String newPhone = "";
                String newDOB = "";
                String newGender = "";
                String newImg = "";

                if (name == null || name.isBlank()) {
                    newName = user.getName();
                } else if (user.getName().equals(name)) {
                    newName = user.getName();
                } else if (!user.getName().equals(name)) {
                    newName = name;
                }

                if (email == null || email.isBlank()) {
                    newEmail = user.getEmail();
                } else if (user.getEmail().equals(email)) {
                    newEmail = user.getEmail();
                } else if (!user.getEmail().equals(email)) {
                    newEmail = email;
                }

                if (phone == null || phone.isBlank()) {
                    newPhone = user.getPhone();
                } else if (user.getPhone().equals(phone)) {
                    newPhone = user.getPhone();
                } else if (!user.getPhone().equals(phone)) {
                    if (!isValidPhone(phone)) {
                        newPhone = user.getPhone();
                        request.getSession().setAttribute("warning", "Please enter correct phone number format!\nEx: 0[35789]xxxxxxx");
                    } else {
                        newPhone = phone;
                    }
                }

                String dateStr = user.getDOB();
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
                String formattedDate = localDate.format(outputFormatter);
                if (dob == null || dob.isBlank()) {
                    newDOB = formattedDate;
                } else if (user.getDOB().equals(dob)) {
                    newDOB = formattedDate;
                } else if (!user.getDOB().equals(dob)) {
//                if (!isValidDate(dob, "dd/MM/yyyy")) {
//                    newDOB = user.getDOB();
//                    request.getSession().setAttribute("warning", "Please enter correct date format!\nEx: dd/MM/yyyy");
//                } else {
//                String dateStr = dob;
//                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
//                String formattedDate = localDate.format(outputFormatter);
//                if (!isValidDOB(formattedDate) || !isValidYear(formattedDate, 1995, 2006)) {
                    if (!isValidDOB(dob) || !isValidYear(dob, 1995, 2006)) {
                        newDOB = formattedDate;
                        request.getSession().setAttribute("warning", "Please enter correct birthDay and birthYear must be before 2005 and after 1995!");
                    } else {
                        newDOB = dob;
                    }
//                }
                }

                if (gender == null || gender.isBlank()) {
                    newGender = user.getGender();
                } else if (user.getGender().equals(gender)) {
                    newGender = user.getGender();
                } else if (!user.getGender().equals(gender)) {
                    if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
                        newGender = user.getGender();
                        request.getSession().setAttribute("warning", "Please enter 'Male' or 'Female' or 'Other'");
                    } else {
                        newGender = gender;
                    }
                }

                try {
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                    String formattedDateTime = currentDateTime.format(formatter);
                    Part part = request.getPart("image");
                    String realPath = request.getServletContext().getRealPath("/images");
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index + 1);
                    String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                    if (!Files.exists(Paths.get(realPath))) {
                        Files.createDirectory(Paths.get(realPath));
                    }
                    if (ext == null || ext.isBlank()) {
                        newImg = user.getImg();
//                    System.out.println(realPath + "/" + fileName);
                    } else {
                        part.write(realPath + "/" + fileName);
//                    System.out.println(realPath + "/" + fileName);
                        newImg = fileName;
                    }
                } catch (ServletException | IOException e) {
                    System.out.println(e.getMessage());
                }

                String warning = (String) request.getSession().getAttribute("warning");
                if (warning != null) {
                    request.getSession().setAttribute("warning", warning);
                    response.sendRedirect("user?command=LoadEditProfile");
                } else {
                    userDAO.editUser(capitalized(newName), newEmail, newPhone, newDOB, capitalize(newGender), newImg, user.getID());
                    User resetUser = userDAO.checkUserLogin(newEmail, user.getPass());
                    session.setAttribute("account", resetUser);
                    session.setMaxInactiveInterval(999999);
                    response.sendRedirect("user?command=LoadProfile");
                }
            }
        } else if (createClub != null) {
            session.removeAttribute("clubID");
            session.removeAttribute("clubCreatorID");
            session.removeAttribute("IsCreator");
            session.removeAttribute("IsManager");
            session.removeAttribute("IsMember");

            String clubImg = request.getParameter("cImg");
            String clubCode = request.getParameter("cCode");
            String clubName = request.getParameter("cName");
            String clubDescription = request.getParameter("cDescription");
            LocalDate currentDate = LocalDate.now();

            if (user == null) {
                response.sendRedirect("user?command=rLogin");
            } else {
                if (clubCode == null || clubName == null || clubDescription == null
                        || clubCode.isBlank() || clubName.isBlank() || clubDescription.isBlank()) {
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (clubCode.length() != 3) {
                    request.getSession().setAttribute("warning", "Club Code must be 3 letters!");
                } else if (!isString(clubCode)) {
                    request.getSession().setAttribute("warning", "Club Code must be letters!");
                } else {
                    try {
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                        String formattedDateTime = currentDateTime.format(formatter);
                        Part part = request.getPart("cImg");
                        String realPath = request.getServletContext().getRealPath("/images");
                        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        int index = filename.lastIndexOf(".");
                        String ext = filename.substring(index + 1);
                        String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        if (ext == null || ext.isBlank()) {
                            clubImg = "";
                        } else {
                            part.write(realPath + "/" + fileName);
                            clubImg = fileName;
                        }
                    } catch (ServletException | IOException e) {
                        System.out.println(e.getMessage());
                    }

                    String warning = (String) request.getSession().getAttribute("warning");
                    if (warning != null) {
                        request.getSession().setAttribute("warning", warning);
                        response.sendRedirect("user?command=rCreateClub");
                    } else {
                        int clubID = userDAO.checkClubID(clubCode.toUpperCase(), clubName, clubDescription, user.getID(), java.sql.Date.valueOf(currentDate), clubImg);
                        userDAO.insertNotification("Create Club", "Pending", user.getID(), clubID, 1, 1, 1, java.sql.Date.valueOf(currentDate));
                        request.getSession().setAttribute("warning", "Please wait for admin to accept!");
                        response.sendRedirect("user?command=rCreateClub");
                    }
                }
            }
        } else if (createPost != null) {
            String image = request.getParameter("image");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String clubID = (String) session.getAttribute("clubID");
            LocalDate currentDate = LocalDate.now();

            if (clubID != null) {
                if (title == null || title.isBlank() || description == null || description.isBlank()) {
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else {
                    int memberID = userDAO.getMemberID(user.getID(), clubID);
                    int isClubManager = userDAO.isClubManager(memberID);
                    try {
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                        String formattedDateTime = currentDateTime.format(formatter);
                        Part part = request.getPart("image");
                        String realPath = request.getServletContext().getRealPath("/images");
                        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        int index = filename.lastIndexOf(".");
                        String ext = filename.substring(index + 1);
                        String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        if (ext == null || ext.isBlank()) {
                            image = "";
                        } else {
                            part.write(realPath + "/" + fileName);
                            image = fileName;
                        }
                    } catch (ServletException | IOException e) {
                        System.out.println(e.getMessage());
                    }

                    String warning = (String) request.getSession().getAttribute("warning");
                    if (warning != null) {
                        request.getSession().setAttribute("warning", warning);
                        response.sendRedirect("user?command=rCreatePost");
                    } else {
                        if (isClubManager == 1) {
                            userDAO.insertPost(title, description, java.sql.Date.valueOf(currentDate), memberID, clubID, "1", "0", "0", image);
                            response.sendRedirect("user?command=ClubPost");
                        } else {
                            int postID = userDAO.checkPostID(title, description, java.sql.Date.valueOf(currentDate), memberID, clubID, "0", "1", "1", image);
                            userDAO.insertNotification("Create Post", "Pending", user.getID(), Integer.parseInt(clubID), memberID, postID, 1, java.sql.Date.valueOf(currentDate));
                            request.getSession().setAttribute("warning", "Please wait for the manager to accept!");
                            response.sendRedirect("user?command=rCreatePost");
                        }
                    }
                }
            } else {
                response.sendRedirect("user?command=Home");
            }
        } else if (editClub != null) {
            String image = request.getParameter("image");
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String clubID = (String) session.getAttribute("clubID");

            if (clubID == null) {
                response.sendRedirect("user?command=Home");
            } else {
                if (code == null || code.isBlank()) {
                    request.getSession().setAttribute("code", "code");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (name == null || name.isBlank()) {
                    request.getSession().setAttribute("name", "name");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (description == null || description.isBlank()) {
                    request.getSession().setAttribute("description", "description");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (code.length() != 3) {
                    request.getSession().setAttribute("warning", "Club Code must be 3 letters!");
                } else if (!isString(code)) {
                    request.getSession().setAttribute("warning", "Club Code must be letters!");
                } else {
                    try {
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                        String formattedDateTime = currentDateTime.format(formatter);
                        Part part = request.getPart("image");
                        String realPath = request.getServletContext().getRealPath("/images");
                        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        int index = filename.lastIndexOf(".");
                        String ext = filename.substring(index + 1);
                        String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        if (ext == null || ext.isBlank()) {
                            image = "";
                        } else {
                            part.write(realPath + "/" + fileName);
                            image = fileName;
                        }
                    } catch (ServletException | IOException e) {
                        System.out.println(e.getMessage());
                    }

                    String warning = (String) request.getSession().getAttribute("warning");
                    if (warning != null) {
                        request.getSession().setAttribute("warning", warning);
                        response.sendRedirect("user?command=LoadEditClub");
                    } else {
                        userDAO.editClub(code.toUpperCase(), name, description, image, clubID);
                        response.sendRedirect("user?command=ViewClubDetails");
                    }
                }
            }
        } else if (editPost != null) {
            String image = request.getParameter("image");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String postID = request.getParameter("pID");
            String clubID = (String) session.getAttribute("clubID");

            if (clubID != null) {
                if (title == null || title.isBlank()) {
                    request.getSession().setAttribute("title", "title");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (description == null || description.isBlank()) {
                    request.getSession().setAttribute("description", "description");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else {
                    try {
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                        String formattedDateTime = currentDateTime.format(formatter);
                        Part part = request.getPart("image");
                        String realPath = request.getServletContext().getRealPath("/images");
                        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        int index = filename.lastIndexOf(".");
                        String ext = filename.substring(index + 1);
                        String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        if (ext == null || ext.isBlank()) {
                            image = "";
                        } else {
                            part.write(realPath + "/" + fileName);
                            image = fileName;
                        }
                    } catch (ServletException | IOException e) {
                        System.out.println(e.getMessage());
                    }

                    String warning = (String) request.getSession().getAttribute("warning");
                    if (warning != null) {
                        request.getSession().setAttribute("warning", warning);
                        response.sendRedirect("user?command=LoadEditPost&pID=" + postID);
                    } else {
                        userDAO.editPost(title, description, image, postID);
                        response.sendRedirect("user?command=PostManage&pID=" + postID);
                    }
                }
            } else {
                response.sendRedirect("user?command=Home");
            }
        } else if (createEvent != null) {
            String image = request.getParameter("image");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String date = request.getParameter("date");
            String clubID = (String) session.getAttribute("clubID");
            LocalDate currentDate = LocalDate.now();

            if (clubID != null) {
                int memberID = userDAO.getMemberID(user.getID(), clubID);
                if (name == null || name.isBlank() || description == null || description.isBlank() || date == null || date.isBlank()) {
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (!isDateAfterToday(date)) {
                    request.getSession().setAttribute("warning", "Please select after current date!");
                } else {
                    try {
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                        String formattedDateTime = currentDateTime.format(formatter);
                        Part part = request.getPart("image");
                        String realPath = request.getServletContext().getRealPath("/images");
                        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                        int index = filename.lastIndexOf(".");
                        String ext = filename.substring(index + 1);
                        String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                        if (!Files.exists(Paths.get(realPath))) {
                            Files.createDirectory(Paths.get(realPath));
                        }
                        if (ext == null || ext.isBlank()) {
                            image = "";
                        } else {
                            part.write(realPath + "/" + fileName);
                            image = fileName;
                        }
                    } catch (ServletException | IOException e) {
                        System.out.println(e.getMessage());
                    }

                    String warning = (String) request.getSession().getAttribute("warning");
                    if (warning != null) {
                        request.getSession().setAttribute("warning", warning);
                        response.sendRedirect("user?command=rCreateEvent");
                    } else {
                        int eventID = userDAO.checkEventID(name, description, java.sql.Date.valueOf(date), clubID, image);
                        userDAO.insertNotification("Create Event", "Pending", user.getID(), Integer.parseInt(clubID), memberID, 1, eventID, java.sql.Date.valueOf(currentDate));
                        request.getSession().setAttribute("warning", "Please wait for admin to accept!");
                        response.sendRedirect("user?command=rCreateEvent");
                    }
                }
            } else {
                response.sendRedirect("user?command=Home");
            }
        } else if (editEvent != null) {
            String image = request.getParameter("image");
            String name = request.getParameter("name");
            String olddate = request.getParameter("olddate");
            String newdate = request.getParameter("newdate");
            String description = request.getParameter("description");
            String eventID = request.getParameter("eID");
            String clubID = (String) session.getAttribute("clubID");

            String dateStr = olddate;
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
            String formattedDate = localDate.format(outputFormatter);

            try {
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HH-mm-ss");
                String formattedDateTime = currentDateTime.format(formatter);
                Part part = request.getPart("image");
                String realPath = request.getServletContext().getRealPath("/images");
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                int index = filename.lastIndexOf(".");
                String ext = filename.substring(index + 1);
                String fileName = System.currentTimeMillis() + formattedDateTime + "." + ext;
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectory(Paths.get(realPath));
                }
                if (ext == null || ext.isBlank()) {
                    image = "";
                } else {
                    part.write(realPath + "/" + fileName);
                    image = fileName;
                }
            } catch (ServletException | IOException e) {
                System.out.println(e.getMessage());
            }

            if (clubID != null) {
                Event event = userDAO.getEvent(eventID);
                if (name == null || name.isBlank()) {
                    request.setAttribute("event", event);
                    request.setAttribute("eventID", eventID);
                    request.getSession().setAttribute("name", "name");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                } else if (description == null || description.isBlank()) {
                    request.setAttribute("event", event);
                    request.setAttribute("eventID", eventID);
                    request.getSession().setAttribute("description", "description");
                    request.getSession().setAttribute("warning", "Please complete all information!");
                }

                String warning = (String) request.getSession().getAttribute("warning");
                if (warning != null) {
                    request.getSession().setAttribute("warning", warning);
                    response.sendRedirect("user?command=LoadEditEvent&eID=" + eventID);
                } else {
                    if (newdate.isBlank()) {
                        userDAO.editEvent(name, formattedDate, description, image, eventID);
                        response.sendRedirect("user?command=EventManage&eID=" + eventID);
                    } else if (!newdate.isBlank() && isDateAfterToday(newdate)) {
                        userDAO.editEvent(name, newdate, description, image, eventID);
                        response.sendRedirect("user?command=EventManage&eID=" + eventID);
                    } else if (eventID == null || eventID.isBlank()) {
                        response.sendRedirect("user?command=ClubEvent");
                    } else {
                        request.setAttribute("event", event);
                        request.setAttribute("eventID", eventID);
                        request.getSession().setAttribute("warning", "Please select after current date!");
                        response.sendRedirect("user?command=LoadEditEvent&eID=" + eventID);
                    }
                }
            } else {
                response.sendRedirect("user?command=Home");
            }
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

    private boolean isValidDate(String dateString, String format) {
        try {
            if (dateString == null) {
                return false;
            }
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
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

    private boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }
        String regex = "0[35789]\\d{8}";
        return phone.matches(regex);
    }

    private boolean isString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
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
}
