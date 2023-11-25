package christmas.domain.benefit;

import christmas.domain.Money;

public class GiftItem implements BenefitItem {
    private final Gifts gifts;

    private GiftItem(Gifts gifts) {
        this.gifts = gifts;
    }

    public static GiftItem from(Gifts gifts) {
        return new GiftItem(gifts);
    }

    @Override
    public Money getAmount() {
        return gifts.getTotalAmount();
    }

    public Gifts getGifts() {
        return gifts;
    }
}