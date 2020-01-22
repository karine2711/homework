package studentlists;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    //getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    //setters

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student student) {
        return this.lastName.compareTo(student.lastName);
    }
}
