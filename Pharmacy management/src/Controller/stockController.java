package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.stockDAO;

public class stockController {
    public static boolean checkQuantity(int m_id,int quantity) throws SQLException{
        stockDAO st=stockDAO.getInstance();
        int stock=st.checkForQuantity(m_id);
        if(stock>=quantity)
        return true;
        return false;
    }
    public static void alterQuantity(ArrayList<ArrayList<Integer>> purchase) throws SQLException{
        stockDAO st=stockDAO.getInstance();
        for(int i=0;i<purchase.size();i++){
            int stock=st.checkForQuantity(purchase.get(i).get(0));
            stock=stock-purchase.get(i).get(1);
            st.alterStockAvailability(purchase.get(i).get(0), stock);
        }
        
    }
}
