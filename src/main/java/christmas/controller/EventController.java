package christmas.controller;

import christmas.domain.Event;
import christmas.domain.VisitDate;
import christmas.view.InputView;
import christmas.view.MessageView;
import christmas.view.ResultView;

public class EventController {
    private final Event event;
    private final InputView inputView;
    private final MessageView messageView;
    private final ResultView resultView;

    public EventController(Event event,
                           InputView inputView,
                           MessageView messageView,
                           ResultView resultView) {
        this.event = event;
        this.inputView = inputView;
        this.messageView = messageView;
        this.resultView = resultView;
    }

    public void run() {
        welcome();
        VisitDate visitDate = askVisitDate();
    }

    private void welcome() {
        messageView.printWelcomeMessage();
    }

    private VisitDate askVisitDate() {
        messageView.printVisitDateRequest();

        return VisitDate.of(event, inputView.inputVisitDate());
    }
}