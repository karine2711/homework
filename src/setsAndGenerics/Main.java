package setsAndGenerics;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomTreeSet<String> set=new CustomTreeSet<String>();
        set.add("5");
        set.add("2");
        set.add("3");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("2");
     //   System.out.println("hi");
        Iterator<String> iterator=set.iterator();
        for (String s:set
             ) {
            System.out.println(s);

        }
    }
}
