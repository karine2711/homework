package university.exceptions.itemNotFoundExceptions;

public class GroupNotFoundException extends ItemNotFoundException {

    String groupName;
    String facultyName;

    public GroupNotFoundException(String groupName, String facultyName) {
        this.groupName = groupName;
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "There is no group " + groupName +
                " in faculty " + facultyName + "!";
    }
}
