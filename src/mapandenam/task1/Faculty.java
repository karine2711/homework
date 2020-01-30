package mapandenam.task1;

public enum Faculty {
    MATH, PHYSICS, PHILOSOPHY, ENGLISH;
    private int studentQuantity=0;

    public void incrementStudentQuantity(){
        this.studentQuantity++;
    }

    //Return the number of students in a given faculty
    public int getStudentQuantity() {
        return studentQuantity;
    }

    //Print all faculties
    public static void print(){
        for (Faculty faculty:values()) {
            System.out.println(faculty);
        }
    }

    @Override
    public String toString() {
        return "Faculty:" +this.name()+
                "  Student Quantity=" + studentQuantity;
    }


}
