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

    private int clubId, clubCreatorId ;
    private String clubCode, clubName, clubDescription;
    private Date dateCreated;
    boolean clubStatus, joinRequest;

    public Club() {
    }

    public Club(int clubId) {
        this.clubId = clubId;
    }

    public Club(int clubId, int clubCreatorId) {
        this.clubId = clubId;
        this.clubCreatorId = clubCreatorId;
    }

    public Club(int clubId, String clubCode, String clubName, String clubDescription, Date dateCreated, boolean clubStatus, boolean joinRequest) {
        this.clubId = clubId;
        this.clubCode = clubCode;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.dateCreated = dateCreated;
        this.clubStatus = clubStatus;
        this.joinRequest = joinRequest;
    }
    
    

    public Club(int clubId, String clubCode, String clubName, String clubDescription, int clubCreatorId, Date dateCreated) {
        this.clubId = clubId;
        this.clubCreatorId = clubCreatorId;
        this.clubCode = clubCode;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.dateCreated = dateCreated;
    }

    public Club(int clubId, int clubCreatorId, String clubCode, String clubName, String clubDescription, Date dateCreated, boolean clubStatus) {
        this.clubId = clubId;
        this.clubCreatorId = clubCreatorId;
        this.clubCode = clubCode;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.dateCreated = dateCreated;
        this.clubStatus = clubStatus;
    }

    public Club(int clubId, int clubCreatorId, String clubCode, String clubName, String clubDescription, Date dateCreated, boolean clubStatus, boolean joinRequest) {
        this.clubId = clubId;
        this.clubCreatorId = clubCreatorId;
        this.clubCode = clubCode;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.dateCreated = dateCreated;
        this.clubStatus = clubStatus;
        this.joinRequest = joinRequest;
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

    public boolean isClubStatus() {
        return clubStatus;
    }

    public void setClubStatus(boolean clubStatus) {
        this.clubStatus = clubStatus;
    }

    public boolean isJoinRequest() {
        return joinRequest;
    }

    public void setJoinRequest(boolean joinRequest) {
        this.joinRequest = joinRequest;
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

    public String getClubDescription() {
        return clubDescription;
    }

    public void getClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Club{" + "clubId=" + clubId + ", clubCreatorId=" + clubCreatorId + ", clubCode=" + clubCode + ", clubName=" + clubName + ", clubDescription=" + clubDescription + ", dateCreated=" + dateCreated + ", clubStatus=" + clubStatus + ", joinRequest=" + joinRequest + '}';
    }

    
}
