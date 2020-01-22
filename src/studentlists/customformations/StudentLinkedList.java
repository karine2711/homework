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

    public int size() {
        return size;
    }

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

    public Student pop() {
        if (first == null) {
            return null;
        }
        if (first.next != null) {
            first.next.previous = null;
        }
        Student student = first.student;
        first = first.next;
        size--;
        return student;
    }

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

    public Student removeLast() {
        if (first == null) {
            return null;
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
