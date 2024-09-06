package Resources;

import java.sql.Date;

public class paymentDTO {
    private int p_id;
    private int p_amount;
    private Date p_date;
    private String p_quantity;
    private String m_id;
    private int u_id;

    public paymentDTO(int p_id,int p_amount,Date p_date,String p_quantity,String m_id,int u_id){
        this.p_id=p_id;
        this.p_amount=p_amount;
        this.p_date=p_date;
        this.p_quantity=p_quantity;
        this.m_id=m_id;
        this.u_id=u_id;
    }
    public int getP_id() {
        return this.p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getP_amount() {
        return this.p_amount;
    }

    public void setP_amount(int p_amount) {
        this.p_amount = p_amount;
    }

    public Date getP_date() {
        return this.p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getP_quantity() {
        return this.p_quantity;
    }

    public void setP_quantity(String p_quantity) {
        this.p_quantity = p_quantity;
    }

    public String getM_id() {
        return this.m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public int getU_id() {
        return this.u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

}
