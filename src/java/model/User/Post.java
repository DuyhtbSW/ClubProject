package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Post {

    private int ID;
    private String Title, Description, Dated, UserID, ClubID;

    public Post() {
    }

    public Post(int ID, String Title, String Description, String Dated, String UserID, String ClubID) {
        this.ID = ID;
        this.Title = Title;
        this.Description = Description;
        this.Dated = Dated;
        this.UserID = UserID;
        this.ClubID = ClubID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getClubID() {
        return ClubID;
    }

    public void setClubID(String ClubID) {
        this.ClubID = ClubID;
    }

    @Override
    public String toString() {
        return "Post{" + "ID=" + ID + ", Title=" + Title + ", Description=" + Description + ", Dated=" + Dated + ", UserID=" + UserID + ", ClubID=" + ClubID + '}';
    }
}
