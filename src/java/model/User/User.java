package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class User {

    private int ID;
    private String Name, Email, Pass, Phone, DOB, Gender;

    public User() {
    }

    public User(String Name) {
        this.Name = Name;
    }

    public User(int ID, String Name, String DOB, String Gender) {
        this.ID = ID;
        this.Name = Name;
        this.DOB = DOB;
        this.Gender = Gender;
    }

    public User(int ID, String Name, String Email, String Pass, String Phone, String DOB, String Gender) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.Pass = Pass;
        this.Phone = Phone;
        this.DOB = DOB;
        this.Gender = Gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
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
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", Pass=" + Pass + ", Phone=" + Phone + ", DOB=" + DOB + ", Gender=" + Gender + '}';
    }
}
