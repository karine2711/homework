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

    public static void initializeGroups(Faculty[] faculties) {

        faculties[0].setGroups(new Group[]{
                new Group('A'),
                new Group('B')
        });



        faculties[1].setGroups(new Group[]{
                new Group('A'),
                new Group('B')
        });

    }

    public static void initializeStudents(University uni) {
        Student[] students = new Student[]{
                new Student.StudentBuilder("Karine Gevorgyan", "CS", 'A')
                        .courseGrade("Data Science",10)
                        .course("Intro to CS")
                        .course("Some course")
                        .build(),
//                new Student("Siranush Mshetsyan", "CS", 'A'),
                new Student.StudentBuilder("Vahag Mkrtchyan", "CS", 'B').build(),
//                new Student("Anahit Chaxmaxchyan", "CS", 'B'),
//                new Student("Milena Xachatryan", "CS", 'B'),
                new Student.StudentBuilder("Lolita Bryusovna", "EC", 'A').build(),
//                new Student("Torgom Rostovyan", "EC", 'A'),
                new Student.StudentBuilder("Karlen Yesayan", "EC", 'B').build(),
//                new Student("Vazgen Martirosyan", "EC", 'B'),
//                new Student("Perch Proshyan", "EC", 'B'),
        };
        try {
            distributeStudentsToGroups(students);
            uni.setStudentList(students);
        } catch (NullStudentListException e) {
            System.out.println("Please add students to the university!");
        }
    }

    public static void distributeStudentsToGroups(Student[] students) {
        University uni=University.getUniversity();
        for (Student student : students) {
            char groupName = student.getGroupName();
            String facultyName=student.getFacultyName();
            Faculty faculty= getFacultyByName(facultyName);
            int groupIndex=search(faculty.getGroupNames(),groupName);
            Group group=faculty.getGroups()[groupIndex];
            Student[] temp=group.getStudentList();
            DynamicArray.addElement(temp,student);
            group.setStudentList(temp);
        }
    }

    public static Student getStudentByInfo(String facultyName, char groupName, String fullName) {

        try {
            Group group = getGroupByInfo(facultyName, groupName);
            int index =search(group.getStudentNames(), fullName);
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

    public static Group getGroupByInfo(String facultyName, char groupName) {

        try {
            Faculty faculty = getFacultyByName(facultyName);
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

    public static Faculty getFacultyByName(String facultyName) {
        University university=University.getUniversity();
        int index = search(university.getFacultyNames(), facultyName);
        if (index == -1) {
            System.out.println("There is no such faculty!");
            return null;
        }
        Faculty faculty = university.getFacultyList()[index];
        return faculty;
    }

    public static int search(char arr[], char x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int search(String arr[], String x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(x))
                return i;
        }
        return -1;
    }

    public static int search(CourseGrade arr[], String  x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i].getCourseName().equals(x))
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
