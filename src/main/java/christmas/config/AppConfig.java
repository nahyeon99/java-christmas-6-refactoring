package christmas.config;

import christmas.controller.EventController;
import christmas.domain.Event;
import christmas.service.BenefitService;
import christmas.service.DefaultBenefitService;
import christmas.service.DefaultOrderService;
import christmas.service.OrderService;
import christmas.view.ConsoleInputView;
import christmas.view.ConsoleMessageView;
import christmas.view.ConsoleResultView;
import christmas.view.InputView;
import christmas.view.MessageView;
import christmas.view.ResultView;
import java.time.Month;
import java.time.Year;

public class AppConfig implements Config {

    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public EventController eventController() {
        return LazyHolder.eventController;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();

        private static final Event event = createEvent();
        private static final BenefitService benefitService = createBenefitService();
        private static final OrderService orderService = createOrderService();
        private static final InputView inputView = createInputView();
        private static final MessageView messageView = createMessageView();
        private static final ResultView resultView = createResultView();
        private static final EventController eventController = createEventController();

        private static Event createEvent() {
            return new Event(Year.of(2023), Month.DECEMBER, "우테코 식당");
        }

        private static BenefitService createBenefitService() {
            return new DefaultBenefitService(BenefitRuleConfig.createDecemberBenefitRule(event));
        }

        private static OrderService createOrderService() {
            return new DefaultOrderService(benefitService);
        }

        private static InputView createInputView() {
            return new ConsoleInputView();
        }

        private static MessageView createMessageView() {
            return new ConsoleMessageView();
        }

        private static ResultView createResultView() {
            return new ConsoleResultView();
        }

        private static EventController createEventController() {
            return new EventController(event, inputView, messageView, resultView, orderService);
        }
    }
}