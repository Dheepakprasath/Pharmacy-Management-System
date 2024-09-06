package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.cookie;

public class paymentDAO extends connect{
    private static paymentDAO instance;
    PreparedStatement addPayment;
    private paymentDAO() throws SQLException{
        addPayment=con.prepareStatement("INSERT INTO payment(p_amount,p_quantity,m_id,u_id) VALUES(?,?,?,?)");
    }
    public static paymentDAO getInstance() throws SQLException{
        if(instance==null)
        instance=new paymentDAO();
        return instance;
    }
    public void addPaymentData(int amount,String quantity,String m_id) throws SQLException{
        addPayment.setInt(1, amount);
        addPayment.setString(2, quantity);
        addPayment.setString(3, m_id);
        addPayment.setInt(4, cookie.u_id);
        addPayment.executeUpdate();
    }
}
