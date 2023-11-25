package christmas.domain.benefit.condition;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.DayOfWeekType;

public class WeekEndCondition implements BenefitCondition {
    @Override
    public boolean isSatisfiedBy(VisitDate visitDate, Items orderItem) {
        DayOfWeekType dayOfWeekType = DayOfWeekType.valueOf(visitDate);

        if (dayOfWeekType.equals(DayOfWeekType.WEEK_END)) {
            return true;
        }
        return false;
    }
}