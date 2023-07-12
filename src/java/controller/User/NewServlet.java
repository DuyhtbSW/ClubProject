package controller.User;

import dao.User.UserDAO;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.format.DateTimeParseException;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;
import model.User.User;

@MultipartConfig
public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DateTimeParseException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");

        HttpSession session = (HttpSession) request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null) {
            response.sendRedirect("user?command=rLogin");
        } else {
            int ID = user.getID();
            UserDAO userDAO = new UserDAO();

            String dateStr = dob;
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
            String formattedDate = localDate.format(outputFormatter);

            try {
                Part part = request.getPart("image");
                String realPath = request.getServletContext().getRealPath("/images");
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                int index = filename.lastIndexOf(".");
                String ext = filename.substring(index + 1);
                String fileName = System.currentTimeMillis() + "." + ext;
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectory(Paths.get(realPath));
                }
                part.write(realPath + "/" + fileName);
                userDAO.editUser(name, email, phone, formattedDate, gender, fileName, ID);
            } catch (ServletException | IOException e) {
                System.out.println(e);
            }
            response.sendRedirect("user?command=LoadProfile");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        String newName = "";
//        String newEmail = "";
//        String newPhone = "";
//        String newDOB = "";
//        String newGender = "";
//        String newImg = "";
//        if (user.getName().equals(name)) {
//            newName = user.getName();
////                userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (!user.getName().equals(name)) {
//            newName = name;
////                userDAO.editUser(capitalized(name), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (user.getEmail().equals(email)) {
//            newEmail = user.getEmail();
////                userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (!user.getEmail().equals(email)) {
//            newEmail = email;
////                userDAO.editUser(user.getName(), email, user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (user.getPhone().equals(phone)) {
//            newPhone = user.getPhone();
////                userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (!user.getPhone().equals(phone)) {
//            if (!isValidPhone(phone)) {
//                request.getSession().setAttribute("warning", "Please enter correct phone number format!\nEx: 0[35789]xxxxxxx");
////                response.sendRedirect("user?command=LoadEditProfile");
//            } else {
//                newPhone = phone;
////                    userDAO.editUser(user.getName(), user.getEmail(), phone, user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//            }
//        } else if (user.getDOB().equals(dob)) {
//            newDOB = user.getDOB();
////                userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (!user.getDOB().equals(dob)) {
//            if (!isValidDate(dob, "dd/MM/yyyy")) {
//                request.getSession().setAttribute("warning", "Please enter correct date format!\nEx: dd/MM/yyyy");
////                response.sendRedirect("user?command=LoadEditProfile");
//            } else {
//                String dateStr = dob;
//                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
//                String formattedDate = localDate.format(outputFormatter);
//                if (!isValidDOB(formattedDate) || !isValidYear(formattedDate, 1995, 2006)) {
//                    request.getSession().setAttribute("warning", "Please enter correct birthDay and birthYear must be before 2005 and after 1995!");
////                    response.sendRedirect("user?command=LoadEditProfile");
//                } else {
//                    newDOB = dob;
////                        userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), dob, user.getGender(), user.getImg(), user.getID());
////                    response.sendRedirect("user?command=LoadProfile");
//                }
//            }
//        } else if (user.getGender().equals(gender)) {
//            newGender = user.getGender();
////                userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (!user.getGender().equals(gender)) {
//            if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Other")) {
//                request.getSession().setAttribute("warning", "Please type 'Male' or 'Female' or 'Other'");
////                response.sendRedirect("user?command=LoadEditProfile");
//            } else {
//                newGender = gender;
////                    userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), capitalize(gender), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//            }
//        } else if (user.getImg().equals(image)) {
//            newImg = user.getImg();
////                userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), user.getImg(), user.getID());
////                response.sendRedirect("user?command=LoadProfile");
//        } else if (!user.getImg().equals(image)) {
//            try {
//                Part part = request.getPart("image");
//                String realPath = request.getServletContext().getRealPath("/images");
//                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//                int index = filename.lastIndexOf(".");
//                String ext = filename.substring(index + 1);
//                String fileName = System.currentTimeMillis() + "." + ext;
//                if (!Files.exists(Paths.get(realPath))) {
//                    Files.createDirectory(Paths.get(realPath));
//                }
//                part.write(realPath + "/" + fileName);
//                newImg = fileName;
////                    userDAO.editUser(user.getName(), user.getEmail(), user.getPhone(), user.getDOB(), user.getGender(), fileName, user.getID());
//            } catch (ServletException | IOException e) {
//                System.out.println(e);
//            }
//        } else {
//            userDAO.editUser(newName, newEmail, newPhone, newDOB, newGender, newImg, user.getID());
//            response.sendRedirect("user?command=LoadProfile");
//        }
    }
}
