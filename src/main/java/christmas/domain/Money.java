package christmas.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = Money.wons(0);
    public static final Money MINUS_ONE = Money.wons(-1);

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money other) {
        return new Money(amount.add(other.amount));
    }

    public Money minus(Money other) {
        return new Money(amount.subtract(other.amount));
    }

    public Money multiply(int count) {
        return new Money(amount.multiply(BigDecimal.valueOf(count)));
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public BigDecimal convertMinus() {
        return amount.multiply(MINUS_ONE.amount);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Money)) {
            return false;
        }
        Money that = (Money) other;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}