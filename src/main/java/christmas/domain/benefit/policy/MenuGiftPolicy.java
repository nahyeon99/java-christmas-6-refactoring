package christmas.domain.benefit.policy;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.GiftItem;
import christmas.domain.benefit.Gifts;

public class MenuGiftPolicy implements GiftPolicy {
    private final Gifts gifts;

    public MenuGiftPolicy(Gifts gifts) {
        this.gifts = gifts;
    }

    @Override
    public Benefit calculateBenefit(VisitDate visitDate, Items orderItem) {
        return Benefit.of(BenefitType.GIFT, GiftItem.from(gifts));
    }
}