package Model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.employeeDTO;
import Resources.stockDTO;

public class AdminDAO extends connect{
    private static AdminDAO instance;
    PreparedStatement amedicine;
    PreparedStatement gmedicineid;
    PreparedStatement astock;
    PreparedStatement dmedicine;
    PreparedStatement dstock;
    PreparedStatement vstock;
    PreparedStatement getstock;
    PreparedStatement updatestock;
    private AdminDAO() throws SQLException{
        amedicine =con.prepareStatement("insert into medicine(m_name,m_price) values (?,?)");
        gmedicineid=con.prepareStatement("select m_id from medicine where m_name=? and m_price=?");
        astock=con.prepareStatement("insert into stock(s_count,m_id) values(?,?)");
        dmedicine=con.prepareStatement("delete from medicine where m_id=?");
        dstock=con.prepareStatement("delete from stock where m_id=?");
        vstock=con.prepareStatement("select * from stock where m_id=?");
        getstock=con.prepareStatement("select s_count from stock where m_id=?");
        updatestock=con.prepareStatement("update stock set s_count=? where m_id=?");
    }
    public static AdminDAO getInstance() throws SQLException{
        if(instance==null)
        instance=new AdminDAO();
        return instance;
    }
    public ArrayList<employeeDTO> viewallemployees() throws SQLException{
        ArrayList<employeeDTO> arr=new ArrayList<>();
        ResultSet rs=st.executeQuery("select * from employee");
        while(rs.next()){
            arr.add(new employeeDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4)));
        }
        return arr;
    }
    public void addmedicine(String medicinename,int medicineprice) throws SQLException{
        amedicine.setString(1, medicinename);
        amedicine.setInt(2, medicineprice);
        amedicine.executeUpdate();
    }
    public int getmedicineid(String medicinename,int medicineprice) throws SQLException{
       gmedicineid.setString(1,medicinename);
       gmedicineid.setInt(2,medicineprice);
       ResultSet rs=gmedicineid.executeQuery();
       if(rs.next())
        return rs.getInt(1);
        return -1;
    }
    public void addstock(int stockcount,int m_id ) throws SQLException{
      astock.setInt(1,stockcount);
      astock.setInt(2,m_id);
      astock.executeUpdate();
    }
    public void deleteproduct(int medicineid) throws SQLException{
    dmedicine.setInt(1,medicineid);
    dmedicine.executeUpdate();
    }
    public void deleteproductstock(int medicineid) throws SQLException{
    dstock.setInt(1,medicineid);
    dstock.executeUpdate();
    }
    public ArrayList<stockDTO> viewstocks(int m_id) throws SQLException{
    ArrayList<stockDTO> arr=new ArrayList<>();
    vstock.setInt(1,m_id);
    ResultSet rs=vstock.executeQuery();
    while(rs.next()){
        arr.add(new stockDTO(rs.getInt(1), rs.getInt(2),rs.getInt(3)) );
    }
    return arr;
}
public int getscount(int s_id) throws SQLException{
    getstock.setInt(1,s_id);
    ResultSet rs=getstock.executeQuery();
    if(rs.next()){
       return rs.getInt(1);
    }
    return -1;
}
public void updatestocks(int updatedstock,int m_id) throws SQLException{
    updatestock.setInt(1,updatedstock);
    updatestock.setInt(2,m_id);
    updatestock.executeUpdate();
}
}
