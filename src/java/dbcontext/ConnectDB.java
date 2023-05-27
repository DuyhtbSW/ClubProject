/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
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
