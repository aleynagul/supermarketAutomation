public class Calisan extends Person{


    private int calisanId;
   private double salary;

    public  Calisan(String firstName,String lastName,int calisanId,double salary){
        super(firstName,lastName);
       this.setCalisanId(calisanId);
       this.setSalary(salary);
    }


    public int getCalisanId() {
        return calisanId;
    }

    public void setCalisanId(int calisanId) {
        this.calisanId = calisanId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

