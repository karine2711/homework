package exception;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The faculty class represents the faculties of the university.
 * Contains lists of groups and students.
 *
 * @author Karine Gevorgyan
 */
public class Faculty {
    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String name;
    private Group[] groups = {};

    public Faculty(String name, Group... groups) {
        this.name = name;
        if (groups.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("The faculty must have at least one group!");
            this.groups = DefaultHandler.groupListCreator();
        } else {
            this.groups = groups;
        }
    }

    public String getName() {
        return name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public String[] getGroupNames() {
        String[] groupNames = new String[groups.length];
        for (int i = 0; i < this.getGroups().length; i++) {
            groupNames[i] = groups[i].getName();
        }
        return groupNames;
    }

    public void printGroups() {
        for (Group group:groups) {
            System.out.println("    "+group.getName());
            group.printStudents();

        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Group group : groups) {
            double mean = group.countMeanGrade(courseName);
            sum += mean;
            if (mean != 0) {
                quantity++;
            }
        }
        if (quantity==0){
            return 0;
        }
        return Double.parseDouble(numberFormat.format(sum / quantity));

    }
}
