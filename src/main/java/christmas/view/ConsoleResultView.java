package christmas.view;

import christmas.dto.BenefitDto;
import christmas.dto.ItemDto;
import christmas.dto.MoneyDto;
import java.math.BigDecimal;
import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void printItems(List<ItemDto> items) {
        items.forEach(this::printItem);
    }

    @Override
    public void printAmount(MoneyDto amount) {
        System.out.printf(OutputMessage.AMOUNT_FORMAT.message, amountFormat(amount.amount()));
        System.out.println();
    }

    @Override
    public void printBenefits(List<BenefitDto> benefits) {
        benefits.forEach(this::printBenefit);
    }

    private void printItem(ItemDto item) {
        System.out.printf(OutputMessage.ITEMS_FORMAT.message, item.getMenu(), item.getMenuCount().getCount());
        System.out.println();
    }

    private void printBenefit(BenefitDto benefit) {
        System.out.printf(OutputMessage.BENEFIT_FORMAT.message,
                benefit.benefitType(), amountFormat(benefit.benefitAmount()));

        System.out.println();
    }

    private String amountFormat(BigDecimal money) {
        return String.format("%,d", money.intValue());
    }

    private enum OutputMessage {
        ITEMS_FORMAT("%s %d개"),
        AMOUNT_FORMAT("%s원"),
        BENEFIT_FORMAT("%s: %d원"),
        ;

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
}