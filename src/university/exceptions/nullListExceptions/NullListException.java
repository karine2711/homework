package university.exceptions.nullListExceptions;

public class NullListException extends RuntimeException {

    public NullListException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
