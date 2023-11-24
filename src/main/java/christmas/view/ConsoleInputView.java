package christmas.view;

import christmas.util.InputUtil;
import java.util.List;

public class ConsoleInputView implements InputView {
    @Override
    public int inputVisitDate() {
        System.out.println(InputMessage.INPUT_VISIT_DATE);
        return InputUtil.readNumber();
    }

    @Override
    public List<String> inputMenuAndCount() {
        System.out.println(InputMessage.INPUT_ORDER);
        return InputUtil.readList();
    }

    private enum InputMessage {
        INPUT_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        INPUT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }
}