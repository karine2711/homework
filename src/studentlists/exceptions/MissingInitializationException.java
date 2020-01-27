package studentlists.exceptions;

public class MissingInitializationException extends RuntimeException {
    public MissingInitializationException(String formationType) {
        super(String.format("The %s is not initialized",formationType));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
