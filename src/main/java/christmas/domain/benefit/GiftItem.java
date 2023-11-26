package christmas.domain.benefit;

import christmas.domain.Money;
import christmas.dto.ItemDto;
import java.util.List;

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

    @Override
    public List<ItemDto> getItems() {
        return gifts.getItems();
    }
}