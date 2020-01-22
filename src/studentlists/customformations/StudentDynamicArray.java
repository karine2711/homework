package studentlists.customformations;

import studentlists.Student;

/**
 * Custom implementation of a dynamic array, design to store Student elements
 */

public class StudentDynamicArray {

    private int size = 0;
    private int position = 0;
    private int capacity = 10;
    private Student[] students = new Student[capacity];

    public boolean add(Student student) {
        if (position >= capacity) {
            students = ensureCapacity(capacity * 2);
        }
        students[position] = student;
        size++;
        position++;
        return true;
    }

    public boolean remove(Student s) {

        int index = 0;

        while (s != students[index] && index < size) {
            index++;
        }
        if (index >= size) {
            return false;
        } else {
            for (int i = index; i < position; i++) {
                students[i] = students[i + 1];
            }
            students[position] = null;
            size--;
            position--;
            return true;
        }
    }

    public int size() {
        return size;
    }

    public Student get(int index) {
        if (index <= position && index >= 0 && students[index] != null) {
            return students[index];
        } else {
            return null;
        }
    }

    private Student[] ensureCapacity(int capacity) {

        Student temp[] = new Student[capacity];

        for (int i = 0; i < capacity; i++) {
            temp[i] = students[i];
        }
        return temp;
    }

}
