package christmas.domain.benefit.condition;

import christmas.domain.Items;
import christmas.domain.VisitDate;

public interface BenefitCondition {
    boolean isSatisfiedBy(VisitDate visitDate, Items orderItems);
}
