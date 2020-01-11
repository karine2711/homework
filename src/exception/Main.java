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

        //count given student's mean grade
        try {
            Student student = AUA.getStudentByInfo("CS", 'A', "Karine Gevorgyan");
            student.printCourseGrades();
            System.out.println("Mean grade = "+student.countMeanGrade());
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

            //count mean grade in a given group, for a given subject
        try {
            Group group=AUA.getGroupByInfo("EC",'B');

            System.out.println("Mean grade for given subject in group "
                    +group.getName()
                    +" = "+group.countMeanGrade("Work ethics")
            );
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println();

        } catch (NullPointerException e){
            e.printStackTrace();
        }

        //Count mean grade in given faculty
        try {
            Faculty faculty=AUA.getfacultyByName("CS");

            System.out.println("Mean grade for given subject in faculty "
                    +faculty.getName()
                    +" = "+faculty.countMeanGrade("Data Structures")
            );

        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("The faculty doesn't contain the given course");
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println();
        }

        try {
            Faculty faculty=AUA.getfacultyByName("CS");

            System.out.println("Mean grade for given subject in University "
                    +" = "+AUA.countMeanGrade("Data Structures")
            );

        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("The University doesn't contain the given course");
        }


        System.out.println("Finished successfully!");

    }
}
