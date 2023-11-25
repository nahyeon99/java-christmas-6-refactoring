package christmas.domain.benefit.policy;

import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.DiscountItem;

public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private final BenefitType benefitType;
    private final Money discountAmount;

    public FixedAmountDiscountPolicy(BenefitType benefitType, Money discountAmount) {
        this.benefitType = benefitType;
        this.discountAmount = discountAmount;
    }

    @Override
    public Benefit calculateBenefit(VisitDate visitDate, Items orderItem) {
        return Benefit.of(benefitType, DiscountItem.from(discountAmount));
    }
}