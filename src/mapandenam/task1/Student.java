package mapandenam.task1;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private Faculty faculty;
    private static final int MIN_AGE=7;
    private static final int MAX_AGE=70;

    public Student(@NotNull String firstName, @NotNull String lastName,  int age,
                   @NotNull String phoneNumber, @NotNull Faculty faculty) {
        if(age<MIN_AGE || age>MAX_AGE){
            throw new IllegalArgumentException("Age must be between 7 and 70");
        }
        this.firstName=firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                phoneNumber.equals(student.phoneNumber) &&
                faculty.equals(student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, phoneNumber, faculty);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }

}
