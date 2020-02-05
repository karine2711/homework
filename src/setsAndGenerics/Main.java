package setsAndGenerics;


import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        testStringCustomSet();
        testCoffeeCustomSet();
        testStudentCustomSet();
        testGlassesSet();

    }


    private static void testStringCustomSet() {
        //create a  set
        CustomTreeSet<String> set = new CustomTreeSet<String>();

        //add some String objects
        System.out.println("Add '1': " + set.add("1"));
        System.out.println("Add '5': " + set.add("5"));
        System.out.println("Add '3': " + set.add("3"));
        System.out.println("Add '3': " + set.add("3"));

        set.printAll();

        //Test the methods
        System.out.println("Size = " + set.getSize());
        System.out.println("Remove '5': " + set.remove("5"));
        System.out.println("Size = " + set.getSize());
        System.out.println("Contains '5': " + set.contains("5"));

    }

    private static void testCoffeeCustomSet() {

        //Make cappuccion
        Coffee cappuccino = new Coffee.CoffeeMachine("Cappuccino", 350)
                .addSugar(2)
                .addMilk(50)
                .make();

        //Make cappuccino duplicate
        Coffee cappuccinoCopy = new Coffee.CoffeeMachine("Cappuccino", 350)
                .addSugar(2)
                .addMilk(50)
                .make();

        //Make latte
        Coffee latte = new Coffee.CoffeeMachine("Esspresso", 250)
                .addMilk(100)
                .addIceCream(10)
                .addSugar(1)
                .make();

        //Make another cappuccino, different from the initial one
        Coffee cappuccino2 = new Coffee.CoffeeMachine("Cappuccino", 350)
                .addSugar(5)
                .addMilk(100)
                .addCinnamon()
                .make();

        //Create a coffee set
        CustomTreeSet<Coffee> coffeeSet = new CustomTreeSet<>();

        //Add coffeees to set
        System.out.println("Cappuccino added: " + coffeeSet.add(cappuccino));
        System.out.println("Latte added: " + coffeeSet.add(latte));

        //expected false as a cappuccino with an exactly same recipe exists in the set
        System.out.println("Cappuccino duplicate added: " + coffeeSet.add(cappuccinoCopy));

        System.out.println("New cappuccino added: " + coffeeSet.add(cappuccino2));

        coffeeSet.printAll();

        System.out.println("2nd Cappuccino removed: " + coffeeSet.remove(cappuccino2));
        System.out.println("Cappuccino removed: " + coffeeSet.remove(cappuccino));

        //expected false, as cappuccino was just removed
        System.out.println("Check if there is a cappchino with a given recipe in the set: "
                + coffeeSet.contains(cappuccino));

        System.out.println("Size = " + coffeeSet.getSize());


    }


    private static void testStudentCustomSet() {
        Student karine = new Student("Karine", "Gevorgyan", 18);
        Student milena = new Student("Milena", "Xazaryan", 18);
        Student babken = new Student("Babken", "Pejpejyan", 19);

        CustomTreeSet<Student> studentSet = new CustomTreeSet<>();
        System.out.println("Add Karine: " + studentSet.add(karine));
        System.out.println("Add Milena: " + studentSet.add(milena));
        System.out.println("Add Babken: " + studentSet.add(babken));
        System.out.println("Add Milena again: " + studentSet.add(milena));
        System.out.println("Size = " + studentSet.getSize());

        studentSet.printAll();

        System.out.println("Remove Karine: " + studentSet.remove(karine));
        System.out.println("Contains Karine? " + studentSet.contains(karine));
        System.out.println("Contains Miilena? " + studentSet.contains(milena));
    }

    private static void testGlassesSet() {

        //Created some Glasses
        Glasses raybans = new Glasses("Ray-Ban", "blue", "black",
                "black", +3, +3.5);
        Glasses prada = new Glasses("Prada", "pink", "black",
                "black", 0, 0);
        Glasses tomFord = new Glasses("Tom Ford", "black", "yellow",
                "yellow", 0, 0);
        Glasses prada2 = new Glasses("Prada", "pink", "black",
                "black", 0, 0);

        CustomTreeSet<Glasses> glassesSet = new CustomTreeSet<>(); //create a set of Glasses

        //Test the methods
        System.out.println("Add Rayb-Ban: " + glassesSet.add(raybans));
        System.out.println("Add Prada: " + glassesSet.add(prada));
        System.out.println("Add Tom-Ford: " + glassesSet.add(tomFord));
        System.out.println("Add Prada duplicate: " + glassesSet.add(prada2));
        System.out.println("Size: " + glassesSet.getSize());
        System.out.println("Contains Raybans?: " + glassesSet.contains(raybans));
        System.out.println("Remove Raybans: " + glassesSet.remove(raybans));
        System.out.println("Contains Raybans?: " + glassesSet.contains(raybans));
    }
}
