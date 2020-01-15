package university.exceptions.itemNotFoundExceptions;

public class StudentNotFoundException extends ItemNotFoundException {
    String studentName;
    String groupName;
    String facultyName;

    public StudentNotFoundException(String studentName, String groupName, String facultyName) {
        this.studentName = studentName;
        this.groupName = groupName;
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "There is no student " + studentName + " in group " + groupName +
                " of faculty " + facultyName + "!";
    }
}

