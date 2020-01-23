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
            students = ensureCapacity();
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

        while ( index < size && s != students[index]) {
            index++;
        }
        if (index == size) {
            return false;
        } else {
            shiftPositions(index);
            return true;
        }
    }

    //returns the number of elements in the array
    public int size() {
        return size;
    }

    //returns the student at index, throws IndexOutOfBounds() otherwise.
    public Student get(int index) {
        if (index >= size && index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return students[index];
    }

    //extends the dynamic array to match the given capacity
    private Student[] ensureCapacity() {
        this.capacity *= 2;
        Student temp[] = new Student[capacity];

        for (int i = 0; i < capacity / 2; i++) {
            temp[i] = students[i];
        }
        return temp;
    }

    //shifts all students allocated after given index to the left by one.
    private void shiftPositions(int index) {
        for (int i = index; i < size - 1; i++) {
            students[i] = students[i + 1];
        }
        students[--size] = null;
    }

}
