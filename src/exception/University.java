package exception;

import exception.exceptions.NullFacultyListException;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * University is a singletone class, as the program is written for a specific university.
 * It contains the list of faculties and the list of students in the university, as well
 * some methods to work with those lists.
 *
 * @author Karine Gevorgyan
 */

public class University {

    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String name;
    private Faculty[] facultyList;
    private String[] facultyNames;

    public University(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setFacultyList(Faculty...faculties){
        facultyList=faculties;
    }

    public Faculty[] getFacultyList() {
        if(facultyList==null){
            throw new NullFacultyListException(name);
        }
        return facultyList;

    }

    public String[] getFacultyNames() {
        int size=getFacultyList().length;
        facultyNames = new String[size];
        for (int i = 0; i < size; i++) {
            facultyNames[i] = facultyList[i].getName();
        }
        return facultyNames;
    }

    public void printFaculties() {
        for (Faculty faculty : getFacultyList()) {
            System.out.println(faculty.getName());
            faculty.printGroups();

        }
    }

    public void gradeAllStudentsRandomly(){
        for (Faculty faculty : getFacultyList()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudentList()) {
                    student.gradeStudentRandomly();
                }
            }
        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Faculty faculty:getFacultyList()) {
            double mean = faculty.countMeanGrade(courseName);
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
