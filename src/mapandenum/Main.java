package mapandenam;

import mapandenam.task2.exceptions.InvalidMonthDayException;
import mapandenam.task2.enumerations.Month;
import mapandenam.task2.service.MonthOperations;
import mapandenam.task1.enumerations.Faculty;
import mapandenam.task1.model.Student;
import mapandenam.task1.service.StudentService;

import java.util.List;

public class Main {
    public static final String SEPARATOR = "----------";

    public static void main(String[] args) {
        List<Student> studentList = StudentService.initStudentList();
        task1A(studentList);
        task1B(studentList);
        task2();
    }

    public static void task1A(List<Student> studentList) {
        System.out.println("\n" + SEPARATOR + "TASK 1- A" + SEPARATOR);
        System.out.println("Count the number of occurrences for each first name and last name\n");
        System.out.println(StudentService.getStudentsMap(studentList));
    }

    public static void task1B(List<Student> studentList) {
        System.out.println("\n" + SEPARATOR + "TASK 1 - B" + SEPARATOR);
        System.out.println("Count the number of students in each faculty\n");
        StudentService.countStudentsInEachFaculty(studentList);
        Faculty.print();
        System.out.println("The number of students in Math faculty is " + Faculty.MATH.getStudentQuantity());
    }

    public static void task2() {
        System.out.println("\n" + SEPARATOR + "TASK 2" + SEPARATOR);
        System.out.println("Create an enum which will store months of the year\n");
        MonthOperations.printHolidays(Month.APRIL); //Task 2-A
        Month.MARCH.printNumberOfDays(); //Task 2-B
        MonthOperations.printAllMonths(); //Task 2-C
        MonthOperations.printCalendar(); //Task 2-C, way2

        //Task 2-D
        try {
            System.out.println(MonthOperations.isHoliday(Month.MARCH, 8));
        } catch (InvalidMonthDayException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(MonthOperations.isHoliday(Month.MARCH, 21));
        } catch (InvalidMonthDayException e) {
            System.out.println(e.getMessage());
        }

    }

}
