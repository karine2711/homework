package exception;

import exception.exceptions.*;

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
    private static final University UNIVERSITY;

    static {
        University UNIVERSITY1;
        try {
            UNIVERSITY1 = new University(new Faculty[]{new Faculty("CS"), new Faculty("EC")});

        } catch (NullFacultyListException e) {
            try {
                UNIVERSITY1 = new University(new Faculty[]{new Faculty("Default")});
            } catch (NullFacultyListException ex) {
                ex.printStackTrace();
                UNIVERSITY1 = null;
            }

        }
        UNIVERSITY = UNIVERSITY1;
    }

    private Faculty[] facultyList;
    private Student[] studentList;
    private String[] facultyNames;

    private University(Faculty[] faculties) throws NullFacultyListException {
        if (faculties.length == 0) {

            throw new NullFacultyListException();

        } else {
            facultyList = faculties;
        }
    }

    public static University getUniversity(String... faculties) {
        return UNIVERSITY;
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

    public void setStudentList(Student[] studentList) throws NullStudentListException {
        if (studentList.length == 0) {
            throw new NullStudentListException();
        } else {
            this.studentList = studentList;
        }
    }

}
