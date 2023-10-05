package Package_Person;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Person implements Serializable{
    
	private static final long serialVersionUID = 1L;
	protected String name;
    protected String emailId;
    protected String phoneNumber;
    protected String address;
    protected String dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        boolean isNameValid = Pattern.matches("[a-zA-z]+",name);
        if(isNameValid){
            this.name = name;
        }
        else{
            this.name="default name";
        }
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        boolean isDobValid = Pattern.matches("\\d{2}-\\d{2}-\\d{2}",dob);
        if(isDobValid){
            this.dob = dob;
        }
        else{
            this.dob = "22-02-2003";
        }
    }

    public Person(String name, String emailId, String phoneNumber, String address, String dob) {
        this.setName(name);
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.setDob(dob);
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

