package christmas.domain.order;

import christmas.domain.Badge;
import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefits;
import christmas.dto.BenefitDto;
import christmas.dto.ItemDto;
import java.util.List;

public class Order {
    private final VisitDate visitDate;
    private final Items orderItems;
    private final Benefits benefits;
    private final Badge badge;

    private Order(VisitDate visitDate,
                 Items orderItems,
                 Benefits benefits,
                 Badge badge) {
        this.visitDate = visitDate;
        this.orderItems = orderItems;
        this.benefits = benefits;
        this.badge = badge;
    }

    public static Order of(VisitDate visitDate,
                           Items orderItems,
                           Benefits benefits,
                           Badge badge) {
        return new Order(visitDate, orderItems, benefits, badge);
    }

    public Money getTotalAmountNotDiscounted() {
        return orderItems.getTotalAmountNotDiscounted();
    }

    public Money getTotalAmountDiscounted() {
        return getTotalAmountNotDiscounted().minus(getDiscountAmount());
    }

    public Money getBenefitsAmount() {
        return benefits.getTotalAmount();
    }

    public List<ItemDto> getOrderItems() {
        return orderItems.getItems();
    }

    public List<ItemDto> getGiftItems() {
        return benefits.getGiftItems();
    }

    public List<BenefitDto> getBenefits() {
        return benefits.getBenefits();
    }

    private Money getDiscountAmount() {
        return benefits.getDiscountsAmount();
    }
}