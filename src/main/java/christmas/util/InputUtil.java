package christmas.util;

import static christmas.exception.ExceptionMessage.INVALID_BLANK_INPUT;
import static christmas.exception.ExceptionMessage.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.ConsoleOutputView;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class InputUtil {
    private static final String MENU_SEPERATOR = ",";

    public static int readNumber() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }

    public static List<String> readList() {
        return seperate(readLine());
    }

    public static <T> T repeatUntilValidInput(String errorMessage, Supplier<T> repeatSupplier) {
        while (true) {
            try {
                return repeatSupplier.get();
            } catch (RuntimeException exception) {
                ConsoleOutputView.printExceptionMessage(exception.getMessage());
            }
        }
    }

    private static String readLine() {
        while (true) {
            String input = Console.readLine();
            if (Objects.isNull(input) || input.isBlank()) {
                throw new IllegalArgumentException(INVALID_BLANK_INPUT.getMessage());
            }
        }
    }

    private static List<String> seperate(final String input) {
        return Arrays.stream(input.split(MENU_SEPERATOR))
                .toList();
    }
}