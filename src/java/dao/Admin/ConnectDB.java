package dao.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB implements DatabaseInfor{
    private static ConnectDB instance;
    public static Connection openConnection() throws ClassNotFoundException, SQLException{
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }
    
    public static ConnectDB getInstance(){
        if(instance==null){
            instance = new ConnectDB();
        }
        return instance;
    }
}
