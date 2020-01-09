package exception;

import exception.exceptions.NullGroupListException;

/**
 * The faculty class represents the faculties of the university.
 * Contains lists of groups and students.
 *
 * @author Karine Gevorgyan
 */
public class Faculty {

    private String name;
    private  Group[] groups;
    private char[] groupNames;


    public Faculty(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setGroups(Group[] groups) throws NullGroupListException {
        if(groups.length==0) {
            throw new NullGroupListException(this);

        } else {
            this.groups = groups;
        }
    }

    public Group[] getGroups() {
        if(groups.length==0){
            throw new NullGroupListException(this);
        }else {
            return groups;
        }
    }

    public char[] getGroupNames() {
        groupNames=new char[groups.length];
        for (int i = 0; i < this.getGroups().length; i++) {
            groupNames[i]=groups[i].getName();
        }
        return groupNames;
    }


}
