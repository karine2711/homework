package exception;

import exception.exceptions.*;

/**
 * University is a singletone class, as the program is written for a specific university.
 * It contains the list of faculties and the list of students in the university, as well
 * some methods to work with those lists.
 *
 * @author Karine Gevorgyan
 */
public class University {

    private static final University UNIVERSITY;
    static {
        University UNIVERSITY1;
        try {
           UNIVERSITY1=new University(new Faculty[]{new Faculty("CS"), new Faculty("EC")});

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

    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }

    public Student[] getStudentList() {
        return studentList;
    }


}
