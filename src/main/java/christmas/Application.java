package christmas;

import christmas.config.AppConfig;
import christmas.config.Config;
import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        Config instance = AppConfig.getInstance();

        EventController eventController = instance.eventController();
        eventController.run();
    }
}