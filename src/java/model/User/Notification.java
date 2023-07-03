package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Notification {

    private int ID;//generalID
    private String title, note, userID, clubID, memberID, postID, eventID, date, view;

    public Notification() {
    }

    public Notification(int ID, String title, String note, String userID, String clubID, String memberID, String postID, String eventID, String date, String view) {
        this.ID = ID;
        this.title = title;
        this.note = note;
        this.userID = userID;
        this.clubID = clubID;
        this.memberID = memberID;
        this.postID = postID;
        this.eventID = eventID;
        this.date = date;
        this.view = view;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
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

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Notification{" + "ID=" + ID + ", title=" + title + ", note=" + note + ", userID=" + userID + ", clubID=" + clubID + ", memberID=" + memberID + ", postID=" + postID + ", eventID=" + eventID + ", date=" + date + ", view=" + view + '}';
    }
}
