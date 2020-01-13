package exception;

import exception.exceptions.NullGroupListException;

import java.text.DecimalFormat;

/**
 * The faculty class represents the faculties of the university.
 * Contains lists of groups and students.
 *
 * @author Karine Gevorgyan
 */
public class Faculty {
    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String name;
    private Group[] groups={};
    private char[] groupNames;
    private Student[] studentList;
    private int studentQuantity = 0;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroups(Group[] groups) throws NullGroupListException {
        if (groups.length == 0) {
            throw new NullGroupListException();

        } else {
            this.groups = groups;
        }
    }

    public Group[] getGroups() {
        return groups;
    }

    public char[] getGroupNames() {
        groupNames = new char[groups.length];
        for (int i = 0; i < this.getGroups().length; i++) {
            groupNames[i] = groups[i].getName();
        }
        return groupNames;
    }

    public Student[] getStudentList() {
        return studentList;
    }

    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }

    public int getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(int studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

//    public double countMeanGrade(String courseName) {
//
//        double sum = 0;
//        int quantity = 0;
//        for (Group group : groups) {
//            double mean = group.countMeanGrade(courseName);
//            sum += mean;
//            if (mean != -1) {
//                quantity++;
//            }
//        }
//        return Double.parseDouble(numberFormat.format(sum / quantity));
//
//    }
}
