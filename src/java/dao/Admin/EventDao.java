/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin.Event;

/**
 *
 * @author acer
 */
public class EventDao {
    
    public Event getEvent(String idd) {
        int eventId = Integer.parseInt(idd);
        ConnectDB db = ConnectDB.getInstance();
        Event event = null;
        try {
            String sql = "Select * from Event where EventID = ?";
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, eventId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String eventName = rs.getString("EventName");
                String eventDescription = rs.getString("EventDescription");
                Date eventDate = rs.getDate("EventDate");
                int clubId = rs.getInt("ClubID");
                int EventStatus = rs.getInt("EventStatus");
                event = new Event(eventId, clubId, EventStatus, eventName, eventDescription, eventDate);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    
    public static int countEvent() {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count from Event";
        Connection con = null;
        int count = 0;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
    
    public List<Event> listAllEvent() {
        List<Event> ev = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "  Select * from Event Where EventStatus = 1";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int eventId = rs.getInt(1);
                String eventName = rs.getString(2);
                String eventDesription = rs.getString(3);
                Date eventDate = rs.getDate(4);
                int clubId = rs.getInt(5);
                int eventSataus = rs.getInt(6);
                Event tmpEvent = new Event(eventId, clubId, eventSataus, eventName, eventDesription, eventDate);
                ev.add(tmpEvent);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ev;
    }
    
    public void updateEvent(Event event) {
        String sql = " UPDATE Event SET EventName = ?, EventDescription = ?, EventDate = ?, EventStatus = ? WHERE eventID = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getEventDescription());
            java.sql.Date sqlDOB = new java.sql.Date(event.getEventDate().getTime());
            statement.setDate(3, sqlDOB);
            statement.setInt(4, event.getEventStatus());
            statement.setInt(5, event.getEventId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteEvent(Event event) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            String sql = "DELETE FROM Notification WHERE EventID = ?\n"+ 
                    "DELETE FROM EventAttendees WHERE EventID = ?\n"+
                    "DELETE FROM Event WHERE EventID = ?";
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, event.getEventId());
             statement.setInt(2, event.getEventId());
             statement.setInt(3, event.getEventId());
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Event> getEventToday() {
        List<Event> ev = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * From Event WHERE EventDate = CONVERT(date, GETDATE()) and EventStatus = 1";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int eventId = rs.getInt(1);
                String eventName = rs.getString(2);
                String eventDesription = rs.getString(3);
                Date eventDate = rs.getDate(4);
                int clubId = rs.getInt(5);
                int eventSataus = rs.getInt(6);
                Event tmpEvent = new Event(eventId, clubId, eventSataus, eventName, eventDesription, eventDate);
                ev.add(tmpEvent);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ev;
    }
    
    public static int countEventRequest() {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count from Event where CreateRequest = 1";
        Connection con = null;
        int count = 0;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
    
    public List<Event> listEventRequest() {
        List<Event> ev = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Event Where CreateRequest = 1";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int eventId = rs.getInt(1);
                String clubName = rs.getString(2);
                String eventDescription = rs.getString(3);
                Date eventDate = rs.getDate(4);
                int clubId = rs.getInt(5);
                int eventStatus = rs.getInt(6);
                Event tmpEvent = new Event(eventId, clubId, eventStatus, clubName, eventDescription, eventDate);
                ev.add(tmpEvent);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ev;
    }

    public void acceptEvent(Event event) {
        String sql = "Update Event Set EventStatus = 1, CreateRequest = 0 WHERE EventID = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, event.getEventId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void declineEvent(Event event) {
        String sql = "Update Event Set CreateRequest = 0 WHERE EventID = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, event.getEventId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
