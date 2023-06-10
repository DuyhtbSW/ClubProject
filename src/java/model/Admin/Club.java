/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Admin;

import java.util.Date;

/**
 *
 * @author acer
 */
public class Club {

    private int clubId, clubCreatorId, clubStatus;
    private String clubCode, clubName, clubDiscription;
    private Date dateCreated;

    public Club() {
    }

    public Club(int clubId) {
        this.clubId = clubId;
    }

    public Club(int clubId, String clubCode, String clubName, String clubDiscription, int clubCreatorId, Date dateCreated) {
        this.clubId = clubId;
        this.clubCreatorId = clubCreatorId;
        this.clubCode = clubCode;
        this.clubName = clubName;
        this.clubDiscription = clubDiscription;
        this.dateCreated = dateCreated;
    }

    public Club(int clubId, int clubCreatorId, int clubStatus, String clubName, String clubDiscription, Date dateCreated) {
        this.clubId = clubId;
        this.clubCreatorId = clubCreatorId;
        this.clubStatus = clubStatus;
        this.clubName = clubName;
        this.clubDiscription = clubDiscription;
        this.dateCreated = dateCreated;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getClubCreatorId() {
        return clubCreatorId;
    }

    public void setClubCreatorId(int clubCreatorId) {
        this.clubCreatorId = clubCreatorId;
    }

    public int getClubStatus() {
        return clubStatus;
    }

    public void setClubStatus(int clubStatus) {
        this.clubStatus = clubStatus;
    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDiscription() {
        return clubDiscription;
    }

    public void setClubDiscription(String clubDiscription) {
        this.clubDiscription = clubDiscription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Club{" + "clubId=" + clubId + ", clubCreatorId=" + clubCreatorId + ", clubStatus=" + clubStatus + ", clubName=" + clubName + ", clubDiscription=" + clubDiscription + ", dateCreated=" + dateCreated + '}';
    }

}
