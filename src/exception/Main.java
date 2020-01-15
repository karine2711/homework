package exception;

import exception.exceptions.NullCourseListException;
import exception.exceptions.NullStudentListException;

public class Main {
    public static void main(String[] args) {

        //Create a university!
        University university = UniversityService.initializeUniversity();

        //grade all students randomly
//        university.gradeAllStudentsRandomly();

        //try to get a student and set a grade
        System.out.println("Try to get a student and set some course grades");
        try {
            Student karine = UniversityService.getStudentByInfo(
                    university,
                    "CS",
                    "CS1",
                    "Karine Gevorgyan"
            );
            karine.setGrade("Armenian", 6);
            karine.setGrade("Maths",9);
        } catch (NullPointerException ignored) {} //because it's handled within the getStudentByInfo()

        //print the whole University structure
        System.out.println("\n------------------------------------------\nThe whole University structure\n");
      try{
          university.printFaculties();
      }catch (NullStudentListException e){
          e.printStackTrace();
      };


        // count given student's mean grade
        System.out.println("-------------------------------------------------");
        System.out.println("Count given student's mean grade");
        try {
            Student karine = UniversityService.getStudentByInfo(university, "CS", "CS1", "Karine Gevorgyan");
            System.out.println(karine.getFullName());
            karine.printCourseGrades();
            System.out.println("Mean grade = " + karine.countMeanGrade());
            System.out.println("---------------------------------");

        } catch (NullCourseListException e){
            e.printStackTrace();
        }catch (NullPointerException ignored) {}


        //  count mean grade in a given group, for a given subject
       // System.out.println("Count mean grade in a given group, for a given subject");
//        try {
//            Group group = UniversityService.getGroupByInfo(university, "EC", "B");
//            double grade = group.countMeanGrade("Business");
//            if (grade == 0) {
//                System.out.println("No such course in the group, or the students where not graded!");
//            } else {
//                System.out.println("Mean grade for given subject in group "
//                        + group.getName()
//                        + " = " + grade
//                );
//            }
//            System.out.println("---------------------------------");
//
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }




        //Count mean grade in given faculty




//        System.out.println("Count mean grade in given faculty for given subject");
//        try {
//            Faculty faculty = UniversityService.getFacultyByName(university, "CS");
//            double grade = faculty.countMeanGrade("Armenian Literature");
//            if (grade == 0) {
//                System.out.println("No such course in the faculty, or the students where not graded!");
//            } else {
//                System.out.println("Mean grade for given subject in faculty "
//                        + faculty.getName()
//                        + " = " + grade
//                );
//                System.out.println("---------------------------------");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }




        //Count mean grade in university for given subject
//        System.out.println("Count mean grade in the university for given subject");
//        try {
//            double grade = university.countMeanGrade("Data Structures");
//            if (grade == 0) {
//                System.out.println("No such course in the university, or the students where not graded!");
//            } else {
//                System.out.println("Mean grade for given subject in University "
//                        + " = " + university.countMeanGrade("Data Structures")
//                );
//            }
//            System.out.println("---------------------");
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }

    }

}
