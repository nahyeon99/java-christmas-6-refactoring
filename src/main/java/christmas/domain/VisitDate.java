package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

public class VisitDate {
    private final LocalDate date;

    private VisitDate(LocalDate date) {
        this.date = date;
    }

    public static VisitDate of(Event event, int day) {
        return new VisitDate(LocalDate.of(event.getYear(), event.getMonth(), day));
    }

    public <T> boolean compare(Predicate<LocalDate> comparePredicate) {
        if (comparePredicate.test(date)) {
            return true;
        }
        return false;
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDay() {
        return date.getDayOfMonth();
    }
}