package christmas.domain;

import java.time.LocalDate;

public class VisitDate {
    private final LocalDate date;

    private VisitDate(LocalDate date) {
        this.date = date;
    }

    public static VisitDate of(Event event, int day) {
        return new VisitDate(LocalDate.of(event.getYear(), event.getMonth(), day));
    }
}