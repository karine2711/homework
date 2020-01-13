package exception;

import java.util.Scanner;

/**
 * Adds default values to null objects.
 *
 * @author Karine Gevorgyan
 */
public class DefaultHandler {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] defaultCourseList = {"Armenian Literature", "History"};
    private static Student[][] defaultStudentList = {
            {new Student.StudentBuilder("Karine Gevorgyan", defaultCourseList).build(),
                    new Student.StudentBuilder("Siranush Mshetsyan", "Intro to CS", "Discrete Maths").build(),
            },
            {new Student.StudentBuilder("Vahag Mkrtchyan", defaultCourseList).build(),
                    new Student.StudentBuilder("Anahit Chaxmaxchyan", "Data structures", "Theory of Algorithms").build(),
            },
            {new Student.StudentBuilder("Vahag Mkrtchyan", defaultCourseList).build(),
                    new Student.StudentBuilder("Anahit Chaxmaxchyan", "Data structures", "Theory of Algorithms").build(),
            },
            {new Student.StudentBuilder("Lolita Bryusovna", "Business", "Agriculture").build(),
                    new Student.StudentBuilder("Torgom Rostovyan", "Intro to CS", "Theory of Algorithms").build(),
                    new Student.StudentBuilder("Karlen Yesayan", "English", "Business").build(),
            }
    };
    private static Group[][] defaultGroupList = {
            {
                    new Group("A", defaultStudentList[0]),
                    new Group("B", defaultStudentList[1]),
            },
            {
                    new Group("A", defaultStudentList[2]),
                    new Group("B", defaultStudentList[3]),
            },

    };
    private static int i = 0;
    private static int j = 0;

    public static CourseGrade[] courseListCreator() {
        CourseGrade[] courses = {};
        System.out.println("Do you want to create a course list by hand or use an example list?");
        System.out.print("1=createByHand, anything else=use example   ");
        System.out.print("Response: ");
        String response = scanner.next();
        if (response.equals("1")) {
            courses = createCourseListByHand();
        } else {

           for (String courseName: defaultCourseList){
               CourseGrade course=new CourseGrade(courseName);
               courses=DynamicArray.addElement(courses,course);
           }
        }
        return courses;
    }

    private static CourseGrade[] createCourseListByHand() {
        CourseGrade[] courses = {};
        System.out.println("Please enter '1' to stop adding courses");
        System.out.print("Course Name: ");
        String response = scanner.next();
        while (response.equals("1")) {
            System.out.println("You must enter at least one course");
            System.out.print("Course Name: ");
            response = scanner.next();
        }
        CourseGrade course=new CourseGrade(response);
        courses = DynamicArray.addElement(courses, course);
        System.out.println("Course " + response + " added! Press 1 to exit");
        System.out.print("Course Name: ");
        response = scanner.next();
        while (!response.equals("1")) {
            course=new CourseGrade(response);
            courses = DynamicArray.addElement(courses, course);
            System.out.println("Course " + response + " added! Press 1 to exit");
            System.out.print("Course Name: ");
            response = scanner.next();
        }
        return courses;
    }

    public static Student[] studentListCreator() {
        Student[] students = {};
        System.out.println("Do you want to create a student list by hand or use an example list?");
        System.out.print("1=createByHand, anything else=use example   ");
        System.out.print("Response: ");
        String response = scanner.next();
        if (response.equals("1")) {
            students = createStudentListByHand();
        } else {
            students = defaultStudentList[i];
            i++;
            if (i >= defaultStudentList.length) {
                i = 0;
            }
        }
        return students;
    }

    private static Student[] createStudentListByHand() {
        Student[] students = {};
        System.out.println("We will now create a student list together");
        String response;
        do {
            Student student = studentCreator();
            students = DynamicArray.addElement(students, student);
            System.out.println("Student " + student.getFullName() + " successfully added! Enter 1 to exit and" +
                    " anything else to continue! ");
            System.out.print("Your response: ");
            response = scanner.next();
        } while (!response.equals("1"));
        return students;
    }

    public static Student studentCreator() {
        System.out.print("Student Name: ");
        String fullName = (scanner.next());
        Student.StudentBuilder student = new Student.StudentBuilder(fullName);
        System.out.println("Now enter the courses " + fullName + " will take. Enter 1 to exit");
        System.out.print("Course Name: ");
        String order = scanner.next();
        while (order.equals("1")) {
            System.out.println("You must enter at least one course!");
            order = scanner.next();
        }
        student.course(order);
        System.out.print("Course Name: ");
        order = scanner.next();
        while (!order.equals("1")) {
            student.course(order);
            System.out.print("Course Name: ");
            order = scanner.next();
        }
        Student student1 = new Student(student);
        return student1;
    }


    public static Group[] groupListCreator() {
        Group[] groups = {};
        System.out.println("Do you want to create a group list by hand or use an example list?");
        System.out.print("1=createByHand, anything else=use example   ");
        System.out.print("Response: ");
        String response = scanner.next();
        if (response.equals("1")) {
            groups = createGroupListByHand();
        } else {
            groups = defaultGroupList[j];
            j++;
            if (j >= defaultGroupList.length) {
                j = 0;
            }
        }
        return groups;
    }

    private static Group[] createGroupListByHand() {
        Group[] groups = {};
        System.out.println("Please enter '1' to stop adding groups");
        System.out.print("Group Name: ");
        String response = scanner.next();
        while (response.equals("1")) {
            System.out.println("You must enter at least one group");
            System.out.print("Group Name: ");
            response = scanner.next();
        }
        Group group = new Group(response);
        groups = DynamicArray.addElement(groups, group);
        System.out.println("One group added! Press 1 to exit");
        System.out.print("Group Name:  ");
        response = scanner.next();
        while (!response.equals("1")) {
            group = new Group(response);
            groups = DynamicArray.addElement(groups, group);
            System.out.print("Group Name:  ");
            response = scanner.next();
        }
        return groups;
    }


    public static Faculty[] facultyListCreator() {
        Faculty[] faculties = {};
        System.out.println("Please enter '1' to stop adding faculties");
        System.out.print("Faculty Name: ");
        String response = scanner.next();
        while (response.equals("1")) {
            System.out.println("You must enter at least one faculty");
            System.out.print("Faculty Name: ");
            response = scanner.next();
        }
        Faculty faculty = new Faculty(response);
        faculties = DynamicArray.addElement(faculties, faculty);
        System.out.println("Faculty " + faculty.getName() + " added! Press 1 to exit");
        System.out.print("Faculty Name: ");
        response = scanner.next();
        while (!response.equals("1")) {
            faculty = new Faculty(response);
            faculties = DynamicArray.addElement(faculties, faculty);
            System.out.print("Faculty Name:  ");
            response = scanner.next();
        }
        return faculties;
    }

}