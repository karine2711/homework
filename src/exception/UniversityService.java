package exception;

import exception.exceptions.NullGroupListException;
import exception.exceptions.NullStudentListException;

/**
 *Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */
public class UniversityService {

    public static void initializeGroups(Faculty[] faculties)  {
        try {
            faculties[0].setGroups(new Group[]{
                    new Group('A', new String[]{"Introduction to CS", "Data Structures", "Discrete Maths"}),
                    new Group('B', new String[]{"Data Structures", "Discrete Maths", "Calculus", "Armenian Literature"})
            });
        }catch (NullGroupListException e){
            try {
              DefaultHandler.setDefaultGroupList(faculties[0]);
                 }catch (NullGroupListException ex) {
                ex.printStackTrace();
            }
        }

        try {
            faculties[1].setGroups(new Group[]{
                    new Group('A', new String[]{"Armenian Literature", "Art History", "English", "Creative Writing"}),
                    new Group('B', new String[]{"Art History", "Creative Writing", "Work ethics", "Book analysis"})
            });
        } catch (NullGroupListException e){
            try {
                DefaultHandler.setDefaultGroupList(faculties[0]);
            }catch (NullGroupListException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void initializeStudents(University uni) {
        Student[] students = new Student[]{
                new Student("Karine Gevorgyan", 1, 'A'),
                new Student("Siranush Mshetsyan", 1, 'A'),
                new Student("Vahag Mkrtchyan", 1, 'B'),
                new Student("Anahit Chaxmaxchyan", 1, 'B'),
                new Student("Milena Xachatryan", 1, 'B'),
                new Student("Lolita Bryusovna", 2, 'A'),
                new Student("Torgom Rostovyan", 2,'A'),
                new Student("Karlen Yesayan", 2, 'B'),
                new Student("Vazgen Martirosyan", 2, 'B'),
                new Student("Perch Proshyan", 2, 'B'),
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
                facNum = student.getFacultyNumber();
                facNum--;
                int temp=faculties[facNum].getStudentQuantity();
                faculties[facNum].setStudentQuantity(++temp);
            }
            int facultyQuantity=uni.getFacultyList().length;

            for(int i=0; i<facultyQuantity;i++) {
                int index = 0;

              Student[] studentList= new Student[faculties[i].getStudentQuantity()];
                for (Student student : students) {
                    facNum = student.getFacultyNumber();
                    facNum--;
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
                int temp=groups[index].getStudentQuantity();
                groups[index].setStudentQuantity(++temp);
            }
        }
        int groupQuantity = faculty.getGroups().length;

        for (int i = 0; i < groupQuantity; i++) {
            int index = 0;
            groups[i].setStudentList(new Student[groups[i].getStudentQuantity()]);
            for (Student student : students) {

                int groupIndex = student.getGroupIndex();

                if (groupIndex == i) {
                    groups[i].studentList[index] = student;
                    index++;
                }
            }
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
}
