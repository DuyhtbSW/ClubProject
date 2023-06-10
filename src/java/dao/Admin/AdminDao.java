package dao.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin.Admin;

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
