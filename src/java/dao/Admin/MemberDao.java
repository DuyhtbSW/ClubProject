/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Admin;

import dao.Admin.ClubDao;
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
import model.Admin.Member;
import model.Admin.User;

/**
 *
 * @author acer
 */
public class MemberDao {

    public Member getMember(String idd) {
        int memberId = Integer.parseInt(idd);
        ConnectDB db = ConnectDB.getInstance();
        Member member = null;
        try {
            String sql = " Select * from Member where memberID = ?";
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, memberId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userID");
                int clubId = rs.getInt("ClubID");
                int isClubManager = rs.getInt("IsClubManager");
                Date joinDate = rs.getDate("JoinDate");
                int memberStatus = rs.getInt("memberStatus");
                member = new Member(userId, userId, clubId, isClubManager, joinDate, memberStatus);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return member;
    }

    public static List<Member> listAllMember() {
        List<Member> mb = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Member";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int memberId = rs.getInt(1);
                int userId = rs.getInt(2);
                int clubId = rs.getInt(3);
                int isClubManager = rs.getInt(4);
                Date joinDate = rs.getDate(5);
                int memberStatus = rs.getInt(6);
                Member tmpMem = new Member(memberId, userId, clubId, isClubManager, joinDate, memberStatus);
                mb.add(tmpMem);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mb;
    }

    public static int countMember() {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count from Member";
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
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public static int countMemberOfClub(int clubId) {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count From Member where clubId = ?";
        Connection con = null;
        int count = 0;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, clubId);
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

    public void deleteMember(String idd) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            String sql = "DELETE FROM Member WHERE UserId = ?";
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMember(Member member) {
        String sql = " UPDATE Member SET JoinDate= ? WHERE userId = ?";
        ConnectDB db = ConnectDB.getInstance();
        User user = null;
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement1 = con.prepareStatement(sql);
            java.sql.Date sqlJoinDate = new java.sql.Date(member.getJoinDate().getTime());
            statement1.setDate(1, sqlJoinDate);
            statement1.setInt(2, member.getUserId());
            statement1.execute();
            statement1.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(MemberDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getMemberName(int memberId) {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "SELECT UserName as userName\n"
                + "FROM Users u\n"
                + "INNER JOIN Member m ON u.UserID = m.UserID\n"
                + "WHERE memberId = ?";
        Connection con = null;
        String userName = null;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, memberId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userName = rs.getString("userName");
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
        return userName;
    }

}
