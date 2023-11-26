package christmas.dto;

import static christmas.exception.ExceptionMessage.INVALID_ORDER;

import christmas.domain.order.Menu;
import christmas.domain.order.MenuCount;
import christmas.util.InputUtil;
import java.util.List;
import java.util.Map;

public class ItemDto {
    private static final String MENU_COUNT_SEPERATOR = "-";

    private final Menu menu;
    private final MenuCount menuCount;

    private ItemDto(Menu menu, MenuCount menuCount) {
        this.menu = menu;
        this.menuCount = menuCount;
    }

    public static List<ItemDto> from(List<String> itemCounts) {
        return itemCounts.parallelStream()
                .map(itemCount -> itemCount.split(MENU_COUNT_SEPERATOR))
                .filter(ItemDto::validateOrderCountFormat)
                .map(itemCount -> of(itemCount[0], itemCount[1]))
                .toList();
    }

    public static List<ItemDto> from(Map<Menu, MenuCount> items) {
        return items.keySet().parallelStream()
                .map(menu -> new ItemDto(menu, items.get(menu)))
                .toList();
    }

    private static ItemDto of(String menu, String count) {
        MenuCount orderCount = MenuCount.orderFrom(InputUtil.readNumber(count.trim()));
        return new ItemDto(Menu.from(menu.trim()), orderCount);
    }

    public Menu getMenu() {
        return menu;
    }

    public MenuCount getMenuCount() {
        return menuCount;
    }

    private static boolean validateOrderCountFormat(String[] orderCount) {
        if (orderCount.length != 2) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
        return true;
    }
}
