package mapandenam.holidays;

public class MonthOperations {

    public static void printHolidays(Month month) {
        System.out.print("Holidays of " + month.name() + ": |");

        for (int holiday : month.getHolidays()) {
            switch (holiday % 10) {
                case 1:
                    System.out.print(holiday + "ˢᵗ|");
                    break;
                case 2:
                    System.out.print(holiday + "ⁿᵈ|");
                    break;
                default: {
                    System.out.print(holiday + "ᵗʰ|");
                }
            }
        }
        System.out.println();
    }

    public static void printAllMonths(){
        System.out.println("-----The months of the year-----");
        for(Month month:Month.values()){
            System.out.println(month.name());
        }
    }


}
