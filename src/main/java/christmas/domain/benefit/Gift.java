package christmas.domain.benefit;

import christmas.domain.Items;
import christmas.domain.Money;
import christmas.dto.ItemDto;
import java.util.List;

public class Gift {
    private final Items items;

    private Gift(Items items) {
        this.items = items;
    }

    public static Gift of(Items items) {
        return new Gift(items);
    }

    public Money getTotalAmount() {
        return items.getTotalAmountNotDiscounted();
    }

    public List<ItemDto> getItems() {
        return items.getItems();
    }
}