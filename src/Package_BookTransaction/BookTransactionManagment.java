package Package_BookTransaction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookTransactionManagment {
    ObjectOutputStream bookTransactionOut = null;
    ObjectInputStream bookTransactionIn = null;
    File BookTransaction_file = null;
    ArrayList<BookTransaction> BookTransactions_List = null;
    @SuppressWarnings("unchecked")
	public BookTransactionManagment(){
        
        try {
        	BookTransaction_file = new File("BookTransaction.dot");
            BookTransactions_List = new ArrayList<BookTransaction>();
            bookTransactionIn = new ObjectInputStream(new FileInputStream(BookTransaction_file));
            BookTransactions_List = (ArrayList<BookTransaction>) bookTransactionIn.readObject();
        } catch (IOException e) {
        	System.out.print(e);
        } catch (ClassNotFoundException e) {
        	System.out.print(e);
        }
    }
    public boolean issueBook(int rollNo,int isbc){
        int TotalBookIssue=0;
        for(BookTransaction bookTransaction:BookTransactions_List){

            if((rollNo==bookTransaction.getRollNo())&&(bookTransaction.getReturnDate()==null)){
                TotalBookIssue+=1;
            }
            if(TotalBookIssue>=3){
                return false;
            }

        }
        String issue_date = new SimpleDateFormat("DD-MM-YYYY").format(new Date());
        BookTransaction bookTransaction1 = new BookTransaction(isbc,rollNo,issue_date,null);
        BookTransactions_List.add(bookTransaction1);
        return true;
    }
    public boolean returnBook(int rollNo,int isbc){
        for(BookTransaction bookTransaction:BookTransactions_List){
            if((rollNo==bookTransaction.getRollNo())&&(isbc==bookTransaction.getIsbn())&&(bookTransaction.getReturnDate()==null)){
                String Return_Date = new SimpleDateFormat("DD-MM-YYYY").format(new Date());
                bookTransaction.setReturnDate(Return_Date);
                return true;
            }
        }
        return false;
    }
    public void writeToFile() {
    	try {
    		bookTransactionOut = new ObjectOutputStream(new FileOutputStream(BookTransaction_file));
    		bookTransactionOut.writeObject(BookTransactions_List);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void viewAllTransaction(){
        for(BookTransaction bookTransaction:BookTransactions_List){
            System.out.println(bookTransaction);
        }
    }
}
