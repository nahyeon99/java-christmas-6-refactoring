package christmas.domain.order;

import christmas.domain.Badge;
import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefits;

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
}
