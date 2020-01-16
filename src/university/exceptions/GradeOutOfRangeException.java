package university.exceptions;

public class GradeOutOfRangeException extends RuntimeException {

    public GradeOutOfRangeException(double grade,int minGrade,int maxGrade){
        super(String.format("Grade Out Of Range! Grade must be in range [%s,%s] Given grade %s",minGrade,maxGrade,grade));
    }

    @Override
    public String toString() {
       return this.getMessage();
    }

}
