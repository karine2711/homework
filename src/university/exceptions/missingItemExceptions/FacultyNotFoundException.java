package university.exceptions.missingItemExceptions;

public class FacultyNotFoundException extends ItemNotFoundException {
    String facultyName;

    public FacultyNotFoundException(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "There is no faulty " + facultyName +
                " in the University!";
    }
}
