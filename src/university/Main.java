package university;


import university.exceptions.GradeOutOfRangeException;
import university.exceptions.itemNotFoundExceptions.ItemNotFoundException;
import university.exceptions.nullListExceptions.NullListException;
import university.universityParts.Faculty;
import university.universityParts.Group;
import university.universityParts.Student;
import university.universityParts.University;

public class Main {
    public static void main(String[] args) {

        //Create a university!
        University university = UniversityService.initializeUniversity();

        //grade all students randomly
        try {
            university.gradeAllStudentsRandomly();
        } catch (NullListException e) {
            e.printStackTrace();
        }

        setSomeGrades(university);      //try to get a student and set a grade

        printUniversityStructure(university);         //print the whole University structure

        // print given student's mean grade
        printStudentsMeanGrade(university, "CS", "CS1", "Karine Gevorgyan");

        //  print mean grade in a given group, for a given subject
        printGroupMeanGradeForSubject(university, "EC", "EC1", "Music");

        //  print mean grade in given faculty
        printFacultyMeanGradeForSubject(university, "CS", "Machine Learning");

        // Count mean grade in university for given subject
        printUniversityMeanGradeForSubject(university, "Armenian");

    }

    private static void setSomeGrades(University university) {
        try {
            Student karine = UniversityService.getStudentByInfo(
                    university,
                    "CS",
                    "CS1",
                    "Karine Gevorgyan"
            );
            try {
                karine.setGrade("Armenian", 10);
            } catch (GradeOutOfRangeException e) {
                e.printStackTrace();
            }
            try {
                karine.setGrade("Maths", 5);
            } catch (GradeOutOfRangeException e) {
                e.printStackTrace();
            }

        } catch (ItemNotFoundException e) {
            System.out.println();
            System.out.println(e.toString());
        } catch (NullListException e) {
            e.printStackTrace();
        }
    }

    private static void printUniversityStructure(University university) {
        try {
            System.out.println("\n-----------------------------------------------");
            System.out.println("The whole structure of" + university.getName() + " university!\n");
            university.printFaculties();
        } catch (NullListException e) {
            e.printStackTrace();
        }
    }

    private static void printStudentsMeanGrade(University university, String facultyName, String groupName,
                                               String fullName) {
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("--Count given student's mean grade--");
            Student karine = UniversityService.getStudentByInfo(university, facultyName, groupName, fullName);
            System.out.println(fullName + "'s grades");
            karine.printCourseGrades();
            System.out.println(fullName + "'s mean grade = " + karine.countMeanGrade());
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullListException e) {
            e.printStackTrace();
        }
    }

    private static void printGroupMeanGradeForSubject(University university, String facultyName, String groupName,
                                                      String courseName) {
        try {
            System.out.println("------------------------------------------------------");
            System.out.println("--Count mean grade in a given group, for a given subject--");
            Group group = UniversityService.getGroupByInfo(university, facultyName, groupName);
            double grade = group.countMeanGrade(courseName);
            if (grade == 0) {
                System.out.println("No one in group " + groupName + " passes " + courseName +
                        "or the students were not graded!");
            } else {
                System.out.println("Mean grade for" + courseName + " in group "
                        + groupName
                        + " = " + grade
                );
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullListException e) {
            e.printStackTrace();
        }
    }

    private static void printFacultyMeanGradeForSubject(University university, String facultyName,
                                                        String courseName) {
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("--Count mean grade in given faculty for given subject--");
            Faculty faculty = UniversityService.getFacultyByName(university, facultyName);
            double grade = faculty.countMeanGrade(courseName);
            if (grade == 0) {
                System.out.println("There is no course called " + courseName + " passed in faculty" +
                        facultyName + ", or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in faculty "
                        + facultyName
                        + " = " + grade
                );

            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullListException e) {
            e.printStackTrace();
        }
    }

    private static void printUniversityMeanGradeForSubject(University university, String courseName) {
        try {
            System.out.println("----------------------------------------------------");
            System.out.println("--Count mean grade in the university for given subject--");
            double grade = university.countMeanGrade(courseName);
            if (grade == 0) {
                System.out.println("No course called" + courseName + " is passed in university, " +
                        university.getName() + "or the students where not graded!");
            } else {
                System.out.println("Mean grade for given subject in University "
                        + " = " + grade
                );
            }
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullListException e) {
            e.printStackTrace();
        }
    }

}
