package university;

import university.exceptions.missingItemExceptions.FacultyNotFoundException;
import university.exceptions.missingItemExceptions.GroupNotFoundException;
import university.exceptions.missingItemExceptions.StudentNotFoundException;
import university.universityParts.*;

/**
 * Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */

public class UniversityService {

    public static University initializeUniversity() {
        //General Courses
        Course physicalEducation = new Course("Physical Education");
        Course armenian = new Course("Armenian");
        Course civilDefense = new Course("Civil Defense");
        Course firstAid = new Course("First Aid");
        Course freshmanSeminar = new Course("Freshman Seminar");

        //Some CS Courses
        Course maths = new Course("Maths");
        Course informatics = new Course("Informatics");
        Course dataStructures = new Course("Data Structures");
        Course robotics = new Course("Robotics");
        Course machineLearning = new Course("Machine Learning");
        Course artificialIntelligence = new Course("Artificial Intelligence");

        //Some EC Courses
        Course history = new Course("History");
        Course literature = new Course("Literature");
        Course music = new Course("Music");
        Course english = new Course("English");
        Course communication = new Course("Communication");
        Course creativeWriting = new Course("Creative Writing");

        //Create some students
        Student karine = new Student.StudentBuilder("Karine Gevorgyan")
                .address("Tumanyan 5")
                .phone("046251378")
                .email("karine@mail.ru")
                .build();
        Student siranush = new Student.StudentBuilder("Siranush Mshetsyan")
                .email("siranush@mail.ru")
                .build();
        Student vahag = new Student.StudentBuilder("Vahag Mkrtchyan")
                .phone("025468579")
                .build();
        Student anahit = new Student.StudentBuilder("Anahit Chaxmaxchyan")
                .address("Baxramyan 1")
                .build();
        Student lolita = new Student.StudentBuilder("Lolita Bryusovna").build();
        Student torgom = new Student.StudentBuilder("Torgom Rostovyan").build();
        Student karlen = new Student.StudentBuilder("Karlen Yesayan").build();
        Student ed = new Student.StudentBuilder("Ed Park ").build();
        Student isabel = new Student.StudentBuilder("Isabel Floyd").build();
        Student dallas = new Student.StudentBuilder("Dallas Knight").build();

        //set courses for students
        //CS students
        karine.setCourses(artificialIntelligence, maths, physicalEducation, armenian);
        siranush.setCourses(informatics, dataStructures, civilDefense, armenian, freshmanSeminar);
        vahag.setCourses(dataStructures, robotics, machineLearning, firstAid, civilDefense);
        anahit.setCourses(informatics, machineLearning, maths, robotics, freshmanSeminar, firstAid);
        //EC students
        lolita.setCourses(physicalEducation, firstAid, history, literature, english);
        torgom.setCourses(freshmanSeminar, music, literature, communication);
        karlen.setCourses(civilDefense, history, music, communication, english);
        ed.setCourses(armenian, civilDefense, english, creativeWriting);
        isabel.setCourses(freshmanSeminar, physicalEducation, literature, creativeWriting);
        dallas.setCourses(armenian, firstAid, english);


        //Create Groups
        Group CS1 = new Group("CS1");
        CS1.setStudents(karine, siranush);

        Group CS2 = new Group("CS2");
        CS2.setStudents(vahag, anahit);

        Group EC1 = new Group("EC1");
        EC1.setStudents(lolita, torgom, karlen);

        Group EC2 = new Group("EC2");
        EC2.setStudents(ed, isabel, dallas);

        //Create Faculties
        Faculty CS = new Faculty("CS");
        CS.setGroups(CS1, CS2);

        Faculty EC = new Faculty("EC");
        EC.setGroups(EC1, EC2);

        //Create University and return
        University AUA = new University("AUA");
        AUA.setFaculties(CS, EC);
        return AUA;
    }

    public static Student getStudentByInfo(University university, String facultyName, String groupName,
                                           String fullName) {

            Group group = getGroupByInfo(university, facultyName, groupName);
            int index = search(group.getStudentNames(), fullName);
            if (index == -1) {
                throw new StudentNotFoundException(fullName,groupName,facultyName);
            }
            return group.getStudents()[index];

    }

    public static Group getGroupByInfo(University university, String facultyName, String groupName) {

            Faculty faculty = getFacultyByName(university, facultyName);
            int index = search(faculty.getGroupNames(), groupName);
            if (index == -1) {
               throw new GroupNotFoundException(groupName,facultyName);
            }
            return faculty.getGroups()[index];

    }

    public static Faculty getFacultyByName(University university, String facultyName) {

        int index = search(university.getFacultyNames(), facultyName);
        if (index == -1) {
           throw new FacultyNotFoundException(facultyName);
        }
        return university.getFaculties()[index];

    }

    public static int search(String arr[], String x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(x))
                return i;
        }
        return -1;
    }

    public static int search(Course courses[], String courseName) {
        int n = courses.length;
        for (int i = 0; i < n; i++) {
            if (courses[i].getCourseName().equals(courseName))
                return i;
        }
        return -1;
    }

}
