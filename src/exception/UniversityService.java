package exception;

import java.text.DecimalFormat;

/**
 * Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */

public class UniversityService {

    public static Student getStudentByInfo(University university, String facultyName, String groupName,
                                           String fullName) {

        try {
            Group group = getGroupByInfo(university, facultyName, groupName);
            int index = search(group.getStudentNames(), fullName);
            if (index == -1) {
                System.out.println("There is no such student in group" + groupName + " of faculty " + facultyName);
                return null;
            }
            return group.getStudentList()[index];
        } catch (NullPointerException e) {
            System.out.println("Group is NULL");
            return null;
        }

    }

    public static Group getGroupByInfo(University university, String facultyName, String groupName) {

        try {
            Faculty faculty = getFacultyByName(university, facultyName);
            int index = search(faculty.getGroupNames(), groupName);
            if (index == -1) {
                System.out.println("There is no such group in faculty" + facultyName);
                return null;
            }
            Group group = faculty.getGroups()[index];
            return group;
        } catch (NullPointerException e) {
            System.out.println("Faculty is null!");
            return null;
        }
    }

    public static Faculty getFacultyByName(University university, String facultyName) {
        int index = search(university.getFacultyNames(), facultyName);
        if (index == -1) {
            System.out.println("There is no such faculty!");
            return null;
        }
        Faculty faculty = university.getFacultyList()[index];
        return faculty;
    }

    public static int search(String arr[], String x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(x))
                return i;
        }
        return -1;
    }

    public static int search(CourseGrade courseGrades[], String courseName) {
        int n = courseGrades.length;
        for (int i = 0; i < n; i++) {
            if (courseGrades[i].getCourseName().equals(courseName))
                return i;
        }
        return -1;
    }
}
