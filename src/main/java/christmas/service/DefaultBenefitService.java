package christmas.service;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.BenefitRule;
import christmas.domain.benefit.Benefits;

public class DefaultBenefitService implements BenefitService {
    private final BenefitRule benefitRule;

    public DefaultBenefitService(final BenefitRule benefitRule) {
        this.benefitRule = benefitRule;
    }

    @Override
    public Benefits calculateBenefits(VisitDate visitDate, Items orderItems) {
        return benefitRule.getBenefit(visitDate, orderItems);
    }
}
