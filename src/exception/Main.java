package exception;


public class Main {
    public static void main(String[] args) {

        //Create a university!
        University university = UniversityService.initializeUniversity();


        //grade all students randomly
        try {
            university.gradeAllStudentsRandomly();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        //try to get a student and set a grade

        try {
            System.out.println("Try to get a student and set some course grades");
            Student karine = UniversityService.getStudentByInfo(
                    university,
                    "CS",
                    "CS1",
                    "Karine Gevorgyan"
            );
            karine.setGrade("Armenian", 6);
            karine.setGrade("Maths", 9);
        } catch (NullPointerException ignored) {
            //because it's handled within the getStudentByInfo()
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        //print the whole University structure
        try {
            System.out.println("\n------------------------------------------\nThe whole University structure\n");
            university.printFaculties();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        // count given student's mean grade
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("Count given student's mean grade");
            Student karine = UniversityService.getStudentByInfo(university, "CS", "CS1", "Karine Gevorgyan");
            System.out.println(karine.getFullName());
            karine.printCourseGrades();
            System.out.println("Mean grade = " + karine.countMeanGrade());
        } catch (NullPointerException ignored) {
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        //  count mean grade in a given group, for a given subject
        try {
            System.out.println("------------------------------------------------------");
            System.out.println("Count mean grade in a given group, for a given subject");
            Group group = UniversityService.getGroupByInfo(university, "EC", "EC1");
            double grade = group.countMeanGrade("Music");
            if (grade == 0) {
                System.out.println("No one in the group passes the given course, or the students were not graded!");
            } else {
                System.out.println("Mean grade for given subject in group "
                        + group.getName()
                        + " = " + grade
                );
            }
        } catch (NullPointerException ignored) {
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        //  Count mean grade in given faculty
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("Count mean grade in given faculty for given subject");
            Faculty faculty = UniversityService.getFacultyByName(university, "CS");
            double grade = faculty.countMeanGrade("Machine Learning");
            if (grade == 0) {
                System.out.println("No such course in the faculty, or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in faculty "
                        + faculty.getName()
                        + " = " + grade
                );

            }
        } catch (NullPointerException ignored) {
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        // Count mean grade in university for given subject
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("Count mean grade in the university for given subject");
            double grade = university.countMeanGrade("Data Structures");
            if (grade == 0) {
                System.out.println("No such course in the university, or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in University "
                        + " = " + university.countMeanGrade("Armenian")
                );
            }
        } catch (NullPointerException ignored) {
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

}
