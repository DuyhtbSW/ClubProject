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
public class Member {
    int clubId, userId, isClubManager;
    Date joinDate;

    public Member() {
    }

    public Member(int userId, Date joinDate) {
        this.userId = userId;
        this.joinDate = joinDate;
    }

    public Member(int clubId, int userId, int isClubManager, Date joinDate) {
        this.clubId = clubId;
        this.userId = userId;
        this.isClubManager = isClubManager;
        this.joinDate = joinDate;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsClubManager() {
        return isClubManager;
    }

    public void setIsClubManager(int isClubManager) {
        this.isClubManager = isClubManager;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Member{" + "clubId=" + clubId + ", userId=" + userId + ", isClubManager=" + isClubManager + ", joinDate=" + joinDate + '}';
    }
    
    
}
