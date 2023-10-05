package Package_Book;

import java.io.*;
import java.util.ArrayList;

public class BookManagment extends Book{
	private static final long serialVersionUID = 1L;
	ObjectInputStream book_in=null;
    ObjectOutputStream book_out = null;
    File Book_file = new File("Books.dot");
    ArrayList<Book> Book_list = null;
    @SuppressWarnings("unchecked")
	public BookManagment(){
        Book_list = new ArrayList<Book>();
        try {
            book_in =new ObjectInputStream(new FileInputStream(Book_file));
            Book_list = (ArrayList<Book>) book_in.readObject();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }
    public void BookAadd(Book book){
        Book_list.add(book);
    }
    public void ViewEachBook(){
        for(Book book:Book_list){
            System.out.println(book);
        }
    }
    public Book SearchBook(int ibsc){
        for (Book book : Book_list){
            if(ibsc==book.getIbsc()){
                return book;
            }
        }
        return null;
    }
    public void searchBookBySubject(String subject){
        for(Book book:Book_list){
            if(book.getSubject().equals(subject)){
                System.out.println(book);
            }
        }
    }
    public boolean DeleteBook(int ibsc){
        for (Book book : Book_list){
            if(ibsc==book.getIbsc()){
                Book_list.remove(book);
                return true;
            }
        }
        return false;
    }
    public boolean UpdateBook(int Update_ibsc, String title, String author, String publisher, String subject, int available_quantity){
        for (Book book : Book_list){
            if(Update_ibsc==book.getIbsc()){
                book.setAuthor(author);
                book.setAvailable_quantity(available_quantity);
                book.setPublisher(publisher);
                book.setSubject(subject);
                book.setTitle(title);
                return true;
            }
        }
        return false;
    }
    public void writeToFile() {
    	try {
			book_out = new ObjectOutputStream(new FileOutputStream(Book_file));
			book_out.writeObject(Book_list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
