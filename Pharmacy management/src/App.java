import java.sql.SQLException;

import Model.connect;
import Util.input;
import View.user;

public class App extends input{
    public static void main(String[] args){
        try{
            connect.getConnection();
        }
        catch(SQLException err){
            System.out.println("Connection error");
        }
        while(true){
            try{

                System.out.println("-----Enter 1 to Sign_up-----");
                System.out.println("-----Enter 2 to Sign_in-----");
                System.out.println("-----Enter 3 to Exit-----");
                int entry=sc.nextInt();
                if(entry==1){
                    user.signup();
                }
                else if(entry==2){
                    user.signin();
                }
                else if(entry==3){
                    break;
                }
            }
            catch(Exception err){
                System.out.println(err);
            }
        }
    }
}