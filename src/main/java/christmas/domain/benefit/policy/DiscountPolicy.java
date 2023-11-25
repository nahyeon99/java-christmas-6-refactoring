package christmas.domain.benefit.policy;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefit;

public interface DiscountPolicy extends BenefitPolicy {
    Benefit calculateBenefit(VisitDate visitDate, Items orderItems);
}
