package View;

import java.sql.SQLException;
import java.util.ArrayList;

import Controller.AdminController;
import Controller.medicineController;
import Resources.employeeDTO;
import Resources.medicineDTO;
import Resources.stockDTO;
import Util.input;

public class Admin extends input {
          public static void viewallproduct() throws SQLException{
              ArrayList<medicineDTO> arr=medicineController.medicineData();
        System.out.println("m_id  m_name         m_price");
        for(int i=0;i<arr.size();i++){
            medicineDTO med=arr.get(i);
            System.out.print(med.getM_id()+"     ");
            System.out.print(med.getM_name()+"   ");
            System.out.println(med.getM_price());
        }
          adminview.view();
          }
          public static void viewemployees() throws SQLException{
            ArrayList<employeeDTO> data=AdminController.viewemployees();
            System.out.println("E_id    E_name    E_salary    E_job");
           for(int i=0;i<data.size();i++){
            employeeDTO temp=data.get(i);
              System.out.print(temp.getE_id()+"       ");
              System.out.print(temp.getE_name()+"       ");
              System.out.print(temp.getE_salary()+"      ");
              System.out.println(temp.getE_job());
          }
          adminview.view();
        }
        public static void addnewmedicine() throws SQLException{
            System.out.println("Enter medicine name to add");
            String medicinename=sc.next();
            System.out.println("Enter the price of medicine");
            int medicineprice=sc.nextInt();
            AdminController.addmedicine(medicinename, medicineprice);
            System.out.println("Medicine added to the table");
            int m_id=AdminController.getmedicineid(medicinename,medicineprice);
            System.out.println("Enter the stock count of medicine");
            int stockcount=sc.nextInt();
            AdminController.addstock(stockcount,m_id);
            System.out.println("Stock added successfully");
            adminview.view();
        }
        public static void deletemedicine() throws SQLException{
            ArrayList<medicineDTO> arr=medicineController.medicineData();
            System.out.println("m_id  m_name         m_price");
            for(int i=0;i<arr.size();i++){
                medicineDTO med=arr.get(i);
                System.out.print(med.getM_id()+"     ");
                System.out.print(med.getM_name()+"   ");
                System.out.println(med.getM_price());
            }
                System.out.println("Enter the medicine id to delete the medicine");
                int medicineid=sc.nextInt();
                AdminController.deletemedicine(medicineid);
                AdminController.deletestock(medicineid);
                System.out.println("Product deleted successfully");
                adminview.view();
        }
        public static void updatestock() throws SQLException{
            ArrayList<medicineDTO> arr=medicineController.medicineData();
            System.out.println("m_id  m_name         m_price");
            for(int i=0;i<arr.size();i++){
                medicineDTO med=arr.get(i);
                System.out.print(med.getM_id()+"     ");
                System.out.print(med.getM_name()+"   ");
                System.out.println(med.getM_price());
            }
            System.out.println("Enter the m_id to view stock");
            int m_id=sc.nextInt();
            ArrayList<stockDTO> data=AdminController.viewstock(m_id);
            System.out.println("s_id    s_count   m_id");
            for(int i=0;i<data.size();i++)
            {
                stockDTO temp=data.get(i);
                System.out.print(temp.getS_id()+"         ");
                System.out.print(temp.getS_count()+"       ");
                System.out.println(temp.getM_id());
            }
            System.out.println("Enter the stock count to add");
            int k=AdminController.getstockcount(m_id);
            int scount=sc.nextInt();
            int updatedstock=scount+k;
            AdminController.ustock(updatedstock,m_id);
            ArrayList<stockDTO> data2=AdminController.viewstock(m_id);
            System.out.println("s_id    s_count   m_id");
            for(int i=0;i<data2.size();i++)
            {
                stockDTO temp2=data2.get(i);
                System.out.print(temp2.getS_id()+"         ");
                System.out.print(temp2.getS_count()+"       ");
                System.out.println(temp2.getM_id());
            }
            adminview.view();
        }
}

