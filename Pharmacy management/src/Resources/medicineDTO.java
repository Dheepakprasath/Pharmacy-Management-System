package Resources;

public class medicineDTO {
    private int m_id;
    private String m_name;
    private int m_price;

    public medicineDTO(int m_id,String m_name,int m_price){
        this.m_id=m_id;
        this.m_name=m_name;
        this.m_price=m_price;
    }
    public int getM_id() {
        return this.m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return this.m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_price() {
        return this.m_price;
    }

    public void setM_price(int m_price) {
        this.m_price = m_price;
    }

}