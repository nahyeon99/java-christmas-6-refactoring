package christmas.dto;

import christmas.domain.Money;
import christmas.domain.benefit.BenefitType;
import java.math.BigDecimal;

public record BenefitDto(String benefitType, BigDecimal benefitAmount) {
    public static BenefitDto minusAmountOf(BenefitType benefitType, Money benefitAmount) {
        return new BenefitDto(benefitType.getKorean(), benefitAmount.convertMinus());
    }
}