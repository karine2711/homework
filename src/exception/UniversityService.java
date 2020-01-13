package exception;

import exception.exceptions.NullGroupListException;
import exception.exceptions.NullStudentListException;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */
public class UniversityService {
    final static DecimalFormat numberFormat = new DecimalFormat("#.0");

    public static Student getStudentByInfo(University university, String facultyName, String groupName, String fullName) {

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

    public static int search(Student students[], String studentName) {
        int n = students.length;
        for (int i = 0; i < n; i++) {
            if (students[i].getFullName().equals(studentName))
                return i;
        }
        return -1;
    }

//    public static void addStudent(String facultyName, char groupName, String studentName){
//        University uni=University.getUniversity();
//        Faculty faculty=uni.getfacultyByName(facultyName);
//        Group group=uni.getGroupByInfo(facultyName,groupName);
//        Student student=new Student.StudentBuilder(studentName,facultyName,groupName).build();
//        Student[] temp=group.getStudentList();
//        temp=DynamicArray.addElement(temp,student);
//
//        group.setStudentList(temp);
//
//        temp=faculty.getStudentList();
//        temp=DynamicArray.addElement(temp,student);
//        faculty.setStudentList(temp);
//        try {
//           temp=uni.getStudentList();
//            temp=DynamicArray.addElement(temp,student);
//            uni.setStudentList(temp);
//        } catch (NullStudentListException e) {
//            e.printStackTrace();
//        }
//
//    }


}
