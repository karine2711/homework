package studentlists.customformations;

import studentlists.Student;

/**
 * Custom implementation of a dynamic array, design to store Student elements
 */

public class StudentDynamicArray {

    private int size = 0;
    private int capacity = 10;
    private Student[] students = new Student[capacity];

    //appends the student to the end of the array
    public void add(Student student) {
        if (size >= capacity) {
            students = ensureCapacity(capacity * 2);
        }
        students[size] = student;
        size++;
    }

    /*
     * removes the first occurrence of the specified student from
     * the array if present. Returns true, if succeeds, and false otherwise
     */
    public boolean remove(Student s) {

        int index = 0;

        while (s != students[index] && index < size) {
            index++;
        }
        if (index >= size) {
            return false;
        } else {
            for (int i = index; i < size; i++) {
                students[i] = students[i + 1];
            }
            students[size] = null;
            size--;
            return true;
        }
    }

    //returns the number of elements in the array
    public int size() {
        return size;
    }

    //returns the student at index, and null otherwise
    public Student get(int index) {
        if (index <= size && index >= 0 && students[index] != null) {
            return students[index];
        } else {
            return null;
        }
    }

    //extends the dynamic array to match the given capacity
    private Student[] ensureCapacity(int capacity) {

        Student temp[] = new Student[capacity];

        for (int i = 0; i < capacity; i++) {
            temp[i] = students[i];
        }
        return temp;
    }

}
