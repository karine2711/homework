package university.exceptions.missingItemExceptions;

public class ItemNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "ItemNotFoundException";
    }
}
