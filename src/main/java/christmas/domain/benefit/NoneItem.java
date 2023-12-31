package christmas.domain.benefit;

import christmas.domain.Money;
import christmas.dto.ItemDto;
import java.util.Collections;
import java.util.List;

public class NoneItem implements BenefitItem {
    private static final NoneItem INSTANCE = new NoneItem();

    public static NoneItem getInstance() {
        return INSTANCE;
    }

    @Override
    public Money getAmount() {
        return Money.ZERO;
    }

    @Override
    public List<ItemDto> getItems() {
        return Collections.emptyList();
    }
}