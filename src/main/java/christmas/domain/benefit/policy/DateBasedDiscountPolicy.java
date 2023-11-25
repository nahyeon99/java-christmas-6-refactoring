package christmas.domain.benefit.policy;

import static java.time.temporal.ChronoUnit.DAYS;

import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.DiscountItem;
import java.time.LocalDate;

public class DateBasedDiscountPolicy implements DiscountPolicy {
    private final BenefitType benefitType;
    private final LocalDate startDate;

    public DateBasedDiscountPolicy(BenefitType benefitType, LocalDate startDate) {
        this.benefitType = benefitType;
        this.startDate = startDate;
    }

    @Override
    public Benefit calculateBenefit(VisitDate visitDate, Items orderItem) {
        Money discountAmount = calculateIncreaseAmount(visitDate)
                .plus(DateBasedDiscountPolicy.discountAmount.BASE.money);

        return Benefit.of(benefitType, DiscountItem.from(discountAmount));
    }

    private Money calculateIncreaseAmount(VisitDate visitDate) {
        int period = (int) DAYS.between(visitDate.getDate(), startDate);
        Money increaseAmount = discountAmount.DAILY_INCREASE.money;
        return increaseAmount.multiply(period);
    }

    private enum discountAmount {
        BASE(1_000),
        DAILY_INCREASE(100);

        private final Money money;

        discountAmount(int amount) {
            this.money = Money.wons(amount);
        }
    }
}