package mapandenum.task1.enumerations;

public enum Faculty {

    MATH,
    PHYSICS,
    PHILOSOPHY,
    ENGLISH;




    //Print all faculties
    public static void printAllFaculties() {
        for (Faculty faculty : values()) {
            System.out.println(faculty);
        }
    }


}
