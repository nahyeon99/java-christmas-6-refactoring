package christmas.view;

import christmas.dto.ItemDto;
import java.util.List;

public interface ResultView {
    void printItems(List<ItemDto> items);
}