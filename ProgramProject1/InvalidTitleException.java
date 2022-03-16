import java.util.InputMismatchException;

public class InvalidTitleException extends InputMismatchException {

    public InvalidTitleException() {
        super("Invalid message");
    }

    public InvalidTitleException(String input) {
        super(input);
    }
    
}
