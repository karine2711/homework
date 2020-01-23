package studentlists.exceptions;

public class NullFormationException extends RuntimeException {

    public NullFormationException(String formationType) {
        super(String.format("The %s you provided is null!",formationType));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
