package Model;

import java.sql.Statement;

import Util.Env;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    protected static Connection con;
    protected static Statement st;
    public static void getConnection() throws SQLException{
        con=DriverManager.getConnection(Env.url, Env.name, Env.password);
        st=con.createStatement();
    }
}
