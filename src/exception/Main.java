package exception;

import exception.exceptions.NullFacultyListException;
import exception.exceptions.NullGroupListException;

public class Main {
    public static void main(String[] args)  {

        University AUA = University.getUniversity();
        Faculty[] faculties = AUA.getFacultyList();
        UniversityService.initializeGroups(faculties);
        UniversityService.initializeStudents(AUA);
        System.out.println(AUA.getStudentList()[2].getFullName());


        System.out.println("Finished successfully!");

    }
}
