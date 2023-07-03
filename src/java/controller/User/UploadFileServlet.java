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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            UserDAO userDAO = new UserDAO();
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

            if (dob == null || dob.isBlank()) {
                newDOB = user.getDOB();
            } else if (user.getDOB().equals(dob)) {
                newDOB = user.getDOB();
            } else if (!user.getDOB().equals(dob)) {
                if (!isValidDate(dob, "dd/MM/yyyy")) {
                    newDOB = user.getDOB();
                    request.getSession().setAttribute("warning", "Please enter correct date format!\nEx: dd/MM/yyyy");
                } else {
                    String dateStr = dob;
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
                    String formattedDate = localDate.format(outputFormatter);
                    if (!isValidDOB(formattedDate) || !isValidYear(formattedDate, 1995, 2006)) {
                        newDOB = user.getDOB();
                        request.getSession().setAttribute("warning", "Please enter correct birthDay and birthYear must be before 2005 and after 1995!");
                    } else {
                        newDOB = dob;
                    }
                }
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
                    System.out.println(realPath + "/" + fileName);
                    newImg = fileName;
                }
            } catch (ServletException | IOException e) {
                System.out.println(e.getMessage());
            }

            userDAO.editUser(capitalized(newName), newEmail, newPhone, newDOB, capitalize(newGender), newImg, user.getID());
            User resetUser = userDAO.checkUserLogin(newEmail, user.getPass());
            session.setAttribute("account", resetUser);
            session.setMaxInactiveInterval(999999);
            response.sendRedirect("user?command=LoadProfile");
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
}
