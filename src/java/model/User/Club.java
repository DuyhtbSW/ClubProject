package model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Club {

    private int ID;
    private String code, name, description, creatorID, dateCreated, status, joinRequest;

    public Club() {
    }

    public Club(int ID, String code, String name, String description, String creatorID, String dateCreated) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.description = description;
        this.creatorID = creatorID;
        this.dateCreated = dateCreated;
    }

    public Club(int ID, String code, String name, String description, String creatorID, String dateCreated, String status, String joinRequest) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.description = description;
        this.creatorID = creatorID;
        this.dateCreated = dateCreated;
        this.status = status;
        this.joinRequest = joinRequest;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
    }

    public String getDateCreated() {
        String dateStr = dateCreated;
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

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJoinRequest() {
        return joinRequest;
    }

    public void setJoinRequest(String joinRequest) {
        this.joinRequest = joinRequest;
    }

    @Override
    public String toString() {
        return "Club{" + "ID=" + ID + ", code=" + code + ", name=" + name + ", description=" + description + ", creatorID=" + creatorID + ", dateCreated=" + dateCreated + ", status=" + status + ", joinRequest=" + joinRequest + '}';
    }
}
