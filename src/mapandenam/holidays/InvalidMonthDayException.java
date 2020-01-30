package mapandenam.holidays;

public class InvalidMonthDayException extends RuntimeException {

    public InvalidMonthDayException() {
        super("The provided day of month is invalid");
    }

    public InvalidMonthDayException(Month month, int providedDay) {
       super(String.format("%s only has %d days. Provided day: %d",month.name(),month.getNumberOfDays(),
               providedDay));
    }

}
