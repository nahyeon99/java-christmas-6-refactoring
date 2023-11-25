package christmas.util;

import static christmas.exception.ExceptionMessage.INVALID_BLANK_INPUT;
import static christmas.exception.ExceptionMessage.INVALID_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class InputUtil {
    public static String readLine() {
        while (true) {
            String input = Console.readLine();
            if (Objects.isNull(input) || input.isBlank()) {
                throw new IllegalArgumentException(INVALID_BLANK_INPUT.getMessage());
            }
        }
    }

    public static int readNumber(String input) {
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }

    public static List<String> readList(String input, String delimiter) {
        return seperate(input, delimiter);
    }

    public static <T> T repeatUntilValidInput(String errorMessage, Supplier<T> repeatSupplier) {
        while (true) {
            try {
                return repeatSupplier.get();
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static List<String> seperate(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .toList();
    }
}