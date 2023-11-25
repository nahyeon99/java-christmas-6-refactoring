package christmas.domain.benefit.condition;

import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.VisitDate;

public class AmountCondition implements BenefitCondition {
    private final Money minBoundAmount;

    public AmountCondition(Money minBoundAmount) {
        this.minBoundAmount = minBoundAmount;
    }

    @Override
    public boolean isSatisfiedBy(VisitDate visitDate, Items orderItem) {
        Money totalAmountNotDiscounted = orderItem.getTotalAmountNotDiscounted();

        if (totalAmountNotDiscounted.isGreaterThanOrEqual(minBoundAmount)) {
            return true;
        }
        return false;
    }
}
