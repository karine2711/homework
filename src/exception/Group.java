package exception;
/**
 * The Group class represents the groups in each faculty of the University.
 * Contains lists of courses and students.
 *
 *
 * @author Karine Gevorgyan
 */
public class Group {
    private char name;
    private String courseNames[];

    public Group(char name, String[] courseNames){
        this.name=name;
        this.courseNames=courseNames;
    }

    public char getName(){return name;}

    public String[] getCourseNames() {
        return courseNames;
    }
}
