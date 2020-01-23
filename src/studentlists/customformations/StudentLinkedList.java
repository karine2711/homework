package studentlists.customformations;

import studentlists.Student;

import java.util.*;

/**
 * Custom implementation of a linked list, design to store Student elements
 */

public class StudentLinkedList implements Iterable<Student> {

    private Element first;
    private Element last;
    private int size = 0;

    //returns the number of students in this list.
    public int size() {
        return size;
    }

    // inserts the student at the front of the list.
    public void push(Student student) {
        if (first == null) {
            first = new Element(student, null, null);
            last = first;
        } else {
            Element temp = new Element(student, null, first);
            first.previous = temp;
            first = temp;
        }
        size++;
    }

    // removes and returns the first student of the list
    public Student pop() {
        if (first == null) {
            throw new NoSuchElementException("There is no student in this list!");
        }
        if (first.next != null) {
            first.next.previous = null;
        }
        Student student = first.student;
        first = first.next;
        size--;
        return student;
    }

    //appends the specified student to the end of the list.
    public void addLast(Student student) {
        if (first == null) {
            first = new Element(student, null, null);
            last = first;
        } else {
            Element temp = new Element(student, last, null);
            last.next = temp;
            last = temp;
        }
        size++;
    }

    //removes and returns the last student.
    public Student removeLast() {
        if (first == null) {
            throw new NoSuchElementException("There is no student in this list!");
        }
        if (last.previous != null) {
            last.previous.next = null;
        }
        Student student = last.student;
        last = last.previous;
        size--;
        return student;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentLinkedListIterator();
    }

    /*
     *stores each Student element of the linked list,
     *along with information about its previous and next elements.
     */
    private class Element {

        public Student student;
        public Element next;
        public Element previous;

        public Element(Student student, Element previous, Element next) {
            this.student = student;
            this.previous = previous;
            this.next = next;
        }

    }

    //returns a student per iteration
    private class StudentLinkedListIterator implements Iterator {

        private Element position = new Element(null, null, first);

        public boolean hasNext() {
            if (position.next != null)
                return true;
            else
                return false;
        }

        public Student next() {
            if (this.hasNext()) {
                position = position.next;
                return position.student;
            } else
                return null;
        }

    }


}
