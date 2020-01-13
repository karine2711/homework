package exception;

public class Main {
    public static void main(String[] args) {
        //Create a university!
        Student s = new Student.StudentBuilder("Ani", "Armenia", "English").build();
        University university = new University("AUA", new Faculty("CS"), new Faculty("EC"));
        try {
            Student karine = UniversityService.getStudentByInfo(university, "CS", "A", "Karine Gevorgyan");
            karine.setGrade("Armenian Literature", 5);
        } catch (NullPointerException e) {
            System.out.println("no such student in the University!");
        }
        for (Faculty faculty : university.getFacultyList()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudentList()) {
                    student.gradeStudentRandomly();
                }
            }
        }
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
        System.out.println("Count mean grade in a given group, for a given subject");
        //  count mean grade in a given group, for a given subject
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

        System.out.println("Count mean grade in given faculty for given subject");
        //Count mean grade in given faculty
        try {
            Faculty faculty = UniversityService.getFacultyByName(university, "CS");
            double grade = faculty.countMeanGrade("Armenian Literature");
            if (grade == 0) {
                System.out.println("No such course in the faculty, or the students where not graded!");
            }else {
                System.out.println("Mean grade for given subject in faculty "
                        + faculty.getName()
                        + " = " + grade
                );
                System.out.println("---------------------------------");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("Count mean grade in the university for given subject");
        //Count mean grade in given faculty
        try {
            double grade=university.countMeanGrade("Data Structures");
            if(grade==0){
                System.out.println("No such course in the university, or the students where not graded!");
            }else {
                System.out.println("Mean grade for given subject in University "
                        + " = " + university.countMeanGrade("Data Structures")
                );
            }
            System.out.println("---------------------");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

//    UniversityService.addStudent("EC",'B',"John Smith");
//        System.out.println(AUA.getStudentByInfo("EC",'B',"John Smith").getFullName()    );
//        System.out.println("Finished successfully!");

    }
}
