package christmas.domain.benefit;

import christmas.domain.Money;
import java.util.List;

public class Gifts {
    private final List<Gift> gifts;

    private Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public static Gifts of(List<Gift> gifts) {
        return new Gifts(gifts);
    }

    public Money getTotalAmount() {
        int sum = gifts.parallelStream()
                .map(Gift::getTotalAmount)
                .mapToInt(money -> money.getAmount().intValue())
                .sum();

        return Money.wons(sum);
    }
}