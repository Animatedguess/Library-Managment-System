package Package_Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentManagment extends Student{
	private static final long serialVersionUID = 1L;
	ObjectInputStream studentIn = null;
    ObjectOutputStream studentOut = null;
    File Student_File = null;
    ArrayList<Student> Student_List = null;
    @SuppressWarnings("unchecked")
	public StudentManagment(){
        Student_File=new File("Student.dot");
        Student_List = new ArrayList<Student>();
        if(Student_File.exists()){
            try {
                studentIn = new ObjectInputStream(new FileInputStream(Student_File));
                Student_List = (ArrayList<Student>) studentIn.readObject();
            } catch (IOException e) {
            	System.out.print(e);
            } catch (ClassNotFoundException e) {
            	System.out.print(e);
            }
        }
    }
    public boolean UpdateStudent(String name, String emailId, String phoneNumber, String address, String dob, int Update_rollNo, int std, String divison) {
    	Iterator<Student> iterator = (Iterator<Student>) Student_List.iterator();
        while(iterator.hasNext()){
            Student UpdateStudent = new Student();
            UpdateStudent = iterator.next();
            if(Update_rollNo==UpdateStudent.getRoolNo()){
            	UpdateStudent.setAddress(address);
            	UpdateStudent.setDivison(divison);
            	UpdateStudent.setDob(dob);
            	UpdateStudent.setEmailId(emailId);
            	UpdateStudent.setName(name);
            	UpdateStudent.setPhoneNumber(phoneNumber);
            	UpdateStudent.setStd(std);
                return true;
            }
        }
    	return false;
    	
    }
    public void addStudent(Student student){
        Student_List.add(student);
    }
    public void ViewStudentList(){
        Iterator<Student> iterator = (Iterator<Student>) Student_List.iterator();
        while(iterator.hasNext()){
            Student newStudent = new Student();
            newStudent = iterator.next();
            System.out.println(newStudent);
        }
    }
    public Student findStudent(int rollNo){
        for(Student student:Student_List){
            if(rollNo==student.getRoolNo()){
                return student;
            }
        }
        return null;
    }
    public boolean deleteStudent(int rollNo){
        Iterator<Student> iterator = (Iterator<Student>) Student_List.iterator();
        while(iterator.hasNext()){
            Student delStudent = new Student();
            delStudent = iterator.next();
            if(rollNo==delStudent.getRoolNo()){
                Student_List.remove(delStudent);
                return true;
            }
        }
        return false;
    }
    public void writeToFile() {
    	try {
			studentOut = new ObjectOutputStream(new FileOutputStream(Student_File));
			studentOut.writeObject(Student_List);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
