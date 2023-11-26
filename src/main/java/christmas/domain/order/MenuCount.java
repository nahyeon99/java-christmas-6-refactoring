package christmas.domain.order;

import static christmas.exception.ExceptionMessage.INVALID_ORDER;

public class MenuCount {
    private final int count;

    private MenuCount(int count) {
        this.count = count;
    }

    public static MenuCount orderFrom(int count) {
        validateCountSize(count);
        return new MenuCount(count);
    }

    public static MenuCount giftFrom(int count) {
        return new MenuCount(count);
    }

    public int getCount() {
        return count;
    }

    private static void validateCountSize(int count) {
        if (count < 0 || count > 20) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}