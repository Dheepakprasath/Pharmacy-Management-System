package Resources;

public class employeeDTO {
    private int e_id;
    private String e_name;
    private int e_salary;
    private String e_job;
    public employeeDTO(int e_id,String e_name,int e_salary,String e_job){
        this.e_id=e_id;
        this.e_name=e_name;
        this.e_salary=e_salary;
        this.e_job=e_job;
    }
    public int getE_id() {
        return this.e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return this.e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_salary() {
        return this.e_salary;
    }

    public void setE_salary(int e_salary) {
        this.e_salary = e_salary;
    }

    public String getE_job() {
        return this.e_job;
    }

    public void setE_job(String e_job) {
        this.e_job = e_job;
    }
   
    
}
