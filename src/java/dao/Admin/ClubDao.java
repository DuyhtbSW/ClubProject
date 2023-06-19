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
import model.Admin.Club;

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
                String clubCode = rs.getString(2);
                String clubName = rs.getString(3);
                String clubDesription = rs.getString(4);
                int clubCreatorID = rs.getInt(5);
                Date dateCreated = rs.getDate(6);
                boolean clubStatus = rs.getBoolean(7);
                boolean clubRequest = rs.getBoolean(8);
                club = new Club(id, clubCreatorID, clubCode, clubName, clubDesription, dateCreated, clubStatus, clubRequest);
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
                String clubCode = rs.getString(2);
                String clubName = rs.getString(3);
                String clubDescription = rs.getString(4);
                int clubCreatorId = rs.getInt(5);
                Date dateCreated = rs.getDate(6);
                boolean clubStatus = rs.getBoolean(7);
                boolean clubRequest = rs.getBoolean(8);
                Club tmpClub = new Club(clubId, clubCreatorId, clubCode, clubName, clubDescription, dateCreated, clubStatus, clubRequest);
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
        String sql = "UPDATE Clubs SET ClubCode = ?, clubName= ?, clubDescription = ?, dateCreated = ?, clubStatus = ?, joinRequest=? WHERE clubId = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, club.getClubCode());
            statement.setString(2, club.getClubName());
            statement.setString(3, club.getClubDescription());
            java.sql.Date sqlDOB = new java.sql.Date(club.getDateCreated().getTime());
            statement.setDate(4, sqlDOB);
            statement.setBoolean(5, club.isClubStatus());
            statement.setBoolean(6, club.isJoinRequest());
            statement.setInt(7, club.getClubId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getClubName(int clubId) {
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

    public void createClub(Club club) {
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
                String clubCode = rs.getString(2);
                String clubName = rs.getString(3);
                String clubDescription = rs.getString(4);
                int clubCreatorId = rs.getInt(5);
                Date dateCreated = rs.getDate(6);
                boolean clubStatus = rs.getBoolean(7);
                boolean clubRequest = rs.getBoolean(8);
                Club tmpClub = new Club(clubId, clubCreatorId, clubCode, clubName, clubDescription, dateCreated, clubStatus, clubRequest);
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

    public void declineClub(Club club) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            String sql = "DELETE FROM Clubs WHERE ClubId = ?";
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, club.getClubId());
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Club> search(String value) {
        List<Club> cl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "SELECT *\n"
                    + "    FROM Clubs\n"
                    + "    WHERE ClubId LIKE '%" + value + "%'\n "
                    + "         OR ClubCode LIKE '%" + value + "%'\n"
                    + "        OR ClubName LIKE '%" + value + "%'\n"
                    + "        OR ClubDescription LIKE '%" + value + "%'";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int clubId = rs.getInt(1);
                String clubCode = rs.getString(2);
                String clubName = rs.getString(3);
                String clubDescription = rs.getString(4);
                int clubCreatorId = rs.getInt(5);
                Date dateCreated = rs.getDate(6);
                boolean clubStatus = rs.getBoolean(7);
                boolean clubRequest = rs.getBoolean(8);
                Club tmpClub = new Club(clubId, clubCreatorId, clubCode, clubName, clubDescription, dateCreated, clubStatus, clubRequest);
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
    
    public static int getManagerId(int clubId){
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select ClubCreatorID as id from Clubs where clubId = ?";
        Connection con = null;
        int id = 0;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, clubId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
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
        return id;
    }
}
