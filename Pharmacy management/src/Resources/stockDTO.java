package Resources;

public class stockDTO {
    private int s_id;
    private int s_count;
    private int m_id;
    
    public stockDTO(int s_id,int s_count,int m_id){
        this.s_id=s_id;
        this.s_count=s_count;
        this.m_id=m_id;

    }

    public int getS_id() {
        return this.s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_count() {
        return this.s_count;
    }

    public void setS_count(int s_count) {
        this.s_count = s_count;
    }

    public int getM_id() {
        return this.m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }
}    
