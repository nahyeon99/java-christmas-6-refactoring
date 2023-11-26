package christmas.view;

import christmas.dto.BenefitDto;
import christmas.dto.ItemDto;
import christmas.dto.MoneyDto;
import java.util.List;

public interface ResultView {
    void printItems(List<ItemDto> items);

    void printAmount(MoneyDto amount);

    void printBenefits(List<BenefitDto> benefits);
}