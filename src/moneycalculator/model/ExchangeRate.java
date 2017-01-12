package moneycalculator.model;


public class ExchangeRate {
    private final double amuont;
    private final Currency from;
    private final Currency to;

    public ExchangeRate(double amuont, Currency from, Currency to) {
        this.amuont = amuont;
        this.from = from;
        this.to = to;
    }

    public double getAmuont() {
        return amuont;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }
    
}
