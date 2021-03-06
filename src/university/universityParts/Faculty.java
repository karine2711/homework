package university.universityParts;

import university.exceptions.nullListExceptions.NullGroupListException;

import java.text.DecimalFormat;

/**
 * The faculty class represents the faculties of the university.
 * Contains a list of groups.
 *
 * @author Karine Gevorgyan
 */

public class Faculty {

    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String name;
    private Group[] groups;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroups(Group... groups) {
        this.groups = groups;
    }

    public Group[] getGroups() {
        if (groups == null) {
            throw new NullGroupListException(name);
        }
        return groups;
    }

    public String[] getGroupNames() {
        int size = getGroups().length;
        String[] groupNames = new String[size];
        for (int i = 0; i < size; i++) {
            groupNames[i] = groups[i].getName();
        }
        return groupNames;
    }

    public void printGroups() {
        for (Group group : getGroups()) {
            System.out.println("    " + group.getName());
            group.printStudents();

        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Group group : getGroups()) {
            double mean = group.countMeanGrade(courseName);
            sum += mean;
            if (mean != 0) {
                quantity++;
            }
        }
        if (quantity == 0) {
            return 0;
        }
        return Double.parseDouble(numberFormat.format(sum / quantity));

    }

}
