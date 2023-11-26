package christmas;

import christmas.config.AppConfig;
import christmas.config.Config;
import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        Config instance = generateConfig();

        EventController eventController = generateEventController(instance);
        eventController.run();
    }

    private static Config generateConfig() {
        return AppConfig.getInstance();
    }

    private static EventController generateEventController(Config instance) {
        return instance.eventController();
    }
}