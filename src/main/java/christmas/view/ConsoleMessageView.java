package christmas.view;

import christmas.dto.EventDto;
import christmas.dto.MonthDto;

public class ConsoleMessageView implements MessageView {
    @Override
    public void printWelcomeMessage() {
        System.out.println(OutputMessage.WELCOME);
    }

    @Override
    public void printVisitDateRequest() {
        System.out.println(OutputMessage.INPUT_VISIT_DATE);
    }

    @Override
    public void printOrderRequest() {
        System.out.println(OutputMessage.INPUT_ORDER);
    }

    @Override
    public void printPreviewTitle(EventDto eventDto) {
        System.out.printf(OutputMessage.PREVIEW_TITLE_FORMAT.message,
                eventDto.month(), eventDto.day(), eventDto.host());

        System.out.println();
        System.out.println();
    }

    @Override
    public void printOrderMenuResultTitle() {
        System.out.println(formatResultTitle(OutputMessage.RESULT_ORDER_MENU_TITLE.message));
    }

    @Override
    public void printTotalAmountNotDiscountedResultTitle() {
        System.out.println(formatResultTitle(OutputMessage.RESULT_TOTAL_AMOUNT_NOT_DISCOUNTED_TITLE.message));
    }

    @Override
    public void printGiftResultTitle() {
        System.out.println(formatResultTitle(OutputMessage.RESULT_GIFT_TITLE.message));
    }

    @Override
    public void printBenefitsTitle() {
        System.out.println(formatResultTitle(OutputMessage.RESULT_BENEFITS_TITLE.message));
    }

    @Override
    public void printBenefitsAmountTitle() {
        System.out.println(formatResultTitle(OutputMessage.RESULT_BENEFITS_AMOUNT_TITLE.message));
    }

    @Override
    public void printTotalAmountDiscountedTitle() {
        System.out.println(formatResultTitle(OutputMessage.RESULT_TOTAL_AMOUNT_DISCOUNTED_TITLE.message));
    }

    @Override
    public void printEventBadgeTitle(MonthDto monthDto) {
        String title = String.format(OutputMessage.RESULT_MONTHLY_EVENT_BADGE_FORMAT.message, monthDto.month());
        System.out.println(resultTitleFormat(title));
    }

    private String resultTitleFormat(String title) {
        return String.format(OutputMessage.RESULT_TITLE_FORMAT.message, title);
    }

    private enum OutputMessage {
        WELCOME("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        INPUT_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        INPUT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
        PREVIEW_TITLE_FORMAT("%d월 %d일에 %s에서 받을 이벤트 혜택 미리 보기!"),
        RESULT_TITLE_FORMAT("<%s>"),
        RESULT_ORDER_MENU_TITLE("주문 메뉴"),
        RESULT_TOTAL_AMOUNT_NOT_DISCOUNTED_TITLE("할인 전 총주문 금액"),
        RESULT_GIFT_TITLE("증정 메뉴"),
        RESULT_BENEFITS_TITLE("혜택 내역"),
        RESULT_BENEFITS_AMOUNT_TITLE("총혜택 금액"),
        RESULT_TOTAL_AMOUNT_DISCOUNTED_TITLE("할인 후 예상 결제 금액"),
        RESULT_MONTHLY_EVENT_BADGE_FORMAT("%d월 이벤트 배지");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }
}