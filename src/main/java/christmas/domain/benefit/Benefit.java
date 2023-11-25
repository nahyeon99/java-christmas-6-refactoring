package christmas.domain.benefit;

public class Benefit {
    private final BenefitType benefitType;
    private final BenefitItem benefitItem;

    private Benefit(BenefitType benefitType, BenefitItem benefitItem) {
        this.benefitType = benefitType;
        this.benefitItem = benefitItem;
    }

    public static Benefit of(BenefitType benefitType, BenefitItem benefitItem) {
        return new Benefit(benefitType, benefitItem);
    }
}
