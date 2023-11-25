package christmas.domain.benefit.condition;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.DayOfWeekType;

public class WeekDayCondition implements BenefitCondition {
    @Override
    public boolean isSatisfiedBy(VisitDate visitDate, Items orderItem) {
        DayOfWeekType dayOfWeekType = DayOfWeekType.valueOf(visitDate);

        if (dayOfWeekType.equals(DayOfWeekType.WEEK_DAY)) {
            return true;
        }
        return false;
    }
}