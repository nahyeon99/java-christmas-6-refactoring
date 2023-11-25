package christmas.view;

import christmas.dto.ItemDto;
import java.util.List;

public interface InputView {
    int inputVisitDate();

    List<ItemDto> inputMenuAndCount();
}
