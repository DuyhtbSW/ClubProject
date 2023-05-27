/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author acer
 */
public class Club {

    private int clubId, clubCreatorId;
    private String clubName, clubDiscription;
    private Date dateCreated;

    public Club() {
    }

    public Club(int clubId, String clubName, String clubDiscription, int clubCreatorId, Date dateCreated) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.clubDiscription = clubDiscription;
        this.clubCreatorId = clubCreatorId;
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
        return "Club{" + "clubId=" + clubId + ", clubCreatorId=" + clubCreatorId + ", clubName=" + clubName + ", clubDiscription=" + clubDiscription + ", dateCreated=" + dateCreated + '}';
    }

}
