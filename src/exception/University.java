package exception;

import exception.exceptions.NullFacultyListException;

import java.text.DecimalFormat;

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
    private Faculty[] faculties;
    private String[] facultyNames;

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFaculties(Faculty... faculties) {
        this.faculties = faculties;
    }

    public Faculty[] getFaculties() {
        if (faculties == null) {
            throw new NullFacultyListException(name);
        }
        return faculties;

    }

    public String[] getFacultyNames() {
        int size = getFaculties().length;
        facultyNames = new String[size];
        for (int i = 0; i < size; i++) {
            facultyNames[i] = faculties[i].getName();
        }
        return facultyNames;
    }

    public void printFaculties() {
        for (Faculty faculty : getFaculties()) {
            System.out.println(faculty.getName());
            faculty.printGroups();

        }
    }

    public void gradeAllStudentsRandomly() {
        for (Faculty faculty : getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    student.gradeStudentRandomly();
                }
            }
        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Faculty faculty : getFaculties()) {
            double mean = faculty.countMeanGrade(courseName);
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
