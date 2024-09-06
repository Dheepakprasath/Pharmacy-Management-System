package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.AdminDAO;
import Resources.employeeDTO;
import Resources.stockDTO;

public class AdminController {
    public static ArrayList<employeeDTO> viewemployees() throws SQLException{
        AdminDAO view=AdminDAO.getInstance();
        return view.viewallemployees();
    }
    public static void addmedicine(String medicinename,int medicineprice) throws SQLException{
        AdminDAO add=AdminDAO.getInstance();
        add.addmedicine(medicinename,medicineprice);
    }
    public static int getmedicineid(String medicinename,int medicineprice) throws SQLException{
        AdminDAO get=AdminDAO.getInstance();
        return get.getmedicineid(medicinename, medicineprice);
    }
    public static void addstock(int stockcount,int m_id) throws SQLException{
        AdminDAO add=AdminDAO.getInstance();
        add.addstock(stockcount, m_id);
    }
    public static void deletemedicine(int medicineid) throws SQLException{
        AdminDAO delete=AdminDAO.getInstance();
        delete.deleteproduct(medicineid);
    }
    public static void deletestock(int medicineid) throws SQLException{
        AdminDAO delete=AdminDAO.getInstance();
        delete.deleteproductstock(medicineid);
    }
    public static ArrayList<stockDTO> viewstock(int m_id) throws SQLException{
        AdminDAO view=AdminDAO.getInstance();
        return view.viewstocks(m_id);
    }
    public static int getstockcount(int m_id) throws SQLException
    {
        AdminDAO count=AdminDAO.getInstance();
        return count.getscount(m_id);
    }
    public static void ustock(int updatedstock,int m_id) throws SQLException{
        AdminDAO update=AdminDAO.getInstance();
        update.updatestocks(updatedstock,m_id);
    }
}
