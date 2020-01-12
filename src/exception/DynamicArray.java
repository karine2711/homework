package exception;

public class DynamicArray {


    public  static Student[] addElement(Student[] students, Student student){
        int size=students.length;
        Student[] temp=incrementSize(students);

     temp[size]=student;
return temp;
    }

    public static Student[] incrementSize(Student[] students){
        int size=students.length;
        size++;
        Student temp[] = new Student[size];
        size--;
        for (int i=0; i <size; i++){
            temp[i] = students[i];
        }
       return temp;

    }
}
