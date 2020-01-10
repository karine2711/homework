package exception;

import exception.exceptions.NullGroupListException;

/**
 * The faculty class represents the faculties of the university.
 * Contains lists of groups and students.
 *
 * @author Karine Gevorgyan
 */
public class Faculty {

    private String name;
    private  Group[] groups;
    private char[] groupNames;
    private Student[] studentList;
    private int studentQuantity=0;

    public Faculty(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setGroups(Group[] groups) throws NullGroupListException {
        if(groups.length==0) {
            throw new NullGroupListException();

        } else {
            this.groups = groups;
        }
    }

    public Group[] getGroups() {
        if(groups.length==0){
            throw new NullGroupListException();
        }else {
            return groups;
        }
    }

    public char[] getGroupNames() {
        groupNames=new char[groups.length];
        for (int i = 0; i < this.getGroups().length; i++) {
            groupNames[i]=groups[i].getName();
        }
        return groupNames;
    }

    public Student[] getStudentList() {
        return studentList;
    }

    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }

    public int getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(int studentQuantity) {
        this.studentQuantity = studentQuantity;
    }
}
