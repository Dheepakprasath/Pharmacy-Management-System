package Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.medicineDTO;

public class medicineDAO extends connect{
    private static medicineDAO instance;
    PreparedStatement price;
    PreparedStatement name;
    private medicineDAO() throws SQLException{
        price=con.prepareStatement("SELECT m_price FROM medicine WHERE m_id=?");
        name=con.prepareStatement("SELECT m_name FROM medicine WHERE m_id=?");
    }
    public static medicineDAO getInstance() throws SQLException{
        if(instance==null)
        instance=new medicineDAO();
        return instance;
    }
    public ArrayList<medicineDTO> getMedicineData() throws SQLException{
        ArrayList<medicineDTO> arr=new ArrayList<>();
        ResultSet rs=st.executeQuery("SELECT * FROM medicine");
        while(rs.next()){
            arr.add(new medicineDTO(rs.getInt(1),rs.getString(2),rs.getInt(3)));
        }
        return arr;
    }
    public int getPriceUsingId(int m_id) throws SQLException{
        price.setInt(1, m_id);
        ResultSet rs=price.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return -1;
    }
    public String getNameUsingId(int m_id) throws SQLException{
        name.setInt(1, m_id);
        ResultSet rs=name.executeQuery();
        rs.next();
        return rs.getString(1);
    }
}
