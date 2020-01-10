package exception;

import exception.exceptions.NullFacultyListException;
import exception.exceptions.NullGroupListException;
import exception.exceptions.NullStudentListException;

public class Main {
    public static void main(String[] args)  {
        //Get the University and its faculties
        University AUA = University.getUniversity();
        Faculty[] faculties = AUA.getFacultyList();
        //Add groups to faculties
        UniversityService.initializeGroups(faculties);
        //Add Students to University
        UniversityService.initializeStudents(AUA);

      //  try {
            UniversityService.distributeStudentsToFaculties(AUA);
            //Distribute all students to groups
            for (Faculty faculty : faculties) {
                UniversityService.distributeStudentsToGroups(faculty);
            }
            //Grade all students
            for (Faculty faculty : faculties) {
                Group[] groups = faculty.getGroups();
                for (Group group : groups) {
                    UniversityService.gradeStudents(group, false);
                }
            }
            try {
                Student student = AUA.getStudentByInfo("CS", 'A', "Karine Gevorgyan");
                student.printCourseGrades();
                System.out.println("Mean grade = "+student.countMeanGrade());
                System.out.println("---------------------------------");
            } catch (NullPointerException e){
                e.printStackTrace();
            }


//        } catch (NullStudentListException e){
//            e.printStackTrace();
//        }


        System.out.println("Finished successfully!");

    }
}
