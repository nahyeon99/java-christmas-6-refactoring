package christmas.domain.benefit.policy;

import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefit;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.DiscountItem;
import christmas.domain.order.MenuCategory;

public class MenuCategoryBasedDiscountPolicy implements DiscountPolicy {
    private final BenefitType benefitType;
    private final MenuCategory menuCategory;
    private final Money menuPerDiscountAmount;

    public MenuCategoryBasedDiscountPolicy(BenefitType benefitType,
                                           MenuCategory menuCategory,
                                           Money menuPerDiscountAmount) {
        this.benefitType = benefitType;
        this.menuCategory = menuCategory;
        this.menuPerDiscountAmount = menuPerDiscountAmount;
    }

    @Override
    public Benefit calculateBenefit(VisitDate visitDate, Items orderItem) {
        int countByMenuCategory = orderItem.getCountByMenuCategory(menuCategory);
        Money discountAmount = menuPerDiscountAmount.multiply(countByMenuCategory);

        return Benefit.of(benefitType, DiscountItem.from(discountAmount));
    }
}