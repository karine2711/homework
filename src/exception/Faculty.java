package exception;

import exception.exceptions.NullGroupListException;

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
    private Group[] groups;

    public Faculty(String name) {
        this.name = name;
    }

    public void setGroupList(Group...groups){
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public Group[] getGroups() {
        if(groups==null){
            throw new NullGroupListException(name);
        }
        return groups;
    }

    public String[] getGroupNames() {
       int size=getGroups().length;
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
