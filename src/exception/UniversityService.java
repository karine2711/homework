package exception;
/**
 *Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */
public class UniversityService {
    public static void initializeGroups(Faculty[] faculties) {
        faculties[0].setGroups(new Group[]{
                new Group('A', new String[]{"Introduction to CS", "Data Structures", "Discrete Maths"}),
                new Group('B', new String[]{"Data Structures", "Discrete Maths", "Calculus", "Armenian Literature"})
        });
        faculties[1].setGroups(new Group[]{
                new Group('A', new String[]{"Armenian Literature", "Art History", "English", "Creative Writing"}),
                new Group('B', new String[]{"Art History", "Creative Writing", "Work ethics", "Book analysis"})
        });
    }
}
