package mapandenam;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> initStudentList() {
        List <Student> students = new ArrayList<>();

        //create some students
        Student student1 = new Student("Dianna", "Asatryan", 22,
                "098811111", "Math");
        Student student2 = new Student("Diana", "Asatryan", 32,
                "0922111111", "Physics");
        Student student3 =new Student("Diana", "Asatryan", 21,
                "0938111111", "philosophy");
        Student student4=new Student("Karen", "Balayan", 12,
                "097777777", "Math");
        Student student5=new Student("Karen","Balayan", 23,
                "098888811", "philosophy");
        Student student6=new Student("Elen", "Mirzoyan", 12,
                "093333333", "English");

        //add students to array list
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        return  students;
    }
}
