package exception;

public class Main {
    public static void main(String[] args) {
        University AUA=University.getUniversity();
        Faculty[] faculties= AUA.getFacultyList();
        System.out.println(faculties[0].getName()+"  "+ faculties[1].getName());

    }
}
