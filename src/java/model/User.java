package model;

import java.util.Date;

public class User {

    private int userId;
    private String userName, userEmail, userPass, userPhone, userGender;
    private Date DOB;

    public User() {
    }

    public User(int userId, String userName, String userEmail, String userPass, String userPhone, String userGender, Date DOB) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userPhone = userPhone;
        this.userGender = userGender;
        this.DOB = DOB;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPass=" + userPass + ", userPhone=" + userPhone + ", userGender=" + userGender + ", DOB=" + DOB + '}';
    }
    

    
}
