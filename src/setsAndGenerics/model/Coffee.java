package setsAndGenerics.model;

import java.util.Objects;

/**
 * An OOP representation of coffee. This class is based on builder design pattern
 * as everyone prefers coffee with a different recipe, and you can force almost nothing.
 * The builder of this class is, intuitively, the CoffeeMachine inner static class.
 * The class implement the Comparable interface, to make it eligible for adding to a CustomTreeSet
 */
public class Coffee implements Comparable<Coffee> {
    private String name;        //the name of the coffee
    private int mililitres;     //the volume of coffee made
    private int spoonsOfSugar;      //size of sugar added, measured by spoons
    private int mililitresOfMilk;       //volume of milk, added in the coffee
    private boolean withCinnamon;   //states, if the coffee contains cinnamon
    private int gramsOfIceCream;    //the volume of ice-cream present in coffee, measured in gramms


    /**
     * Receives a CoffeeMachine object and initializes all Coffee fields, based on the
     * information present in this object
     *
     * @param coffee a CoffeeMachine type object, which provides the 'recipe' of the coffee
     */
    private Coffee(CoffeeMachine coffee) {

        this.name = coffee.name;
        this.mililitres = coffee.mililitres;
        this.spoonsOfSugar = coffee.spoonsOfSugar;
        this.mililitresOfMilk = coffee.mililitresOfMilk;
        this.withCinnamon = coffee.withCinnamon;
        this.gramsOfIceCream = coffee.gramsOfIceCream;

    }

    /**
     * Coffee objects are firtly compared by their names, than volumes, than sweetness,
     * than volumeOfMilk, than volume of Ice-Cream, than presense to cinnamon
     *
     * @param coffee the Coffee object, with which  'this' is going to be compared
     * @return returns negative int if this<coffee, positive int, if this>coffee and 0, if they
     * are equal
     */
    @Override
    public int compareTo(Coffee coffee) {

        int compareByName = this.name.compareTo(coffee.name);
        int compareByMililitres = this.mililitres - coffee.mililitres;
        int compareBySweetness = this.spoonsOfSugar - coffee.spoonsOfSugar;
        int compareByMilk = this.mililitresOfMilk - coffee.mililitresOfMilk;
        int compareByIceCream = this.gramsOfIceCream - coffee.gramsOfIceCream;

        if (compareByName != 0) {
            return compareByName;
        } else if (compareByMililitres != 0) {
            return compareByMililitres;
        } else if (compareBySweetness != 0) {
            return compareBySweetness;
        } else if (compareByMilk != 0) {
            return compareByMilk;
        } else if (compareByIceCream != 0) {
            return compareByIceCream;
        } else {
            if (withCinnamon) {
                return 1;
            } else {
                return -1;
            }
        }

    }

    /**
     * 2 coffees are considered equal if all their fields are the same, besides 'mililitres'.
     * The 'mililitres' field is allowed to vary.
     *
     * @param o the object, to which 'this' is compared
     * @return return true if the implicit and explicit parameters are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Coffee coffee = (Coffee) o;
        return this.spoonsOfSugar == coffee.spoonsOfSugar &&
                this.mililitresOfMilk == coffee.mililitresOfMilk &&
                this.withCinnamon == coffee.withCinnamon &&
                this.gramsOfIceCream == coffee.gramsOfIceCream &&
                this.name.equals(coffee.name);

    }

    /**
     * @return hashcoode, calculated based on all fields, besides mililitres.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.spoonsOfSugar, this.mililitresOfMilk, this.withCinnamon, this.gramsOfIceCream);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", mililitres=" + mililitres +
                ", spoonsOfSugar=" + spoonsOfSugar +
                ", mililitresOfMilk=" + mililitresOfMilk +
                ", withCinnamon=" + withCinnamon +
                ", gramsOfIceCream=" + gramsOfIceCream +
                '}';
    }

    /**
     * Bears the responsibility of 'making coffee'.
     * The fields in this class are exactly the same as those in 'Coffee' class
     */
    public static class CoffeeMachine {

        private String name;
        private int mililitres;
        private int spoonsOfSugar;
        private int mililitresOfMilk;
        private boolean withCinnamon;
        private int gramsOfIceCream;

        //Make some amount('mililitres') coffee named 'name'.
        public CoffeeMachine(String name, int mililitres) {
            this.name = name;
            this.mililitres = mililitres;
        }

        //Add some sugar
        public CoffeeMachine addSugar(int spoonsOfSugar) {
            this.spoonsOfSugar = spoonsOfSugar;
            return this;
        }

        //Add some milk
        public CoffeeMachine addMilk(int mililitresOfMilk) {
            this.mililitresOfMilk = mililitresOfMilk;
            return this;
        }

        //Add cinnamon
        public CoffeeMachine addCinnamon() {
            this.withCinnamon = true;
            return this;
        }

        //Add some ice-cream
        public CoffeeMachine addIceCream(int gramsOfIceCream) {
            this.gramsOfIceCream = gramsOfIceCream;
            return this;
        }

        //Pass the CoffeeMachine object to the Coffee() constructor and actually make coffee.
        public Coffee make() {
            Coffee coffee = new Coffee(this);
            return coffee;
        }

    }

}
