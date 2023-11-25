package christmas.domain.benefit;

import christmas.domain.Items;
import christmas.domain.Money;

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
}