package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO extends connect{
    private static userDAO instance;
    PreparedStatement newUser;
    PreparedStatement checkUser;
    PreparedStatement getUser;
    private userDAO() throws SQLException{
        newUser=con.prepareStatement("INSERT INTO user(u_email,u_password,u_role) VALUES(?,?,?)");
        checkUser=con.prepareStatement("SELECT u_role FROM user WHERE u_email=? AND u_password=?");
        getUser=con.prepareStatement("SELECT u_id FROM user WHERE u_email=?");
    }
    public static userDAO getInstance() throws SQLException{
        if(instance==null)
        instance=new userDAO();
        return instance;
    }
    public void addNewUser(String email,String password) throws SQLException{
        newUser.setString(1, email);
        newUser.setString(2, password);
        newUser.setString(3, "customer");
        newUser.executeUpdate();
    }
    public String checkForUser(String email,String password) throws SQLException{
        checkUser.setString(1, email);
        checkUser.setString(2, password);
        ResultSet rs=checkUser.executeQuery();
        if(rs.next())
        return rs.getString(1);
        return "1";
    }
    public int getUserId(String email) throws SQLException{
        getUser.setString(1, email);
        ResultSet rs=getUser.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return 0;
    }

}
