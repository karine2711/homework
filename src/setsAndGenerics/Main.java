package setsAndGenerics;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomTreeSet<String> set=new CustomTreeSet<String>();

        System.out.println(set.add("1"));
        System.out.println( set.add("5"));
        System.out.println( set.add("3"));

        System.out.println( set.add("3"));
        System.out.println( set.add("5"));
        System.out.println( set.add("3"));
        System.out.println(set.getSize());
    }
}
