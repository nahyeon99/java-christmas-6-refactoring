package christmas.domain.benefit;

import christmas.domain.Money;
import christmas.dto.ItemDto;
import java.util.List;

public class Benefit {
    private final BenefitType benefitType;
    private final BenefitItem benefitItem;

    private Benefit(BenefitType benefitType, BenefitItem benefitItem) {
        this.benefitType = benefitType;
        this.benefitItem = benefitItem;
    }

    public static Benefit of(BenefitType benefitType, BenefitItem benefitItem) {
        return new Benefit(benefitType, benefitItem);
    }

    public Money getAmount() {
        return benefitItem.getAmount();
    }

    public boolean isGift() {
        return benefitType.equals(BenefitType.GIFT);
    }

    public List<ItemDto> getGiftItems() {
        return benefitItem.getItems();
    }
}
