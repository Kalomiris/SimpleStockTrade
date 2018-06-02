package com.kalomiris.model;

import java.util.Date;

public class Trade {

    public enum Indicator { BUY, SELL }

    private Indicator indicator;
    private int quantity;
    private double tradePrice;
    private Date date;

    public Trade(int quantity, double tradePrice, Indicator indicator) {
        this.quantity = quantity;
        this.tradePrice = tradePrice;
        this.indicator = indicator;
        date = new Date();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public Date getDate() {
        return date;
    }

    public Indicator getIndicator() {
        return indicator;
    }
}
