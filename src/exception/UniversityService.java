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
//                new Student("Karine Gevorgyan", 1, 'A'),
//                new Student("Siranush Mshetsyan", 1, 'A'),
//                new Student("Vahag Mkrtchyan", 1, 'B'),
//                new Student("Anahit Chaxmaxchyan", 1, 'B'),
//                new Student("Milena Xachatryan", 1, 'B'),
//                new Student("Lolita Bryusovna", 2, 'A'),
//                new Student("Torgom Rostovyan", 2,'A'),
//                new Student("Karlen Yesayan", 2, 'B'),
//                new Student("Vazgen Martirosyan", 2, 'B'),
//                new Student("Perch Proshyan", 2, 'B'),
        };
        try {
            uni.setStudentList(students);
        } catch (NullStudentListException e) {
            System.out.println("Please add students to the university!");
        }

    }
}
