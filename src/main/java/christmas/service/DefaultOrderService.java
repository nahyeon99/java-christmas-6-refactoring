package christmas.service;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefits;
import christmas.domain.order.Order;

public class DefaultOrderService implements OrderService {
    private final BenefitService benefitService;

    public DefaultOrderService(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @Override
    public Order createOrder(VisitDate visitDate, Items orderItems) {
        Benefits benefits = benefitService.calculateBenefits(visitDate, orderItems);
        //TODO: Badge 생성
        //TODO: Order 생성
        return null;
    }
}
