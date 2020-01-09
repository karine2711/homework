package exception;
/**
 * Adds default values to null objects.
 *
 * @author Karine Gevorgyan
 */
public class DefaultHandler {
    public static void setDefaultGroupList(Faculty faculty){
        faculty.setGroups(new Group[]{new Group('A', new  String[]{"Armenian Language","Armenian Literature"})});
    }

}
