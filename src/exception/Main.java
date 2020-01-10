package exception;

import exception.exceptions.NullFacultyListException;
import exception.exceptions.NullGroupListException;
import exception.exceptions.NullStudentListException;

public class Main {
    public static void main(String[] args)  {

        University AUA = University.getUniversity();
        Faculty[] faculties = AUA.getFacultyList();
        UniversityService.initializeGroups(faculties);
        UniversityService.initializeStudents(AUA);
        try {
            System.out.println(AUA.getStudentList()[2].getFullName());
        } catch (NullStudentListException e){
            e.printStackTrace();
        }



        System.out.println("Finished successfully!");

    }
}
