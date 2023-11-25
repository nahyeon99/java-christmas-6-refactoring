package christmas.domain;

import static christmas.exception.ExceptionMessage.INVALID_ORDER;

import christmas.domain.order.Menu;
import christmas.domain.order.MenuCount;
import christmas.dto.ItemDto;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Items {
    private final Map<Menu, MenuCount> items;

    private Items(Map<Menu, MenuCount> items) {
        this.items = items;
    }

    public static Items orderOf(List<ItemDto> orderItems) {
        Map<Menu, MenuCount> items = new EnumMap<>(Menu.class);

        int totalMenuCount = 0;
        for (ItemDto orderItem : orderItems) {
            if (items.containsKey(orderItem.getMenu())) {
                throw new IllegalStateException(INVALID_ORDER.getMessage());
            }

            MenuCount menuCount = orderItem.getMenuCount();
            items.put(orderItem.getMenu(), orderItem.getMenuCount());

            totalMenuCount += menuCount.getCount();
        }
        validateOrderCount(totalMenuCount);

        return new Items(items);
    }

    private static void validateOrderCount(int count) {
        if (count > 20) {
            throw new IllegalStateException(INVALID_ORDER.getMessage());
        }
    }
}