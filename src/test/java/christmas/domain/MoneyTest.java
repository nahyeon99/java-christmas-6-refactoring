package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("a원과 b원을 더하면 (a+b)원이다.")
    @ParameterizedTest
    @CsvSource(value = {"1,000, 10,000", "0, 200,000"})
    void plus(int amount1, int amount2) {
        Money money = Money.wons(amount1);
        Money sum = money.plus(Money.wons(amount2));

        assertEquals(sum.getAmount(), BigDecimal.valueOf(amount1 + amount2));
    }

    @DisplayName("a원과 b원을 빼면 (a-b)원이다.")
    @ParameterizedTest
    @CsvSource(value = {"10,000, 1,000", "0, 200,000", "0, 0", "0, 1,000"})
    void subtract(int amount1, int amount2) {
        Money money = Money.wons(amount1);
        Money subtract = money.minus(Money.wons(amount2));

        assertEquals(subtract.getAmount(), BigDecimal.valueOf(amount1 - amount2));
    }

    @DisplayName("a원과 b원을 대소 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"10,000, 1,000", "300,000, 200,000", "0, 1,000", "0, 0"})
    void compare(int amount1, int amount2) {
        Money money = Money.wons(amount1);
        boolean compareFlag = money.isGreaterThanOrEqual(Money.wons(amount2));

        assertEquals(compareFlag, (amount1 >= amount2));
    }

    @DisplayName("금액을 마이너스로 변경한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 0, 100_000, -3_000})
    void compareMinus(int amount) {
        Money money = Money.wons(amount);
        BigDecimal minusAmount = money.convertMinus();

        assertEquals(minusAmount, BigDecimal.valueOf(amount * -1));
    }

    @DisplayName("같은 금액을 가진 두 객체의 동일성을 검증한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 0, -100_000_000})
    void equals(int amount) {
        Money money = Money.wons(amount);
        boolean isEquals = money.equals(Money.wons(amount));

        assertTrue(isEquals);
    }
}