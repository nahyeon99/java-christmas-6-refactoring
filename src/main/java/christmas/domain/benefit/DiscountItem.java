package christmas.domain.benefit;

import christmas.domain.Money;
import christmas.dto.ItemDto;
import java.util.Collections;
import java.util.List;

public class DiscountItem implements BenefitItem {
    private final Money discountAmount;

    private DiscountItem(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static DiscountItem from(Money discountAmount) {
        return new DiscountItem(discountAmount);
    }

    @Override
    public Money getAmount() {
        return discountAmount;
    }

    @Override
    public List<ItemDto> getItems() {
        return Collections.emptyList();
    }
}
