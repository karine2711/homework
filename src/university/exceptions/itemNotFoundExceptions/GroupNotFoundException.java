package university.exceptions.itemNotFoundExceptions;

public class GroupNotFoundException extends ItemNotFoundException {

    public GroupNotFoundException(String groupName, String facultyName) {
        super(String.format("There is no group %s in faculty %s!",groupName,facultyName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
