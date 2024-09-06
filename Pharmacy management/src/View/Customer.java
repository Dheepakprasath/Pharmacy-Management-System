package View;

import java.sql.SQLException;
import java.util.ArrayList;

import Controller.medicineController;
import Controller.paymentController;
import Controller.stockController;
import Resources.medicineDTO;
import Util.input;

public class Customer extends input{
    public static void displayMedicine() throws SQLException{
        ArrayList<medicineDTO> arr=medicineController.medicineData();
        System.out.println("m_id  m_name         m_price");
        for(int i=0;i<arr.size();i++){
            medicineDTO med=arr.get(i);
            System.out.print(med.getM_id()+"     ");
            System.out.print(med.getM_name()+"   ");
            System.out.println(med.getM_price());
        }
        buyMedicine();
    }
    public static void buyMedicine() throws SQLException{
        String mid="";
        String mquantity="";
        int amount=0;
        int price=0;
        ArrayList<ArrayList<Integer>> purchase=new ArrayList<>();
        while(true){
            System.out.println("-----Enter medicine_id to purchase-----");
            int m_id=sc.nextInt();
            price=medicineController.getPrice(m_id);
            if(price==-1)
            {
                System.out.println("INVALID ID");
                return;
            }
            System.out.println("-----Enter quantity-----");
            int quantity=sc.nextInt();
            if(quantity<1){
                System.out.println("***INVALID QUANTITY***");
                return;
            }
            boolean availability=stockController.checkQuantity(m_id, quantity);
            if(!availability){
                System.out.println("***STOCK IS NOT AVAILABLE***");
            }
            else{
                if(mid.length()>0){
                    mid=mid+","+m_id;
                    mquantity=mquantity+","+quantity;
                }
                else{
                    mid=mid+m_id;
                    mquantity=mquantity+quantity;
                }
                ArrayList<Integer> temp =new ArrayList<>();
                temp.add(m_id);
                temp.add(quantity);
                purchase.add(temp);
                amount=amount+(price*quantity);
                System.out.println("-----Enter 1 to continue shopping-----");
                System.out.println("-----Enter 2 pay bill-----");
                int choice=sc.nextInt();
                if(choice!=1)
                break;
            }
        }
        if(amount>0){
            paymentController.addPayment(amount, mquantity, mid);
            System.out.println("m_name     m_quantity    Total_amount  ");
            for(int i=0;i<mid.length();i=i+2){
                String temp=mid.substring(i, i+1);
                System.out.println(medicineController.getName(Integer.parseInt(temp))+"  "+mquantity.charAt(i)+"    c      "+amount);
            }
            System.out.println("");
            // System.out.println("TOTAL AMOUNT =  "+amount);
            stockController.alterQuantity(purchase);
            System.out.println("***PAYMENT SUCCESSFUL***");
            System.out.println("***YOUR ORDER HAS BEEN PLACED***");
        }
        return;
    }
}