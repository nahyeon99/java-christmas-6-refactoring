package christmas.config;

import static christmas.domain.benefit.BenefitType.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.domain.benefit.BenefitType.WEEKDAY_DISCOUNT;
import static christmas.domain.order.MenuCategory.DESSERT;
import static christmas.domain.order.MenuCategory.MAIN;

import christmas.domain.Event;
import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.DecemberBenefitRule;
import christmas.domain.benefit.Gift;
import christmas.domain.benefit.Gifts;
import christmas.domain.benefit.condition.AmountCondition;
import christmas.domain.benefit.condition.BenefitCondition;
import christmas.domain.benefit.condition.PeriodCondition;
import christmas.domain.benefit.condition.SpecialDateCondition;
import christmas.domain.benefit.condition.WeekDayCondition;
import christmas.domain.benefit.condition.WeekEndCondition;
import christmas.domain.benefit.policy.BenefitPolicy;
import christmas.domain.benefit.policy.DateBasedDiscountPolicy;
import christmas.domain.benefit.policy.FixedAmountDiscountPolicy;
import christmas.domain.benefit.policy.MenuCategoryBasedDiscountPolicy;
import christmas.domain.benefit.policy.MenuGiftPolicy;
import christmas.domain.order.Menu;
import christmas.domain.order.MenuCount;
import christmas.dto.ItemDto;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitRuleConfig {
    static DecemberBenefitRule createDecemberBenefitRule(Event event) {
        Map<BenefitCondition, BenefitPolicy> benefitRules = new HashMap<>();

        benefitRules.putAll(createChristmasDdayDiscountRule(event));
        benefitRules.putAll(createWeekDayDiscountRule());
        benefitRules.putAll(createWeekEndDiscountRule());
        benefitRules.putAll(createSpecialDiscountRule());
        benefitRules.putAll(createMenuGiftRule());

        return new DecemberBenefitRule(benefitRules);
    }

    private static Map<BenefitCondition, BenefitPolicy> createChristmasDdayDiscountRule(Event event) {
        BenefitCondition periodCondition = new PeriodCondition(
                LocalDate.of(event.getYear(), event.getMonth(), 1),
                LocalDate.of(event.getYear(), event.getMonth(), 25));

        BenefitPolicy dateBasedDiscountPolicy = new DateBasedDiscountPolicy(
                CHRISTMAS_D_DAY_DISCOUNT,
                LocalDate.of(event.getYear(), event.getMonth(), 1));

        return Map.of(periodCondition, dateBasedDiscountPolicy);

    }

    private static Map<BenefitCondition, BenefitPolicy> createWeekDayDiscountRule() {
        BenefitCondition weekDayCondition = new WeekDayCondition();
        MenuCategoryBasedDiscountPolicy dessertBasedDiscountPolicy = new MenuCategoryBasedDiscountPolicy(
                WEEKDAY_DISCOUNT,
                DESSERT,
                Money.wons(2_023));

        return Map.of(weekDayCondition, dessertBasedDiscountPolicy);
    }

    private static Map<BenefitCondition, BenefitPolicy> createWeekEndDiscountRule() {
        BenefitCondition weekEndCondition = new WeekEndCondition();
        BenefitPolicy mainBasedDiscountPolicy = new MenuCategoryBasedDiscountPolicy(
                WEEKDAY_DISCOUNT,
                MAIN,
                Money.wons(2_023));
        return Map.of(weekEndCondition, mainBasedDiscountPolicy);
    }

    private static Map<BenefitCondition, BenefitPolicy> createSpecialDiscountRule() {
        BenefitCondition specialDayCondition = new SpecialDateCondition();
        BenefitPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(
                BenefitType.SPECIAL_DISCOUNT, Money.wons(1_000));
        return Map.of(specialDayCondition, fixedAmountDiscountPolicy);
    }

    private static Map<BenefitCondition, BenefitPolicy> createMenuGiftRule() {
        BenefitCondition amountCondition = new AmountCondition(Money.wons(120_000));

        Items giftItems = Items.giftOf(ItemDto.of(Menu.CHAMPAGNE, MenuCount.giftFrom(1)));
        List<Gift> gifts = List.of(Gift.of(giftItems));
        BenefitPolicy menuGiftPolicy = new MenuGiftPolicy(Gifts.of(gifts));

        return Map.of(amountCondition, menuGiftPolicy);
    }
}