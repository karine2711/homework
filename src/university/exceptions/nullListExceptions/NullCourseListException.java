package university.exceptions.nullListExceptions;

public class NullCourseListException extends NullListException {

    public NullCourseListException(String studentName){
        super(String.format("NullCourseListException! Student %s doesn't study any courses!",studentName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
