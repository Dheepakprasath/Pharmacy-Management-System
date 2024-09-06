package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class stockDAO extends connect{
    private static stockDAO instance;
    PreparedStatement checkQuantity;
    PreparedStatement alterQuantity;
    private stockDAO() throws SQLException{
        checkQuantity=con.prepareStatement("SELECT s_count FROM stock WHERE m_id=?");
        alterQuantity=con.prepareStatement("UPDATE stock SET s_count=? WHERE m_id=?");
    }
    public static stockDAO getInstance() throws SQLException{
        if(instance==null)
        instance=new stockDAO();
        return instance;
    }
    public int checkForQuantity(int m_id) throws SQLException{
        checkQuantity.setInt(1, m_id);
        ResultSet rs=checkQuantity.executeQuery();
        if(rs.next())
        return rs.getInt(1);
        return -1;
    }
    public void alterStockAvailability(int m_id,int quantity) throws SQLException{
        alterQuantity.setInt(1, quantity);
        alterQuantity.setInt(2, m_id);
        alterQuantity.executeUpdate();
    }
}
