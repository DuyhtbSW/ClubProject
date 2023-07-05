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
import model.Admin.User;

/**
 *
 * @author acer
 */
public class UserDao {

    public User getUser(String idd) {
        List<User> ul = new ArrayList<>();
        int id = Integer.parseInt(idd);
        ConnectDB db = ConnectDB.getInstance();
        User user = null;
        try {
            String sql = " Select * from Users where userID = ?";
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String userName = rs.getString(2);
                String userEmail = rs.getString(3);
                String userPassword = rs.getString(4);
                String userPhone = rs.getString(5);
                Date userDOB = rs.getDate(6);
                String userGender = rs.getString(7);
                user = new User(id, userName, userEmail, userPassword, userPhone, userGender, userDOB);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static List<User> listAllUser() {
        List<User> userList = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            String sql = "Select * from Users";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                String userName = rs.getString(2);
                String userEmail = rs.getString(3);
                String userPass = rs.getString(4);
                String userPhone = rs.getString(5);
                Date userDOB = rs.getDate(6);
                String userGender = rs.getString(7);
                User tmpUser = new User(userId, userName, userEmail, userPass, userPhone, userGender, userDOB);
                userList.add(tmpUser);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

    public static int countUser() {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select count(*) as count from Users";
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
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }

    public void updateUser(User user) {
        String sql = " UPDATE Users SET userName= ?, userEmail = ?, userPassword = ?, userPhone = ?, userDOB = ?, userGender = ? WHERE userId = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserEmail());
            statement.setString(3, user.getUserPassword());
            statement.setString(4, user.getUserPhone());
            java.sql.Date sqlDOB = new java.sql.Date(user.getDOB().getTime());
            statement.setDate(5, sqlDOB);
            statement.setString(6, user.getUserGender());
            statement.setInt(7, user.getUserId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(String idd) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            String sql = "Update Users set UserStatus = 1 WHERE UserId = ?;";
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            statement.execute();
            con.close();
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getUserName(int userId){
        ConnectDB db = ConnectDB.getInstance();
        String sql = "  Select UserName as userName From Users where userId = ?"; 
        Connection con = null;
        String userName = null;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, userId);
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
