package christmas.domain.benefit.policy;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefit;

public interface GiftPolicy extends BenefitPolicy {
    @Override
    Benefit calculateBenefit(VisitDate visitDate, Items orderItems);
}
