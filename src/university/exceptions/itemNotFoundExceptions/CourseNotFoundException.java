package university.exceptions.itemNotFoundExceptions;

public class CourseNotFoundException extends ItemNotFoundException {

     public CourseNotFoundException(String courseName, String studentName) {
        super(String.format("Student %s doesn't take %s",studentName, courseName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
