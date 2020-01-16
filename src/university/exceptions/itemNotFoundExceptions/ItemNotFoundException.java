package university.exceptions.itemNotFoundExceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
