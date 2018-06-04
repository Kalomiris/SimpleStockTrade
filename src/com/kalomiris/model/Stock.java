package com.kalomiris.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {


    public enum Type {COMMON, PREFERRED}
    Type type;

    private String symbol;
    private int lastDividend;
    private int fixedDividend;
    private int parValue;
    private double tickerPrice;
    private List<Trade> tradeList = new ArrayList<>();

    public Stock(String symbol,
                 int lastDividend,
                 int fixedDividend,
                 int parValue,
                 double tickerPrice,
                 Type type) {
        this.symbol = symbol;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
        this.tickerPrice = tickerPrice;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getLastDividend() {
        return lastDividend;
    }


    public double getTickerPrice() {
        return tickerPrice;
    }

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public int getFixedDividend() {
        return fixedDividend;
    }

    public int getParValue() {
        return parValue;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    public void addInTradeList(Trade trade) {
        tradeList.add(trade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return symbol.equals(stock.symbol);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }
}
