package christmas.domain;

import java.time.Month;
import java.time.Year;

public class Event {
    private final Year year;
    private final Month month;
    private final String host;

    public Event(Year year, Month month, String host) {
        this.year = year;
        this.month = month;
        this.host = host;
    }

    public int getYear() {
        return year.getValue();
    }

    public Month getMonth() {
        return month;
    }

    public String getHost() {
        return host;
    }
}