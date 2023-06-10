/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Admin;

import dao.Admin.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin.Club;

/**
 *
 * @author acer
 */
public class ClubDao {

    public Club getClub(String idd) {
        List<Club> cl = new ArrayList<>();
        int id = Integer.parseInt(idd);
        ConnectDB db = ConnectDB.getInstance();
        Club club = null;
        try {
            String sql = " Select * from Clubs where clubID = ?";
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String clubName = rs.getString(2);
                String clubDesription = rs.getString(3);
                int clubCreatorID = rs.getInt(4);
                Date dateCreated = rs.getDate(5);
                club = new Club(id, clubName, clubDesription, clubCreatorID, dateCreated);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return club;
    }

    public static List<Club> listAllClub() {
        List<Club> cl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Clubs WHERE clubstatus = 1";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int clubId = rs.getInt(1);
                String clubName = rs.getString(2);
                String clubDiscription = rs.getString(3);
                int clubCreatorId = rs.getInt(4);
                Date dateCreated = rs.getDate(5);
                Club tmpClub = new Club(clubId, clubName, clubDiscription, clubCreatorId, dateCreated);
                cl.add(tmpClub);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }

    public static int countClub() {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count from Clubs WHERE clubStatus = 1";
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

    public void updateClub(Club club) {
        String sql = " UPDATE Clubs SET clubName= ?, clubDesription = ?, clubCreatorID = ?, dateCreated = ? WHERE clubId = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, club.getClubName());
            statement.setString(2, club.getClubDiscription());
            statement.setInt(3, club.getClubId());
            java.sql.Date sqlDOB = new java.sql.Date(club.getDateCreated().getTime());
            statement.setDate(4, sqlDOB);
            statement.setInt(5, club.getClubId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getClubName(int clubId){
        ConnectDB db = ConnectDB.getInstance();
        String sql = "  Select ClubName as clubName From Clubs where clubId = ?"; 
        Connection con = null;
        String clubName = null;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, clubId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                clubName = rs.getString("clubName");
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
        return clubName;
    }
    
    public static int countClubRequest() {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count from Clubs where clubstatus = 0";
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
    
    public void  createClub(Club club) {
        String sql = "Update Clubs Set ClubStatus = 1 WHERE clubId = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, club.getClubId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Club> listClubRequest() {
        List<Club> cl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Clubs Where clubStatus = 0";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int clubId = rs.getInt(1);
                String clubName = rs.getString(2);
                String clubDiscription = rs.getString(3);
                int clubCreatorId = rs.getInt(4);
                Date dateCreated = rs.getDate(5);
                Club tmpClub = new Club(clubId, clubName, clubDiscription, clubCreatorId, dateCreated);
                cl.add(tmpClub);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }
}
