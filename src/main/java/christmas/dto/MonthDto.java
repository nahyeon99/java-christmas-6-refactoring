package christmas.dto;

import christmas.domain.Event;
import java.time.Month;

public record MonthDto(Month month) {
    public static MonthDto from(Event event) {
        return new MonthDto(event.getMonth());
    }
}
