package studentlists.customformations;

import studentlists.Student;

import java.util.*;

public class StudentLinkedList implements Iterable<Student> {


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
        } else {
            Element temp = new Element(student, null, first);
            first.previous = temp;
            first=temp;
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

    public void addLast(Student student){
        if (first == null) {
            first = new Element(student, null, null);
            last = first;
        } else {
            Element temp = new Element(student, last, null);
            last.next = temp;
            last=temp;
        }
    }

    public Student removeLast(){
        if (first == null) {
            return null;
        }
        if(last.previous!=null){
        last.previous.next = null;
        }
        Student student = last.student;
        last = last.previous;
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
