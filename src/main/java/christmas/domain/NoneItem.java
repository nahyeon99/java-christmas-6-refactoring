package christmas.domain;

import christmas.domain.benefit.BenefitItem;

public class NoneItem implements BenefitItem {
    private static final NoneItem INSTANCE = new NoneItem();

    @Override
    public Money getAmount() {
        return Money.ZERO;
    }

    public static NoneItem getInstance() {
        return INSTANCE;
    }
}
