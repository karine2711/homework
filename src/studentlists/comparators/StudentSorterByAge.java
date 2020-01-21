package studentlists.comparators;

import studentlists.Student;

import java.util.Comparator;

/**
 * Provides a comparator for sorting a Student list
 * in an ascending order
 * when compared by their ages
 *
 */

public class StudentSorterByAge implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }

}
