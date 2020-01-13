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
        try {
            faculties[0].setGroups(new Group[]{
                    new Group('A', new String[]{"Introduction to CS", "Data Structures", "Discrete Maths"}),
                    new Group('B', new String[]{"Data Structures", "Discrete Maths", "Calculus", "Armenian Literature"})
            });
        } catch (NullGroupListException e) {
            try {
                DefaultHandler.setDefaultGroupList(faculties[0]);
            } catch (NullGroupListException ex) {
                ex.printStackTrace();
            }
        }

        try {
            faculties[1].setGroups(new Group[]{
                    new Group('A', new String[]{"Armenian Literature", "Art History", "English", "Creative Writing"}),
                    new Group('B', new String[]{"Art History", "Creative Writing", "Work ethics", "Book analysis"})
            });
        } catch (NullGroupListException e) {
            try {
                DefaultHandler.setDefaultGroupList(faculties[0]);
            } catch (NullGroupListException ex) {
                ex.printStackTrace();
            }
        }
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
            uni.setStudentList(students);
        } catch (NullStudentListException e) {
            System.out.println("Please add students to the university!");
        }
    }


    public static void distributeStudentsToFaculties(University uni) {
        Faculty[] faculties = uni.getFacultyList();
        try {
            Student[] students = uni.getStudentList();
            int facNum;
            for (Student student : students) {
                //    System.out.println(student.getGroupName());
                facNum = search( uni.getFacultyNames(),student.getFacultyName());
                int temp = faculties[facNum].getStudentQuantity();
                faculties[facNum].setStudentQuantity(++temp);
            }
            int facultyQuantity = uni.getFacultyList().length;

            for (int i = 0; i < facultyQuantity; i++) {
                int index = 0;

                Student[] studentList = new Student[faculties[i].getStudentQuantity()];
                for (Student student : students) {
                    facNum =search( uni.getFacultyNames(),student.getFacultyName());
                    if (facNum == i) {
                        studentList[index] = student;
                        index++;
                    }
                }
                faculties[i].setStudentList(studentList);
            }


        } catch (NullStudentListException e) {
            System.out.println("Failed to distribute students to faculties!");
            e.printStackTrace();
            return;
        }
    }

    public static void distributeStudentsToGroups(Faculty faculty) {
        Student[] students = faculty.getStudentList();
        Group[] groups = faculty.getGroups();
        for (Student student : students) {

            char groupName = student.getGroupName();

            int index = search(faculty.getGroupNames(), groupName);
            student.setGroupIndex(index);
            if (index != -1) {
                int temp = groups[index].getStudentQuantity();
                groups[index].setStudentQuantity(++temp);

            }
        }
        int groupQuantity = faculty.getGroups().length;

        for (int i = 0; i < groupQuantity; i++) {
            int index = 0;
            Student[] studentList = new Student[groups[i].getStudentQuantity()];
            for (Student student : students) {

                int groupIndex = student.getGroupIndex();

                if (groupIndex == i) {
                    studentList[index] = student;

                    index++;
                }
            }
            groups[i].setStudentList(studentList);
        }
    }

    public static void gradeStudents(Group group, boolean byScanner) {
        Scanner scanner = new Scanner(System.in);

        if (byScanner) {
            System.out.println("Group " + group.getName());
            group.printStudents();
            System.out.println("------------------");
        }

        Student[] students = group.getStudentList();
        String[] courseNames = group.getCourseNames();
        double grade;
        int courseQuantity = courseNames.length;
        for (Student student : students) {
            CourseGrade[] courseGrades = new CourseGrade[courseQuantity];
            for (int i = 0; i < courseQuantity; i++) {
                if (byScanner) {
                    System.out.println("Please enter " + student.getFullName() + "'s grade from " + courseNames[i]);
                    grade = scanner.nextDouble();
                    while (grade > 10 || grade < 0) {
                        System.out.println("The grade must be between 0 and 10");
                        grade = scanner.nextDouble();
                    }
                } else {
                    Random rd = new Random();

                    grade = rd.nextInt(9) + 1 + Double.parseDouble(numberFormat.format(rd.nextDouble()));
                }
                courseGrades[i] = new CourseGrade(courseNames[i], grade);

            }
            student.setCourseGrades(courseGrades);

        }

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

    public static void addStudent(String facultyName, char groupName, String studentName){
        University uni=University.getUniversity();
        Faculty faculty=uni.getfacultyByName(facultyName);
        Group group=uni.getGroupByInfo(facultyName,groupName);
        Student student=new Student.StudentBuilder(studentName,facultyName,groupName).build();
        Student[] temp=group.getStudentList();
        temp=DynamicArray.addElement(temp,student);

        group.setStudentList(temp);

        temp=faculty.getStudentList();
        temp=DynamicArray.addElement(temp,student);
        faculty.setStudentList(temp);
        try {
           temp=uni.getStudentList();
            temp=DynamicArray.addElement(temp,student);
            uni.setStudentList(temp);
        } catch (NullStudentListException e) {
            e.printStackTrace();
        }

    }



}
