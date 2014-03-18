package model;

/**
 * Created by paul.gribelyuk on 3/17/14.
 */
public class Money {

    private boolean currencySet;
    private boolean amountSet;
    private String currency;
    private double amount;

    public Money(String ccy, double amount) {
        this.currency = currency;
        this.amount = amount;

        this.currencySet = true;
        this.amountSet = true;
    }

    public Money() {
        this.currencySet = false;
        this.amountSet = false;
    }

    public Money withCurrency(String currency) {
        this.currency = currency;
        this.currencySet = true;
        return this;
    }

    public Money havingAmount(double amount) {
        this.amount = amount;

        return this;
    }

    public double getAmount() { return this.amount; }
    public String getCurrency() { return this.currency; }

    public String toString() { return String.valueOf(getAmount()) + "_" + getCurrency(); }

}
