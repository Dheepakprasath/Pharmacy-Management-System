package Resources;

public class userDTO {
    private int u_id;
    private String u_email;
    private String u_password;
    private String u_role;

    public userDTO(int u_id,String u_email,String u_password,String u_role){
        this.u_id=u_id;
        this.u_email=u_email;
        this.u_password=u_password;
        this.u_role=u_role;
    }
    public int getU_id() {
        return this.u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_email() {
        return this.u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_password() {
        return this.u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_role() {
        return this.u_role;
    }

    public void setU_role(String u_role) {
        this.u_role = u_role;
    }

}
