package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.medicineDAO;
import Resources.medicineDTO;

public class medicineController {
    public static ArrayList<medicineDTO> medicineData() throws SQLException{
        medicineDAO medicine=medicineDAO.getInstance();
        return medicine.getMedicineData();
    }
    public static int getPrice(int m_id) throws SQLException{
        medicineDAO medicine=medicineDAO.getInstance();
        return medicine.getPriceUsingId(m_id);
    }
    public static String getName(int m_id) throws SQLException{
        medicineDAO medicine=medicineDAO.getInstance();
        return medicine.getNameUsingId(m_id);
    }
}
