package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PostComment {

    private int ID;
    private String Content, Dated, PostID, CommentorID;

    public PostComment() {
    }

    public PostComment(int ID, String Content, String Dated, String PostID, String CommentorID) {
        this.ID = ID;
        this.Content = Content;
        this.Dated = Dated;
        this.PostID = PostID;
        this.CommentorID = CommentorID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getDated() {
        String dateStr = Dated;
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

    public void setDated(String Dated) {
        this.Dated = Dated;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String PostID) {
        this.PostID = PostID;
    }

    public String getCommentorID() {
        return CommentorID;
    }

    public void setCommentorID(String CommentorID) {
        this.CommentorID = CommentorID;
    }

    @Override
    public String toString() {
        return "PostComment{" + "ID=" + ID + ", Content=" + Content + ", Dated=" + Dated + ", PostID=" + PostID + ", CommentorID=" + CommentorID + '}';
    }
}
