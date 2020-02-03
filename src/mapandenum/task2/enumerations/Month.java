package mapandenum.task2.enumerations;

import mapandenum.task2.exceptions.InvalidMonthDayException;

public enum Month {

    JANUARY(31,  1, 6, 28),
    FEBRUARY(29,  14, 23),
    MARCH(31,  8),
    APRIL(30,  13, 24),
    MAY(31,  1, 9, 28),
    JUNE(30, 1),
    JULY(31,  5),
    AUGUST(31),
    SEPTEMBER(30, 1, 21),
    OCTOBER(31,  5, 31),
    NOVEMBER(30,  26),
    DECEMBER(31,  24, 25, 31);

    private int numberOfHolidays = 0;
    private int numberOfDays;
    private int[] holidays = {};

    Month(int numberOfDays, int... holidays) {
        this.numberOfDays = numberOfDays;
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