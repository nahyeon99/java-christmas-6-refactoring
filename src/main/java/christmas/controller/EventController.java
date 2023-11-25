package christmas.controller;

import christmas.domain.Event;
import christmas.domain.Items;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import christmas.dto.ItemDto;
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
}