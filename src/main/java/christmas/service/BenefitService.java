package christmas.service;

import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.benefit.Benefits;

public interface BenefitService {
    Benefits calculateBenefits(VisitDate visitDate, Items orderItems);
}
