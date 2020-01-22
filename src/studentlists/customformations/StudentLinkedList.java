package studentlists.customformations;

import studentlists.Student;

import java.util.*;

public class StudentLinkedList implements Iterable<Student> {

    Element current;
    Element first;
    Element last;

    @Override
    public Iterator<Student> iterator() {
        return new StudentLinkedListIterator();
    }

    public void push(Student student) {
        if (first == null) {
            first = new Element(student, null, null);
            last = first;
            current = first;
        } else {
            Element nf = new Element(student, null, first);
            first.previous = nf;
            first=nf;
        }
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
        return student;
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
        private Element position=new Element(null,null,first);

        public boolean hasNext() {
            if (position.next != null)
                return true;
            else
                return false;
        }

        public Student next() {
            if (this.hasNext()) {
                position=position.next;
                return position.student;
            } else
                return null;
        }

    }

}
