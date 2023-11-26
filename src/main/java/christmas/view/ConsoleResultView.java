package christmas.view;

import christmas.dto.ItemDto;
import java.util.List;

public class ConsoleResultView implements ResultView {
    @Override
    public void printItems(List<ItemDto> items) {
        items.forEach(this::printItem);
    }

    private void printItem(ItemDto item) {
        System.out.printf(OutputMessage.ITEMS_FORMAT.message, item.getMenu(), item.getMenuCount().getCount());
    }

    private enum OutputMessage {
        ITEMS_FORMAT("%s %d개"),
        ;

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
}
