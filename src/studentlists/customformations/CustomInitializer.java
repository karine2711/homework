package studentlists.customformations;

import studentlists.Student;
import studentlists.StudentService;

import java.util.ArrayList;
import java.util.List;

public class CustomInitializer {
    private static StudentDynamicArray dynamicArray=new StudentDynamicArray();

    public static StudentDynamicArray getDynamicArray() {
        return dynamicArray;
    }

    public static void initializeStudentDynamicArray() {
      List<Student> studentList=StudentService.initializeStudents();
      for(Student student:studentList){
          dynamicArray.add(student);
      }
    }


}
