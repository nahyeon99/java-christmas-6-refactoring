package christmas.dto;

import christmas.domain.Badge;

public record BadgeDto(String badge) {
    public static BadgeDto from(Badge badge) {
        return new BadgeDto(badge.name());
    }
}