package dao.User;

import dao.Admin.ConnectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://LAPTOP-D3FL5ICO:1433;databaseName=FPTCLUB;trustServerCertificate=true";
    public static String user = "sa";
    public static String pass = "Sy23112001";

    private static ConnectDB instance;
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
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
