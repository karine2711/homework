package university.exceptions.itemNotFoundExceptions;

public class FacultyNotFoundException extends ItemNotFoundException {

    public FacultyNotFoundException(String facultyName) {
        super(String.format( "There is no faculty %s in the University!",facultyName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
