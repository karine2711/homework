package setsAndGenerics;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // testStringCustomSet();
      testCoffeeCustomSet();
    }


    public static void testStringCustomSet() {
        CustomTreeSet<String> set = new CustomTreeSet<String>();

        System.out.println("Add '1': "+set.add("1"));
        System.out.println("Add '5': "+set.add("5"));
        System.out.println("Add '3': "+set.add("3"));
        System.out.println("Add '3': "+set.add("3"));

        System.out.println("Size = "+set.getSize());
        System.out.println("Remove '5': "+set.remove("5"));
        System.out.println("Size = "+set.getSize());
        System.out.println("Contains '5': "+set.contains("5"));
    }

    public static void testCoffeeCustomSet() {
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

        System.out.println("Cappuccino added: "+coffeeSet.add(cappuccino)); //expected true
        System.out.println("Latte added: "+coffeeSet.add(latte)); //expected true

        //expected false as a cappuccino with an exactly same recipe exists in the set
        System.out.println("Cappuccino duplicate added: "+coffeeSet.add(cappuccinoCopy));

        System.out.println("New cappuccino added: "+coffeeSet.add(cappuccino2)); //expected true
        System.out.println("2nd Cappuccino removed: "+coffeeSet.remove(cappuccino2)); //expected true
        System.out.println("Cappuccino removed: "+coffeeSet.remove(cappuccino)); //expected true

        //expected false, as cappuccino was just removed
        System.out.println("Check if there is a cappchino with a given recipe in the set: "
                +coffeeSet.contains(cappuccino));

        System.out.println("Size = "+coffeeSet.getSize());
    }
}
