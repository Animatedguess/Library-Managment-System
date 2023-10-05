package Package_Person;

public class Student extends Person{
    
	private static final long serialVersionUID = 1L;
	private int roolNo;
    private int std;
    private String divison;

    public int getRoolNo() {
        return roolNo;
    }

    public void setRoolNo(int roolNo) {
        this.roolNo = roolNo;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public String getDivison() {
        return divison;
    }

    public void setDivison(String divison) {
        this.divison = divison;
    }

    public Student(String name, String emailId, String phoneNumber, String address, String dob, int roolNo, int std, String divison) {
        super(name, emailId, phoneNumber, address, dob);
        this.roolNo = roolNo;
        this.std = std;
        this.divison = divison;
    }

    public Student() {
        super();
    }
    public String toString() {
		return "Student{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                '}';}
}

