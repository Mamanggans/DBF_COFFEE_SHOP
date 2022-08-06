/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeapp.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author M DANI SETIAWAN
 */
public class Koneksi {
    public static Connection open()
    {       
    Connection con;
    
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:51688;instance=MSSQLSERVER;"
                + "databaseName=HALO";
        con = DriverManager.getConnection(url, "DANI", "123456");
        return con;   
        }
        catch (Exception e)
        {
        System.err.println(e);
        return null;
        }
    
}
}
