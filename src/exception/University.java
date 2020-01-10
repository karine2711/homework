package exception;

import exception.exceptions.*;

/**
 * University is a singletone class, as the program is written for a specific university.
 * It contains the list of faculties and the list of students in the university, as well
 * some methods to work with those lists.
 *
 * @author Karine Gevorgyan
 */
public class University {

    private static final University UNIVERSITY;
    static {
        University UNIVERSITY1;
        try {
           UNIVERSITY1=new University(new Faculty[]{new Faculty("CS"), new Faculty("EC")});

        } catch (NullFacultyListException e) {
            try {
                UNIVERSITY1 = new University(new Faculty[]{new Faculty("Default")});
            } catch (NullFacultyListException ex) {
                ex.printStackTrace();
                UNIVERSITY1 = null;
            }

        }
        UNIVERSITY = UNIVERSITY1;
    }

    private Faculty[] facultyList;
    private Student[] studentList;
    private String[] facultyNames;

    private University(Faculty[] faculties) throws NullFacultyListException {
        if (faculties.length == 0) {

            throw new NullFacultyListException();

        } else {
            facultyList = faculties;
        }
    }

    public static University getUniversity(String... faculties) {
        return UNIVERSITY;
    }

    public Faculty[] getFacultyList() {
        return facultyList;
    }

    public String[] getFacultyNames(){
        facultyNames=new String[facultyList.length];
        for (int i = 0; i <facultyList.length ; i++) {
            facultyNames[i]=facultyList[i].getName();
        }
        return facultyNames;
    }

    public void setStudentList(Student[] studentList) throws NullStudentListException {
        if(studentList.length==0){
            throw new NullStudentListException();
        } else {
            this.studentList = studentList;
        }
    }

    public Student[] getStudentList() throws NullStudentListException {
        if(studentList==null){
            throw new NullStudentListException();
        } else {
            return studentList;
        }
    }


    public Student getStudentByInfo(String facultyName, char groupName, String fullName){

        try{
            Group group=getGroupByInfo(facultyName,groupName);
            int   index=UniversityService.search(group.getStudentNames(),fullName);
            if(index==-1){
                System.out.println("There is no such student in group"+groupName+" of faculty "+facultyName);
                return null;
            }
            return group.getStudentList()[index];
        }catch (NullPointerException e){
            System.out.println("Group is NULL");
            return null;
        }

    }

    public Group getGroupByInfo(String facultyName, char groupName){

        try{
            Faculty faculty=getfacultyByName(facultyName);
            int index=UniversityService.search(faculty.getGroupNames(),groupName);
            if(index==-1){
                System.out.println("There is no such group in faculty"+facultyName);
                return null;
            }
            Group group=faculty.getGroups()[index];

            return  group;
        } catch (NullPointerException e){
            System.out.println("Faculty is null!");
            return null;
        }
    }

    public Faculty getfacultyByName(String facultyName){
        int index=UniversityService.search(UNIVERSITY.getFacultyNames(),facultyName);
        if(index==-1){
            System.out.println("There is no such faculty!");
            return null;
        }
        Faculty faculty=UNIVERSITY.facultyList[index];

        return faculty;

    }
}
