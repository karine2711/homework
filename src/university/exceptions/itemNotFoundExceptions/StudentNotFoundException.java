package university.exceptions.itemNotFoundExceptions;

public class StudentNotFoundException extends ItemNotFoundException {

    public StudentNotFoundException(String studentName, String groupName, String facultyName) {
        super(String.format("There is no student %s in group %s of faculty %s!",studentName,groupName,facultyName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}

