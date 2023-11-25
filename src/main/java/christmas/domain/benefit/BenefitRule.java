package christmas.domain.benefit;

import christmas.domain.Items;
import christmas.domain.VisitDate;

public interface BenefitRule {
    Benefits getBenefit(VisitDate visitDate, Items orderItems);
}
