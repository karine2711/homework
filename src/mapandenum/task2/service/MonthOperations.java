package mapandenum.task2.service;

import mapandenum.task2.enumerations.Month;
import mapandenum.task2.exceptions.InvalidMonthDayException;

public class MonthOperations {

    //print all days of the month that are holidays
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

    //prints all months of the year on separate lines
    public static void printAllMonths() {
        System.out.println("-----The months of the year-----");
        for (Month month : Month.values()) {
            System.out.println(month.name());
        }
    }

}