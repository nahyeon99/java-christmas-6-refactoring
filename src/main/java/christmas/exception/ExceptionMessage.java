package christmas.exception;

public enum ExceptionMessage {
    INVALID_BLANK_INPUT("공백은 입력할 수 없습니다."),
    INVALID_NUMBER_FORMAT("정수를 입력하세요."),
    INVALID_VISIT_DATE("유효하지 않은 날짜입니다."),
    INVALID_ORDER("유효하지 않은 주문입니다.")
    ;

    private final String message;
    private final String EXCEPTION_FORMAT = "[ERROR] %s 다시 입력해 주세요.";

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(EXCEPTION_FORMAT, message);
    }
}