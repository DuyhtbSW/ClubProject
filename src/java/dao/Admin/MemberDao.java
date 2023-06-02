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

/**
 *
 * @author acer
 */
public class MemberDao {

    public Member getMember(String idd) {
        int userId = Integer.parseInt(idd);
        ConnectDB db = ConnectDB.getInstance();
        Member member = null;
        try {
            String sql = " Select * from Member where userID = ?";
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int clubId = rs.getInt("ClubID");
                int isClubManager = rs.getInt("IsClubManager");
                Date joinDate = rs.getDate("JoinDate");
                member = new Member(clubId, userId, isClubManager, joinDate);
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
                int clubId = rs.getInt(1);
                int userId = rs.getInt(2);
                int isClubManager = rs.getInt(3);
                Date joinDate = rs.getDate(4);
                Member tmpMem = new Member(clubId, userId, isClubManager, joinDate);
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
}