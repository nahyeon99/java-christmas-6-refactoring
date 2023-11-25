package christmas.domain.benefit;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.condition.BenefitCondition;
import christmas.domain.benefit.policy.BenefitPolicy;
import java.util.List;
import java.util.Map;

public class DecemberBenefitRule implements BenefitRule {
    private final Map<BenefitCondition, BenefitPolicy> rules;

    public DecemberBenefitRule(final Map<BenefitCondition, BenefitPolicy> rules) {
        this.rules = rules;
    }

    @Override
    public Benefits getBenefit(VisitDate visitDate, Items orderItems) {
        List<Benefit> benefits = rules.keySet().parallelStream()
                .filter(condition -> condition.isSatisfiedBy(visitDate, orderItems))
                .map(condition -> {
                    BenefitPolicy benefitPolicy = rules.get(condition);
                    return benefitPolicy.calculateBenefit(visitDate, orderItems);
                })
                .toList();

        return Benefits.of(benefits);
    }
}