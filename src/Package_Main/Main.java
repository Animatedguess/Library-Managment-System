package Package_Main;

import Package_Book.Book;
import Package_Book.BookManagment;
import Package_BookTransaction.BookTransactionManagment;
import Package_Exception.BookNotFoundException;
import Package_Exception.StudentNotFoundException;
import Package_Person.Student;
import Package_Person.StudentManagment;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int choose;
        Scanner sc = new Scanner(System.in);
			BookManagment bm = new BookManagment();
			BookTransactionManagment btm = new BookTransactionManagment();
			StudentManagment sm = new StudentManagment();
			while(true){
			    System.out.println("\nEnter 1 for Student\nEnter 2 for Libriran\nEnter 3 for exit");
			    choose= sc.nextInt();
			    if(choose==3) {
			    	break;
			    }
			    if(choose==1) {
			            try{
			                System.out.print("Enter your rollNo:");
			                int rollNo = sc.nextInt();
			                Student student = sm.findStudent(rollNo);
			                if(student==null){
			                    throw new StudentNotFoundException();
			                }
			                int stuChoose;
			                while (true){
			                    System.out.println("Enter 11 for View All Books\nEnter 12 for Search book by its isbc\nEnter 13 for List book by Subjects\nEnter 14 for issue a book\nEnter 15 for return a book\nEnter 99 for Exit");
			                    stuChoose = sc.nextInt();
			                    switch (stuChoose){
			                        case 11:
			                            System.out.println("View all books is Selected");
			                            bm.ViewEachBook();
			                            break;
			                        case 12:
			                            System.out.println("Search book by its isbc is Selected");
			                            System.out.println("Enter your book isbc:");
			                            int isbc = sc.nextInt();
			                            bm.SearchBook(isbc);
			                            break;
			                        case 13:
			                            System.out.println("List Books by subject is Selected");
			                            System.out.println("Enter your Subject name:");
			                            String sub = sc.next();
			                            bm.searchBookBySubject(sub);
			                            break;
			                        case 14:
			                            try {
			                            	System.out.print("Enter the Book Isbn for issue Book:");
				                            int Issue_Isbn=sc.nextInt();
				                            Book book = bm.SearchBook(Issue_Isbn);
				                            if(book == null) {
				                            	throw new BookNotFoundException();
				                            }
				                            if(book.getAvailable_quantity()>0) {
				                            	if(btm.issueBook(rollNo, Issue_Isbn)) {
					                            	book.setAvailable_quantity(book.getAvailable_quantity()-1);
					                            	System.out.println("Book has Been Issued");
					                            }
				                            }
				                            else {
				                            	System.out.println("Book is not Availabled");
				                            }
			                            }catch(BookNotFoundException e) {
			                            	e.printStackTrace();
			                            }
			                            
			                            break;
			                        case 15:
			                        	try {
			                            	System.out.print("Enter the Book Isbn for return Book:");
				                            int Return_Isbn=sc.nextInt();
				                            Book book = bm.SearchBook(Return_Isbn);
				                            if(book == null) {
				                            	throw new BookNotFoundException();
				                            }
				                            else {
				                            	if(btm.returnBook(rollNo,Return_Isbn)) {
					                            	book.setAvailable_quantity(book.getAvailable_quantity()+1);
					                            	System.out.println("Book is Successfully Return");
					                            }
				                            	else {
				                            		System.out.println("Book is unSuccessfully to Return");
				                            	}
				                            }
			                            }catch(BookNotFoundException e) {
			                            	e.printStackTrace();
			                            }
			                            break;
			                        case 99:
			                        	break;
			                        default:System.out.println("choose is inCurrent");
			                    }
			                    break;
			                }

			            }catch (StudentNotFoundException se){
			                System.out.println(se);
			            }
			        }
			        else if(choose ==2) {
			        	int Lib_Choose;
			        	while(true) {
			        		
				        	
				        	System.out.println("Enter 11 to View All Students\nEnter 12 to Print a Student by Roll Number\nEnter 13 to Register a Student\nEnter 14 to update a student\nEnter 15 to delete a Student");
				        	System.out.println("Enter 21 to View All Books\nEnter 22 to Print a Book by Isbn\nEnter 23 to Add a new Book\nEnter 24 to update a Book\nEnter 25 to delete a Book");
				        	System.out.println("Enter 31 to View All Transactions");
				        	System.out.println("Enter 99 to Exit");
				        	Lib_Choose = sc.nextInt();
				        	if(Lib_Choose==99) {
				        		break;
				        	}
				        switch(Lib_Choose) {
				        	case 11: //View All Students
				        		System.out.println("All the Students Records");
				        		sm.ViewStudentList();
				        	break;
				        	
				        	case 12: //Search student by its rollNo
				        		System.out.print("Enter the Student RollNo:");
				        		int rollNo = sc.nextInt();
				        		Student student = sm.findStudent(rollNo);
				        		if(student == null) {
				        			System.out.println("Student is not Found in System");
				        		}
				        		else {
				        			System.out.println(student);
				        		}
				        	break;
				        	
				        	case 13: //Register a new student
				        		System.out.println("Enter the Student Details");
				        		String name;
				        	    String emailId;
				        	    String phoneNumber;
				        	    String address;
				        	    String dob;
				        	    int roolNo;
				        	    int std;
				        	    String divison;
				        	    System.out.println("Enter the Student Name:");
				        	    name = sc.next();
				        	    
				        	    System.out.println("Enter the Student EmailId:");
				        	    emailId = sc.next();
				        	    
				        	    System.out.println("Enter the Student PhoneNumber:");
				        	    phoneNumber = sc.next();
				        	    
				        	    System.out.println("Enter the Student address:");
				        	    address = sc.next();
				        	    
				        	    System.out.println("Enter the Student DOB:");
				        	    dob = sc.next();
				        	    
				        	    System.out.println("Enter the Student RollNumber:");
				        	    rollNo = sc.nextInt();
				        	    
				        	    System.out.println("Enter the Student Std:");
				        	    std = sc.nextInt();
				        	    
				        	    System.out.println("Enter the Student Division:");
				        	    divison = sc.next();
				        	    
				        	    Student newstudent = new Student(name,emailId,phoneNumber,address,dob,rollNo,std,divison);
				        	    sm.addStudent(newstudent);
				        	break;
				        	
				        	case 14://Update a Student 
				        		try {
				        			System.out.print("Enter your Updated Student RollNo:");
					        		int update_RollNo;
					        		update_RollNo=sc.nextInt();
					        		student = sm.findStudent(update_RollNo);
					        		if(student == null) {
					        			throw new StudentNotFoundException();
					        		}
					        		System.out.println("Enter the Student new Name:");
					        	    name = sc.next();
					        	    
					        	    System.out.println("Enter the Student new EmailId:");
					        	    emailId = sc.next();
					        	    
					        	    System.out.println("Enter the Student new PhoneNumber:");
					        	    phoneNumber = sc.next();
					        	    
					        	    System.out.println("Enter the Student new address:");
					        	    address = sc.next();
					        	    
					        	    System.out.println("Enter the Student new DOB:");
					        	    dob = sc.next();
					        	    
					        	    System.out.println("Enter the Student new RollNumber:");
					        	    rollNo = sc.nextInt();
					        	    
					        	    System.out.println("Enter the Student new Std:");
					        	    std = sc.nextInt();
					        	    
					        	    System.out.println("Enter the Student new Division:");
					        	    divison = sc.next();
					        	    
					        	    sm.UpdateStudent(name, emailId, phoneNumber,address, dob, update_RollNo, std,divison);
					        	    System.out.println("Student is Updated");
				        		}catch(StudentNotFoundException se) {
				        			System.out.println(se);
				        		}
				        	break;
				        	
				        	case 15://Delete a Student
				        	    int rollNo1;
				        		System.out.println("Enter the Student RollNumber:");
				        	    rollNo1 = sc.nextInt();
				        	    if(sm.deleteStudent(rollNo1)) {
				        	    	System.out.println("Student Record is Removed");
				        	    }
				        	    else {
				        	    	System.out.println("No Record Exits with RollNo");
				        	    }
				        	break;
				        	case 21://view All Books
				        		System.out.println("List of Books are:-");
				        		bm.ViewEachBook();
				        	break;
				        	case 22://Search a Book by isbn
				        		int ibsc;
				        		ibsc = sc.nextInt();
				        		Book book = bm.SearchBook(ibsc);
				        		System.out.println(book);
				        	break;
				        	case 23://Add a New Book
				        		System.out.println("Enter the Book Details");
				        		int newIbsc;
				        	    String title;
				        	    String author;
				        	    String publisher;
				        	    String subject;
				        	    int available_quantity;
				        	    System.out.println("Enter the Book Isbn:");
				        	    newIbsc = sc.nextInt();
				        	    
				        	    System.out.println("Enter the book Title:");
				        	    title = sc.next();
				        	    
				        	    System.out.println("Enter the Book author:");
				        	    author = sc.next();
				        	    
				        	    System.out.println("Enter the Book Publisher:");
				        	    publisher = sc.next();
				        	    
				        	    System.out.println("Enter the Book Subject:");
				        	    subject = sc.next();
				        	    
				        	    System.out.println("Enter the Book available_quantity:");
				        	    available_quantity = sc.nextInt();
				        	break;
				        	case 24://Update a Book
				        		try {
				        			int Update_Ibsc;
					        		System.out.println("Enter the Book Isbn:");
					        	    Update_Ibsc = sc.nextInt();
					        		book = bm.SearchBook(Update_Ibsc);
					        		if(book==null) {
					        			throw new BookNotFoundException();
					        		}
					        		System.out.println("Enter the book newTitle:");
					        	    String newTitle = sc.next();
					        	    
					        	    System.out.println("Enter the Book newAuthor:");
					        	    String newAuthor = sc.next();
					        	    
					        	    System.out.println("Enter the Book newPublisher:");
					        	    String newPublisher = sc.next();
					        	    
					        	    System.out.println("Enter the Book newSubject:");
					        	    String newSubject = sc.next();
					        	    
					        	    System.out.println("Enter the Book new Available quantity:");
					        	    int newAvailable_quantity = sc.nextInt();
					        	    book = new Book(Update_Ibsc, newTitle, newAuthor, newPublisher, newSubject, newAvailable_quantity);
					        	    bm.BookAadd(book);
				        		}catch(BookNotFoundException e) {
				        			e.printStackTrace();
				        		}
				        	break;
				        	case 25://Delete a Book
				        		try {
				        			int Delete_Ibsc;
					        		System.out.println("Enter the Book Isbn:");
					        	    Delete_Ibsc = sc.nextInt();
					        		book = bm.SearchBook(Delete_Ibsc);
					        		if(book == null) {
					        			throw new BookNotFoundException();
					        		}
					        		else {
					        			bm.DeleteBook(Delete_Ibsc);
					        		}
				        		}catch(BookNotFoundException e) {
				        			e.printStackTrace();
				        		}
				        	case 31:
				        		System.out.println("All the transaction are:");
				        		btm.viewAllTransaction();
				        	break;
				        }  
			        }
			    }
			        else {
			        	System.out.println("Your Choose is Invalid");
			        }
			}
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
    }
}
