package Airplane;
public class InvalidSeatException extends Exception{

    public InvalidSeatException() {
        super("Invalid seat number.");
    }

    public InvalidSeatException(String message) {
        super(message);
    }
    
}
