package mapandenum.task2.enumerations;

import mapandenum.task2.exceptions.InvalidMonthDayException;
import org.jetbrains.annotations.NotNull;

public enum Month {

    JANUARY(31, "JAN", 1, 6, 28),
    FEBRUARY(29, "FEB", 14, 23),
    MARCH(31, "MAR", 8),
    APRIL(30, "APR", 13, 24),
    MAY(31, "MAY", 1, 9, 28),
    JUNE(30, "JUN", 1),
    JULY(31, "JUL", 5),
    AUGUST(31, "AUG"),
    SEPTEMBER(30, "SEP", 1, 21),
    OCTOBER(31, "OCT", 5, 31),
    NOVEMBER(30, "NOV", 26),
    DECEMBER(31, "DEC", 24, 25, 31);

    private int numberOfHolidays = 0;
    private int numberOfDays;
    private int[] holidays = {};
    private String shortName;

    Month(int numberOfDays, @NotNull String shortName, int... holidays) {
        this.numberOfDays = numberOfDays;
        this.shortName = shortName;
        if (holidays != null) {
            numberOfHolidays = holidays.length;
            this.holidays = holidays;
        }
    }

    public int getNumberOfHolidays() {
        return numberOfHolidays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void printNumberOfDays() {
        System.out.println(this.name() + " has " + getNumberOfDays() + " days");
    }

    public int[] getHolidays() {
        return holidays;
    }

    public String getShortName() {
        return shortName;
    }


    //checks if a given day is a holiday
    public  boolean isHoliday(int day) {
        if (day < 0 || day > this.getNumberOfDays()) {
            throw new InvalidMonthDayException(this, day);
        }
        for (int holiday : this.getHolidays()) {
            if (holiday == day) {
                return true;
            }
        }
        return false;
    }
}
