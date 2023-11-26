package christmas.dto;

import christmas.domain.Money;
import java.math.BigDecimal;

public record MoneyDto(BigDecimal amount) {
    private MoneyDto(Money money) {
        this(money.getAmount());
    }

    public static MoneyDto from(Money money) {
        return new MoneyDto(money);
    }

    public static MoneyDto minusFrom(Money money) {
        return new MoneyDto(money.convertMinus());
    }
}