/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Admin;

import model.Admin.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class NotificationDao {

    public void sentNotification(Notification notification) {
    ConnectDB db = ConnectDB.getInstance();
    String sql = "Insert into Notification(UserID, Title, Note, Date)\n"
            + "Values (?, ?, ?, CONVERT(date, GETDATE()));";
    Connection con = null;
    try {
        con = db.openConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, notification.getUserId());
        statement.setString(2, notification.getTitle());
        statement.setString(3, notification.getNote());
        statement.executeUpdate();
        statement.close();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(NotificationDao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(NotificationDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}
