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
public class Notification {
    public int notificationId, userId;
    public String title, note;
    public Date date;
    public Boolean view;

    public Notification() {
    }

    public Notification(int userId, String title, String note) {
        this.userId = userId;
        this.title = title;
        this.note = note;
    }

    
    public Notification(int notificationId, int userId, String title, String note, Date date, Boolean view) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.title = title;
        this.note = note;
        this.date = date;
        this.view = view;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getView() {
        return view;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Notification{" + "notificationId=" + notificationId + ", userId=" + userId + ", title=" + title + ", note=" + note + ", date=" + date + ", view=" + view + '}';
    }

    
    
}
