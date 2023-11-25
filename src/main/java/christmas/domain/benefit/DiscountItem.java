package christmas.domain.benefit;

import christmas.domain.Money;

public class DiscountItem implements BenefitItem {
    private final Money discountAmount;

    private DiscountItem(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static DiscountItem from(Money discountAmount) {
        return new DiscountItem(discountAmount);
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public Money getAmount() {
        return discountAmount;
    }
}
