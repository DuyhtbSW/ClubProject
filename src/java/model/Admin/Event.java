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
public class Event {
    int eventId, clubId, eventStatus;
    String eventName, eventDescription;
    Date eventDate;

    public Event() {
    }

    public Event(int eventId) {
        this.eventId = eventId;
    }
    
    public Event(int eventId, String eventName, String eventDescription, Date eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }
    
    public Event(int eventId, int clubId, int eventStatus, String eventName, String eventDescription, Date eventDate) {
        this.eventId = eventId;
        this.clubId = clubId;
        this.eventStatus = eventStatus;
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

    public int getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(int eventStatus) {
        this.eventStatus = eventStatus;
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
        return "Event{" + "eventId=" + eventId + ", clubId=" + clubId + ", eventStatus=" + eventStatus + ", eventName=" + eventName + ", eventDescription=" + eventDescription + ", eventDate=" + eventDate + '}';
    }
    
    
}
