package christmas.domain.benefit.condition;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import java.time.LocalDate;

public class PeriodCondition implements BenefitCondition {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public PeriodCondition(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isSatisfiedBy(VisitDate visitDate, Items orderItem) {
        boolean withinStartDate = visitDate.compare(
                (LocalDate date) -> startDate.isBefore(date) || startDate.isEqual(date));

        boolean withinEndDate = visitDate.compare(
                (LocalDate date) -> endDate.isAfter(date) || endDate.isEqual(date));

        if (withinStartDate && withinEndDate) {
            return true;
        }
        return false;
    }
}