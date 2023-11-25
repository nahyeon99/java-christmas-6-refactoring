package christmas.domain.benefit;

import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    private Benefits(final List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public static Benefits of(final List<Benefit> benefits) {
        return new Benefits(benefits);
    }
}
