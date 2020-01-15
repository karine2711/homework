package university.exceptions;

public class GradeOutOfRangeException extends RuntimeException {
    double grade;
    int minGrade;
    int maxGrade;

    public GradeOutOfRangeException(double grade,int minGrade,int maxGrade){
        this.grade=grade;
        this.minGrade=minGrade;
        this.maxGrade=maxGrade;
    }

    @Override
    public String toString() {
        return "Grade Out Of Range! Grade must be in range (" +
               minGrade+","+maxGrade+"]      Given grade "+ grade;

    }
}
