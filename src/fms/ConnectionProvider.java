
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fms;
import java.sql.*;
import com.mysql.cj.jdbc.*;

/**
 *
 * @author jana
 */
public class ConnectionProvider {
    private static Connection conn;
    private static final String URL="jdbc:mysql://localhost:3306/fms";
    private static final String USERNAME="root";
    private static final String PASSWORD="Swasthik@123";
    public static Connection getConnection()
    {
        if(conn==null){
     try
     {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fms","root","Swasthik@123");
         //return con;
     }
     catch(SQLException e)
    {
        //System.out.println(e);
        //return null;
        e.printStackTrace();
    }
    }
       return conn;
    }

}

