package model.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat {

    private int ID;
    private String content, date, senderID, recipientID, clubID;

    public Chat() {
    }

    public Chat(int ID, String content, String date, String senderID, String recipientID, String clubID) {
        this.ID = ID;
        this.content = content;
        this.date = date;
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.clubID = clubID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        String dateStr = date;
        DateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try {
            Date dateTime = inputFormatter.parse(dateStr);
            String formattedDate = outputFormatter.format(dateTime);
            return formattedDate;
        } catch (ParseException e) {
            return null;
        }
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(String recipientID) {
        this.recipientID = recipientID;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    @Override
    public String toString() {
        return "Chat{" + "ID=" + ID + ", content=" + content + ", date=" + date + ", senderID=" + senderID + ", recipientID=" + recipientID + ", clubID=" + clubID + '}';
    }
}
