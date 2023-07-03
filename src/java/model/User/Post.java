package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Post {

    private int ID;
    private String title, description, date, memberID, clubID, status, createRequest, createStatus, removeStatus, img;

    public Post() {
    }

    public Post(int ID, String title, String description, String date, String memberID, String clubID) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.memberID = memberID;
        this.clubID = clubID;
    }

    public Post(int ID, String title, String description, String date, String memberID, String clubID, String status) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.memberID = memberID;
        this.clubID = clubID;
        this.status = status;
    }

    public Post(int ID, String title, String description, String date, String memberID, String clubID, String status, String createRequest, String createStatus, String removeStatus, String img) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.memberID = memberID;
        this.clubID = clubID;
        this.status = status;
        this.createRequest = createRequest;
        this.createStatus = createStatus;
        this.removeStatus = removeStatus;
        this.img = img;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        String dateStr = date;
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

    public void setDate(String date) {
        this.date = date;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateRequest() {
        return createRequest;
    }

    public void setCreateRequest(String createRequest) {
        this.createRequest = createRequest;
    }

    public String getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(String createStatus) {
        this.createStatus = createStatus;
    }

    public String getRemoveStatus() {
        return removeStatus;
    }

    public void setRemoveStatus(String removeStatus) {
        this.removeStatus = removeStatus;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Post{" + "ID=" + ID + ", title=" + title + ", description=" + description + ", date=" + date + ", memberID=" + memberID + ", clubID=" + clubID + ", status=" + status + ", createRequest=" + createRequest + ", createStatus=" + createStatus + ", removeStatus=" + removeStatus + ", img=" + img + '}';
    }
}
