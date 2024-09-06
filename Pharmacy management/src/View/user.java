package View;

import java.sql.SQLException;

import Controller.userController;
import Util.cookie;
import Util.input;

public class user extends input{
    public static void signup() throws SQLException{
        System.out.println("-----Enter your email-----");
        String email=sc.next();
        if(!email.contains("@gmail.com")){
            System.out.println("***INVALID EMAIL***");
            return;
        }
        System.out.println("-----Enter your password-----");
        String password=sc.next();
        while(password.length()<8){
            System.out.println("Create a strong password");
            password=sc.next();
        }
        userController.addNewUser(email, password);
        System.out.println("***SIGN UP SUCCESS***");
    }
    public static void signin() throws SQLException{
        System.out.println("-----Enter your email-----");
        String email=sc.next();
        System.out.println("-----Enter your password-----");
        String password=sc.next();
        String role=userController.checkForUser(email, password);
        cookie.u_id=userController.getUserId(email);
        if(role.equals("admin")){
            adminview.view();
        }
        else if(role.equals("customer")){
            Customer.displayMedicine();
        }
        else{
            System.out.println("***INVALID CREDENTIALS***");
        }
    }
}
