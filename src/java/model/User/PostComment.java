package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PostComment {

    private int ID;
    private String content, date, postID, commentorID;

    public PostComment() {
    }

    public PostComment(int ID, String content, String date, String postID, String commentorID) {
        this.ID = ID;
        this.content = content;
        this.date = date;
        this.postID = postID;
        this.commentorID = commentorID;
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

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getCommentorID() {
        return commentorID;
    }

    public void setCommentorID(String commentorID) {
        this.commentorID = commentorID;
    }

    @Override
    public String toString() {
        return "PostComment{" + "ID=" + ID + ", content=" + content + ", date=" + date + ", postID=" + postID + ", commentorID=" + commentorID + '}';
    }
}
