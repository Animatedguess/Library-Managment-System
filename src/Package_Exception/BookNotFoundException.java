package Package_Exception;

public class BookNotFoundException extends Exception{
  
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
        super();
    }

    @Override
    public String toString() {
        return "BookNotFoundException is generated in system";
    }
}
