package christmas.service;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;

public interface OrderService {
    Order createOrder(VisitDate visitDate, Items orderItems);
}
