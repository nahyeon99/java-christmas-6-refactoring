package christmas.domain.benefit;

public enum BenefitType {
    CHRISTMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT("평일 할인"),
    WEEKEND_DISCOUNT("주말 할인"),
    SPECIAL_DISCOUNT("특별 할인"),
    GIFT("증정 이벤트"),
    NONE("없음");

    private String korean;

    BenefitType(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}