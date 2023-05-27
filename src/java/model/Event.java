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
public class Event {
    int eventId, clubId, userId, statusId;
    String eventName, eventDescription;
    Date eventDate;

    public Event() {
    }

    public Event(int eventId, int clubId, int userId, int statusId, String eventName, String eventDescription, Date eventDate) {
        this.eventId = eventId;
        this.clubId = clubId;
        this.userId = userId;
        this.statusId = statusId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", clubId=" + clubId + ", userId=" + userId + ", statusId=" + statusId + ", eventName=" + eventName + ", eventDescription=" + eventDescription + ", eventDate=" + eventDate + '}';
    }
    
    
}
