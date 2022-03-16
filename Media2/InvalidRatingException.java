package Media2;
import java.util.InputMismatchException;

public class InvalidRatingException extends InputMismatchException {

    public InvalidRatingException() {
        super("Invalid message");
    }

    public InvalidRatingException(String input) {
        super(input);
    }
    
}
