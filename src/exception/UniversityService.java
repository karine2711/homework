package exception;

import exception.exceptions.NullGroupListException;

/**
 *Contains all general functions used within the program.
 *
 * @author Karine Gevorgyan
 */
public class UniversityService {
    public static void initializeGroups(Faculty[] faculties)  {
        try {
            faculties[0].setGroups(new Group[]{
            });
        }catch (NullGroupListException e){
            try {
              DefaultHandler.setDefaultGroupList(faculties[0]);
                 }catch (NullGroupListException ex) {
                ex.printStackTrace();
            }
        }

        faculties[1].setGroups(new Group[]{
                new Group('A', new String[]{"Armenian Literature", "Art History", "English", "Creative Writing"}),
                new Group('B', new String[]{"Art History", "Creative Writing", "Work ethics", "Book analysis"})
        });
    }
}
