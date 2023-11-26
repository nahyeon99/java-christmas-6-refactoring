package christmas.domain.benefit;

import christmas.domain.Money;
import christmas.dto.ItemDto;
import java.util.List;

public interface BenefitItem {
    Money getAmount();

    List<ItemDto> getItems();
}