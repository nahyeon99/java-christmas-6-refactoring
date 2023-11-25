package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String korean;
    private final Money minBenefitAmount;

    Badge(String korean, int minBenefitAmount) {
        this.korean = korean;
        this.minBenefitAmount = Money.wons(minBenefitAmount);
    }

    public static Badge valueOf(Money benefitAmount) {
        return Arrays.stream(values())
                .filter(badge -> benefitAmount.isGreaterThanOrEqual(badge.minBenefitAmount))
                .findFirst()
                .orElse(NONE);
    }
}