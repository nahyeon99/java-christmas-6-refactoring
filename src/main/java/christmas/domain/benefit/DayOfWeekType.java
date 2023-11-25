package christmas.domain.benefit;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.domain.VisitDate;
import java.time.DayOfWeek;
import java.util.Set;

public enum DayOfWeekType {
    WEEK_DAY(Set.of(FRIDAY, SATURDAY)),
    WEEK_END(Set.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY));

    private final Set<DayOfWeek> dayOfWeeks;

    DayOfWeekType(Set<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    public static DayOfWeekType valueOf(final VisitDate visitDate) {
        if (WEEK_END.dayOfWeeks.contains(visitDate.getDayOfWeek())) {
            return WEEK_END;
        }
        return WEEK_END;
    }
}