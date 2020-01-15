package exception;

/**
 * Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */

public class UniversityService {
    public static University initializeUniversity() {
        Student Karine = new Student.StudentBuilder("Karine Gevorgyan")
                .address("Tumanyan 5")
                .phone("046251378")
                .email("karine@mail.ru")
                .build();
        Student Siranush = new Student.StudentBuilder("Siranush Mshetsyan")
                .email("siranush@mail.ru")
                .build();
        Student Vahag = new Student.StudentBuilder("Vahag Mkrtchyan")
                .phone("025468579")
                .build();
        Student Anahit = new Student.StudentBuilder("Anahit Chaxmaxchyan")
                .address("Baxramyan 1")
                .build();
        Student Lolita = new Student.StudentBuilder("Lolita Bryusovna").build();
        Student Torgom = new Student.StudentBuilder("Torgom Rostovyan").build();
        Student Karlen = new Student.StudentBuilder("Karlen Yesayan").build();
        Student Ed = new Student.StudentBuilder("Ed Park ").build();
        Student Isabel = new Student.StudentBuilder("Isabel Floyd").build();
        Student Dallas = new Student.StudentBuilder("Dallas Knight").build();
        Group CS1 = new Group("CS1");
        CS1.setStudentList(Karine, Siranush);
        Group CS2 = new Group("CS2");
        CS2.setStudentList(Vahag, Anahit);
        Group EC1 = new Group("EC1");
        EC1.setStudentList(Lolita, Torgom, Karlen);
        Group EC2 = new Group("EC2");
        EC2.setStudentList(Ed, Isabel, Dallas);
        Faculty CS = new Faculty("CS");
        CS.setGroupList(CS1, CS2);
        Faculty EC = new Faculty("EC");
        EC.setGroupList(EC1, EC2);
        University AUA = new University("AUA");
        AUA.setFacultyList(CS, EC);
        return AUA;
    }

    public static Student getStudentByInfo(University university, String facultyName, String groupName,
                                           String fullName) {

        try {
            Group group = getGroupByInfo(university, facultyName, groupName);
            int index = search(group.getStudentNames(), fullName);
            if (index == -1) {
                System.out.println("There is no such student in group" + groupName + " of faculty " + facultyName);
                return null;
            }
            return group.getStudentList()[index];
        } catch (NullPointerException e) {
            System.out.println("Group is NULL");
            return null;
        }

    }

    public static Group getGroupByInfo(University university, String facultyName, String groupName) {

        try {
            Faculty faculty = getFacultyByName(university, facultyName);
            int index = search(faculty.getGroupNames(), groupName);
            if (index == -1) {
                System.out.println("There is no such group in faculty" + facultyName);
                return null;
            }
            Group group = faculty.getGroups()[index];
            return group;
        } catch (NullPointerException e) {
            System.out.println("Faculty is null!");
            return null;
        }
    }

    public static Faculty getFacultyByName(University university, String facultyName) {
        int index = search(university.getFacultyNames(), facultyName);
        if (index == -1) {
            System.out.println("There is no such faculty!");
            return null;
        }
        Faculty faculty = university.getFacultyList()[index];
        return faculty;
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
