package exception;

import java.util.Scanner;

/**
 * Adds default values to null objects.
 *
 * @author Karine Gevorgyan
 */
public class DefaultHandler {
    static Scanner scanner = new Scanner(System.in);

    public static Student[] studentListCreator(String groupName) {
        Student[] students = {};
        System.out.println("We will now create a student list together");
        String response;
        do{
            Student student = studentCreator(groupName);
            students = DynamicArray.addElement(students, student);
            System.out.println("Student " + student.getFullName() + " successfully added! Enter 1 to exit and" +
                    " anything else to continue! ");
            System.out.print("Your response: ");
            response = scanner.next();
        }    while (!response.equals("1"));
        return students;
    }

    public static Student studentCreator(String groupName) {
        System.out.print("Student Name: ");
        String fullName = (scanner.next());
        Student.StudentBuilder student = new Student.StudentBuilder(fullName, groupName);
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
        System.out.println("Faculty "+faculty.getName()+" added! Press 1 to exit");
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