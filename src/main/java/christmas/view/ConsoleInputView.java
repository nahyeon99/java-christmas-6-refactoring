package christmas.view;

import christmas.dto.ItemDto;
import christmas.util.InputUtil;
import java.util.List;

public class ConsoleInputView implements InputView {
    private static final String ORDER_SEPERATOR = ",";

    @Override
    public int inputVisitDate() {
        return InputUtil.readNumber(InputUtil.readLine());
    }

    @Override
    public List<ItemDto> inputMenuAndCount() {
        List<String> menuAndCount = InputUtil.readList(InputUtil.readLine(), ORDER_SEPERATOR);
        return ItemDto.from(menuAndCount);
    }
}