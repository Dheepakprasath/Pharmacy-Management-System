package View;

import java.sql.SQLException;

import Util.input;

public class adminview extends input {
    // System.out.println("----Welcome Admin----");
    public static void view() throws SQLException{
    System.out.println("----Enter 1 to view all products----");
    System.out.println("----Enter 2 to view  employees----");
    System.out.println("----Enter 3 to add products----");
    System.out.println("----Enter 4 to delete products----");
    System.out.println("----Enter 5 to update stock----");
    System.out.println("----Enter 6 to exit----");
    int input=sc.nextInt();
    if(input==1)
    {
        // System.out.println("----Enter Brand Id----");
        Admin.viewallproduct();
    }
    if(input==2)
    {
        Admin.viewemployees();
    }
    if(input==3)
    {
        Admin.addnewmedicine();
    }
    if(input==4)
    {
        Admin.deletemedicine();
    }
    if(input==5)
    {
        Admin.updatestock();
    }
    else{
        return;
    }
}
}