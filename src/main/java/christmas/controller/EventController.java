package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Event;
import christmas.domain.Items;
import christmas.domain.Money;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import christmas.dto.BadgeDto;
import christmas.dto.BenefitDto;
import christmas.dto.EventDto;
import christmas.dto.ItemDto;
import christmas.dto.MoneyDto;
import christmas.dto.MonthDto;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.MessageView;
import christmas.view.ResultView;
import java.util.List;

public class EventController {
    private final Event event;
    private final InputView inputView;
    private final MessageView messageView;
    private final ResultView resultView;
    private final OrderService orderService;

    public EventController(Event event,
                           InputView inputView,
                           MessageView messageView,
                           ResultView resultView,
                           OrderService orderService) {
        this.event = event;
        this.inputView = inputView;
        this.messageView = messageView;
        this.resultView = resultView;
        this.orderService = orderService;
    }

    public void run() {
        welcome();

        VisitDate visitDate = askVisitDate();
        Order order = generateOrder(visitDate);

        printPreviewTitle(EventDto.of(event, visitDate));
        printOrderResult(order);
    }

    private void welcome() {
        messageView.printWelcomeMessage();
    }

    private VisitDate askVisitDate() {
        messageView.printVisitDateRequest();

        return VisitDate.of(event, inputView.inputVisitDate());
    }

    private Order generateOrder(VisitDate visitDate) {
        return orderService.createOrder(visitDate, askOrder());
    }

    private Items askOrder() {
        messageView.printOrderRequest();
        List<ItemDto> itemDtos = inputView.inputMenuAndCount();

        return Items.orderOf(itemDtos);
    }

    private void printPreviewTitle(EventDto eventDto) {
        messageView.printPreviewTitle(eventDto);
    }

    private void printOrderResult(Order order) {
        printOrderMenu(order.getOrderItems());
        printTotalAmountNotDiscounted(order.getTotalAmountNotDiscounted());
        printGiftMenu(order.getGiftItems());
        printBenefits(order.getBenefits());
        printTotalBenefitAmount(order.getBenefitsAmount());
        printTotalAmountDiscounted(order.getTotalAmountDiscounted());
        printEventBadge(order.getBadge());
    }

    private void printOrderMenu(List<ItemDto> orderItems) {
        messageView.printOrderMenuResultTitle();
        resultView.printItems(orderItems);
    }

    private void printTotalAmountNotDiscounted(Money totalAmountNotDiscounted) {
        messageView.printTotalAmountNotDiscountedResultTitle();
        resultView.printAmount(MoneyDto.from(totalAmountNotDiscounted));
    }

    private void printGiftMenu(List<ItemDto> giftItems) {
        messageView.printGiftResultTitle();
        resultView.printItems(giftItems);
    }

    private void printBenefits(List<BenefitDto> benefits) {
        messageView.printBenefitsTitle();
        resultView.printBenefits(benefits);
    }

    private void printTotalBenefitAmount(Money amount) {
        messageView.printBenefitsAmountTitle();
        resultView.printAmount(MoneyDto.minusFrom(amount));
    }

    private void printTotalAmountDiscounted(Money amount) {
        messageView.printTotalAmountDiscountedTitle();
        resultView.printAmount(MoneyDto.from(amount));
    }

    private void printEventBadge(Badge badge) {
        messageView.printEventBadgeTitle(MonthDto.from(event));
        resultView.printBadge(BadgeDto.from(badge));
    }
}