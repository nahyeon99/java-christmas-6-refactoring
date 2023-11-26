package christmas.dto;

import christmas.domain.Event;
import christmas.domain.VisitDate;
import java.time.Month;

public record EventDto(Month month, int day, String host) {
    public static EventDto of(Event event, VisitDate visitDate) {
        return new EventDto(event.getMonth(), visitDate.getDay(), event.getHost());
    }
}