package christmas.domain.benefit.condition;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Set;
import java.util.stream.Collectors;

public class SpecialDateCondition implements BenefitCondition {
    @Override
    public boolean isSatisfiedBy(VisitDate visitDate, Items orderItem) {
        return SpecialDateType.valueOf(visitDate);
    }

    private enum SpecialDateType {
        TRUE(Year.of(2023), Month.DECEMBER, Set.of(3, 10, 17, 24, 25, 31)),
        FALSE(Year.of(2023), Month.DECEMBER, Set.of());

        private final Set<LocalDate> dates;

        SpecialDateType(Year year, Month month, Set<Integer> days) {
            this.dates = days.stream()
                    .map(day -> LocalDate.of(year.getValue(), month, day))
                    .collect(Collectors.toUnmodifiableSet());
        }

        public static boolean valueOf(VisitDate visitDate) {
            return visitDate.compare((LocalDate date) -> TRUE.dates.contains(date));
        }
    }
}