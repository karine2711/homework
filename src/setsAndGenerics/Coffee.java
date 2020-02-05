package setsAndGenerics;


import java.util.Objects;

public class Coffee implements Comparable<Coffee> {
    private String name;
    private int mililitres;
    private int spoonsOfSugar;
    private int mililitresOfMilk;
    private boolean withCinnamon;
    private int gramsOfIceCream;

    private Coffee(CoffeeMachine coffee) {
        this.name = coffee.name;
        this.mililitres = coffee.mililitres;
        this.spoonsOfSugar = coffee.spoonsOfSugar;
        this.mililitresOfMilk = coffee.mililitresOfMilk;
        this.withCinnamon = coffee.withCinnamon;
        this.gramsOfIceCream = coffee.gramsOfIceCream;
    }

    @Override
    public int compareTo(Coffee coffee) {
        return this.hashCode() - coffee.hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Coffee coffee = (Coffee) o;
        return this.spoonsOfSugar == coffee.spoonsOfSugar &&
                this.mililitresOfMilk == coffee.mililitresOfMilk &&
                this.withCinnamon == coffee.withCinnamon &&
                this.gramsOfIceCream == coffee.gramsOfIceCream &&
                this.name.equals(coffee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.spoonsOfSugar, this.mililitresOfMilk, this.withCinnamon, this.gramsOfIceCream);
    }

    static class CoffeeMachine {
        private String name;
        private int mililitres;
        private int spoonsOfSugar;
        private int mililitresOfMilk;
        private boolean withCinnamon;
        private int gramsOfIceCream;


        public CoffeeMachine(String name, int mililitres) {
            this.name = name;
            this.mililitres = mililitres;
        }

        public CoffeeMachine addSugar(int spoonsOfSugar) {
            this.spoonsOfSugar = spoonsOfSugar;
            return this;
        }

        public CoffeeMachine addMilk(int mililitresOfMilk) {
            this.mililitresOfMilk = mililitresOfMilk;
            return this;
        }

        public CoffeeMachine addCinnamon() {
            this.withCinnamon = true;
            return this;
        }

        public CoffeeMachine addIceCream(int gramsOfIceCream) {
            this.gramsOfIceCream = gramsOfIceCream;
            return this;
        }

        public Coffee make() {
            Coffee coffee = new Coffee(this);
            return coffee;
        }
    }

}
