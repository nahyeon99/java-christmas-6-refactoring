package christmas.view;

import christmas.dto.EventDto;
import christmas.dto.MonthDto;

public interface MessageView {
    void printWelcomeMessage();

    void printVisitDateRequest();

    void printOrderRequest();

    void printPreviewTitle(EventDto eventDto);

    void printOrderMenuResultTitle();

    void printTotalAmountNotDiscountedResultTitle();

    void printGiftResultTitle();

    void printBenefitsTitle();

    void printBenefitsAmountTitle();

    void printTotalAmountDiscountedTitle();

    void printEventBadgeTitle(MonthDto monthDto);
}
