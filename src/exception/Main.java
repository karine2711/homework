package exception;

public class Main {
    public static void main(String[] args) {

        //Create a university!
        //*When the scanner opens please type everything besides 1, or you'll have to input everything by hand
        University university = new University("AUA", new Faculty("CS"), new Faculty("EC"));



        //try to get a student and set a grade
        try {
            Student karine = UniversityService.getStudentByInfo(
                    university,
                    "CS",
                    "A",
                    "Karine Gevorgyan"
            );
            karine.setGrade("Armenian Literature", 5);
        } catch (NullPointerException e) {
            System.out.println("no such student in the University!");
        }



        //grade all students randomly
        for (Faculty faculty : university.getFacultyList()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudentList()) {
                    student.gradeStudentRandomly();
                }
            }
        }



        //print the whole University structure
        university.printFaculties();
        System.out.println("-------------------------------------------------");
        System.out.println("Count given student's mean grade");



        // count given student's mean grade
        try {
            Student karine = UniversityService.getStudentByInfo(university, "CS", "A", "Karine Gevorgyan");
            System.out.println(karine.getFullName());
            karine.printCourseGrades();
            System.out.println("Mean grade = " + karine.countMeanGrade());
            System.out.println("---------------------------------");

        } catch (NullPointerException e) {
            e.printStackTrace();
        }




        //  count mean grade in a given group, for a given subject
        System.out.println("Count mean grade in a given group, for a given subject");
        try {
            Group group = UniversityService.getGroupByInfo(university, "EC", "B");
            double grade = group.countMeanGrade("Business");
            if (grade == 0) {
                System.out.println("No such course in the group, or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in group "
                        + group.getName()
                        + " = " + grade
                );
            }
            System.out.println("---------------------------------");

        } catch (NullPointerException e) {
            e.printStackTrace();
        }




        //Count mean grade in given faculty
        System.out.println("Count mean grade in given faculty for given subject");
        try {
            Faculty faculty = UniversityService.getFacultyByName(university, "CS");
            double grade = faculty.countMeanGrade("Armenian Literature");
            if (grade == 0) {
                System.out.println("No such course in the faculty, or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in faculty "
                        + faculty.getName()
                        + " = " + grade
                );
                System.out.println("---------------------------------");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }




        //Count mean grade in university for given subject
        System.out.println("Count mean grade in the university for given subject");
        try {
            double grade = university.countMeanGrade("Data Structures");
            if (grade == 0) {
                System.out.println("No such course in the university, or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in University "
                        + " = " + university.countMeanGrade("Data Structures")
                );
            }
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}
