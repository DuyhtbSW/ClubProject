package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class User {

    private int ID;
    private String name, email, pass, phone, DOB, gender, img;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int ID, String name, String DOB) {
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
    }

    public User(int ID, String name, String DOB, String gender) {
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
    }

    public User(int ID, String name, String email, String pass, String phone, String DOB, String gender) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.DOB = DOB;
        this.gender = gender;
    }

    public User(int ID, String name, String email, String pass, String phone, String DOB, String gender, String img) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.DOB = DOB;
        this.gender = gender;
        this.img = img;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDOB() {
        String dateStr = DOB;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
            String formattedDate = localDate.format(outputFormatter);
            return formattedDate;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", name=" + name + ", email=" + email + ", pass=" + pass + ", phone=" + phone + ", DOB=" + DOB + ", gender=" + gender + ", img=" + img + '}';
    }
}
