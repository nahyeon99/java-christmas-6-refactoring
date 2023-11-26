package christmas.view;

import christmas.dto.ItemDto;
import christmas.dto.MoneyDto;
import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void printItems(List<ItemDto> items) {
        items.forEach(this::printItem);
    }

    @Override
    public void printAmount(MoneyDto amount) {
        System.out.printf(OutputMessage.AMOUNT_FORMAT.message, amountFormat(amount));
        System.out.println();
    }

    private void printItem(ItemDto item) {
        System.out.printf(OutputMessage.ITEMS_FORMAT.message, item.getMenu(), item.getMenuCount().getCount());
        System.out.println();
    }

    private String amountFormat(MoneyDto money) {
        return String.format("%,d", money.amount());
    }

    private enum OutputMessage {
        ITEMS_FORMAT("%s %d개"),
        AMOUNT_FORMAT("%s원"),
        ;

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
}
