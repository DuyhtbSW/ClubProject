package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Member {

    private int ID;
    private String userID, clubID, isClubManager, joinDate, status;

    public Member() {
    }

    public Member(int ID, String userID, String clubID, String joinDate) {
        this.ID = ID;
        this.userID = userID;
        this.clubID = clubID;
        this.joinDate = joinDate;
    }

    public Member(int ID, String userID, String clubID, String isClubManager, String joinDate) {
        this.ID = ID;
        this.userID = userID;
        this.clubID = clubID;
        this.isClubManager = isClubManager;
        this.joinDate = joinDate;
    }

    public Member(int ID, String userID, String clubID, String isClubManager, String joinDate, String status) {
        this.ID = ID;
        this.userID = userID;
        this.clubID = clubID;
        this.isClubManager = isClubManager;
        this.joinDate = joinDate;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getIsClubManager() {
        return isClubManager;
    }

    public void setIsClubManager(String isClubManager) {
        this.isClubManager = isClubManager;
    }

    public String getJoinDate() {
        String dateStr = joinDate;
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

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" + "ID=" + ID + ", userID=" + userID + ", clubID=" + clubID + ", isClubManager=" + isClubManager + ", joinDate=" + joinDate + ", status=" + status + '}';
    }
}
