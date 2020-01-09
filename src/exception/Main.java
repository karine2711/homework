package exception;

import exception.exceptions.NullFacultyListException;

public class Main {
    public static void main(String[] args) {


        University AUA = University.getUniversity();
        Faculty[] faculties = AUA.getFacultyList();
        System.out.println(faculties[0].getName());

        System.out.println("Finished successfully!");

    }
}
