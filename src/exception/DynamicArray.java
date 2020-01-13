package exception;

public class DynamicArray {


    public  static Student[] addElement(Student[] students, Student student){
        int size=students.length;
        Student[] temp=incrementSize(students);

     temp[size]=student;
return temp;
    }

    public  static CourseGrade[] addElement(CourseGrade[] array, CourseGrade element){
        int size=array.length;
        CourseGrade[] temp=incrementSize(array);

        temp[size]=element;
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

    public static CourseGrade[] incrementSize(CourseGrade[] array){
        int size=array.length;
        size++;
        CourseGrade temp[] = new CourseGrade[size];
        size--;
        for (int i=0; i <size; i++){
            temp[i] = array[i];
        }
        return temp;

    }

    //not used yet
    public static Student[] removeElement(Student[] students, int index){
        int size=students.length;

        Student temp[] = new Student[size];

        for (int i=0; i <index; i++){
            temp[i] = students[i];
        }
        for (int i=++index; i <size; i++){
            temp[i] = students[i-1];
        }
        temp=removeLast(temp);
        return temp;
    }
    public static Student[] removeLast(Student[] students){
        int size=students.length;
        size--;
        Student temp[] = new Student[size];
        for (int i=0; i <size; i++){
            temp[i] = students[i];
        }
        return temp;
    }
}
