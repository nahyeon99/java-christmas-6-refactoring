package christmas.dto;

import java.time.Month;

public record EventDto(Month month, int day, String host) {
}