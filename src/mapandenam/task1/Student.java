package mapandenam;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private Faculty faculty;

    public Student(String firstName, String lastName, int age, String phoneNumber, Faculty faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
    }

    public String getFullName() {
        return firstName+" "+lastName;
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
