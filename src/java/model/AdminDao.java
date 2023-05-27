/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dbcontext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class AdminDao {
    public static boolean login(Admin ad) {
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select * from [Admins] where AdminEmail = ? and AdminPassword = ?;";
        Connection con = null;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, ad.getAdminEmail().trim());
            statement.setString(2, ad.getAdminPassword().trim());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Success");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
