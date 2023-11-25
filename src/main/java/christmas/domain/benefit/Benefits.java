package christmas.domain.benefit;

import christmas.domain.Money;
import christmas.domain.NoneItem;
import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;
    private static final Benefits NONE;

    static {
        List<Benefit> benefits = List.of(Benefit.of(BenefitType.NONE, NoneItem.getInstance()));
        NONE = new Benefits(benefits);
    }

    private Benefits(final List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public static Benefits of(final List<Benefit> benefits) {
        return new Benefits(benefits);
    }

    public Money getTotalAmount() {
        int sum = benefits.parallelStream()
                .map(benefit -> benefit.getAmount())
                .mapToInt(money -> money.getAmount().intValue())
                .sum();

        return Money.wons(sum);
    }

    public static Benefits getNone() {
        return NONE;
    }
}