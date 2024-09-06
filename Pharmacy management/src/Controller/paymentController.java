package Controller;

import java.sql.SQLException;

import Model.paymentDAO;

public class paymentController {
    public static void addPayment(int amount,String quantity,String id) throws SQLException{
        paymentDAO payment=paymentDAO.getInstance();
        payment.addPaymentData(amount,quantity,id);
    }
}