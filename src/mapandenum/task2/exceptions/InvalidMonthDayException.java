package mapandenum.task2.exceptions;

import mapandenum.task2.enumerations.Month;

public class InvalidMonthDayException extends RuntimeException {

    public InvalidMonthDayException() {
        super("The provided day of month is invalid");
    }

    public InvalidMonthDayException(Month month, int providedDay) {
        super(String.format("%s only has %d days. Provided day: %d", month.name(), month.getNumberOfDays(),
                providedDay));
    }

}
