package exception;

import exception.exceptions.*;

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
    private Faculty[] facultyList = {};
    private String[] facultyNames;

    public University(String name, Faculty... faculties) {
        this.name = name;
        if (faculties.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("The University must have at least one faculty!");
            facultyList = DefaultHandler.facultyListCreator();
        } else {
            facultyList = faculties;
        }
    }

    public Faculty[] getFacultyList() {
        return facultyList;
    }

    public String[] getFacultyNames() {
        facultyNames = new String[facultyList.length];
        for (int i = 0; i < facultyList.length; i++) {
            facultyNames[i] = facultyList[i].getName();
        }
        return facultyNames;
    }

    public void printFaculties() {
        for (Faculty faculty : facultyList) {
            System.out.println(faculty.getName());
            faculty.printGroups();

        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Faculty faculty:facultyList) {
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
