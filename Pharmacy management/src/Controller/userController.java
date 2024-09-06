package Controller;

import java.sql.SQLException;

import Model.userDAO;

public class userController {
    public static void addNewUser(String email,String password) throws SQLException{
        userDAO user=userDAO.getInstance();
        user.addNewUser(email, password);
    }
    public static String checkForUser(String email,String password) throws SQLException{
        userDAO user=userDAO.getInstance();
        return user.checkForUser(email, password);
    }
    public static int getUserId(String email) throws SQLException{
        userDAO user=userDAO.getInstance();
        return user.getUserId(email);
    }
}
