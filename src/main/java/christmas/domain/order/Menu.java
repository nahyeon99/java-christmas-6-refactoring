package christmas.domain.order;

import static christmas.exception.ExceptionMessage.INVALID_ORDER;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP(MenuCategory.APPETIZER, 6_000, "양송이수프"),
    TAPAS(MenuCategory.APPETIZER, 5_500, "타파스"),
    CAESAR_SALAD(MenuCategory.APPETIZER, 8_000, "시저샐러드"),

    T_BONE_STEAK(MenuCategory.MAIN, 55_000, "티본스테이크"),
    BBQ_RIBS(MenuCategory.MAIN, 54_000, "바비큐립"),
    SEAFOOD_PASTA(MenuCategory.MAIN, 35_000, "해산물파스타"),
    CHRISTMAS_PASTA(MenuCategory.MAIN, 25_000, "크리스마스파스타"),

    CHOCOLATE_CAKE(MenuCategory.DESSERT, 15_000, "초코케이크"),
    ICE_CREAM(MenuCategory.DESSERT, 5_000, "아이스크림"),

    ZERO_COLA(MenuCategory.BEVERAGE, 3_000, "제로콜라"),
    RED_WINE(MenuCategory.BEVERAGE, 60_000, "레드와인"),
    CHAMPAGNE(MenuCategory.BEVERAGE, 25_000, "샴페인"),

    NONE(MenuCategory.NONE, 0, "없음");

    private final MenuCategory category;
    private final int price;
    private final String korean;

    Menu(MenuCategory menuCategory, int price, String korean) {
        this.category = menuCategory;
        this.price = price;
        this.korean = korean;
    }

    public static Menu from(String menu) {
        return Arrays.stream(values())
                .filter(item -> item.getKorean().equals(menu.replaceAll(" ", "")))
                .findAny()
                .orElseThrow(() -> new IllegalStateException(INVALID_ORDER.getMessage()));
    }

    public String getKorean() {
        return korean;
    }

    public int calculateAmountBy(MenuCount menuCount) {
        return Math.multiplyExact(price, menuCount.getCount());
    }

    public boolean equalsBy(MenuCategory menuCategory) {
        return category.equals(menuCategory);
    }
}