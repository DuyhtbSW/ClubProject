package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Club {

    private int ID;
//    private int ID, CreatorID;
    private String Code, Name, Description, CreatorID, DateCreated, Status, JoinRequest;

    public Club() {
    }

    public Club(int ID, String Code, String Name, String Description, String CreatorID, String DateCreated) {
        this.ID = ID;
        this.CreatorID = CreatorID;
        this.Code = Code;
        this.Name = Name;
        this.Description = Description;
        this.DateCreated = DateCreated;
    }

    public Club(int ID, String Code, String Name, String Description, String CreatorID, String DateCreated, String Status, String JoinRequest) {
        this.ID = ID;
        this.Code = Code;
        this.Name = Name;
        this.Description = Description;
        this.CreatorID = CreatorID;
        this.DateCreated = DateCreated;
        this.Status = Status;
        this.JoinRequest = JoinRequest;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCreatorID() {
        return CreatorID;
    }

    public void setCreatorID(String CreatorID) {
        this.CreatorID = CreatorID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDateCreated() {
        String dateStr = DateCreated;
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

    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getJoinRequest() {
        return JoinRequest;
    }

    public void setJoinRequest(String JoinRequest) {
        this.JoinRequest = JoinRequest;
    }

    @Override
    public String toString() {
        return "Club{" + "ID=" + ID + ", Code=" + Code + ", Name=" + Name + ", Description=" + Description + ", CreatorID=" + CreatorID + ", DateCreated=" + DateCreated + '}';
    }
}
