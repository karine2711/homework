package setsAndGenerics.model;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private int age;
    private String firstName;
    private String lastName;


    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * 2 Students are equal if their firstName, LastName and age is the same
     *
     * @param o the student to be tested for equality with the implicit parameter
     * @return true if the students are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Student student = (Student) o;
        return this.age == student.age &&
                this.firstName.equals(student.firstName) &&
                this.lastName.equals(student.lastName);
    }

    /**
     * @return hashcode, based on firstName, lastName and age of the Student
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.age, this.firstName, this.lastName);
    }

    /**
     * Students are compared by their firstName, than lastName, than age
     *
     * @param student the student, that will be compared with the implicit parameters
     * @return negative int if this<student; postivie int, if this>student and 0 otherwise
     */
    @Override
    public int compareTo(Student student) {

        int compareByName = this.firstName.compareTo(student.firstName);
        int compareBySurName = this.lastName.compareTo(student.lastName);
        int compareByAge = this.age - student.age;
        if (compareByName != 0) {
            return compareByName;
        } else if (compareBySurName != 0) {
            return compareBySurName;
        } else {
            return compareByAge;
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +

                '}';
    }

}
