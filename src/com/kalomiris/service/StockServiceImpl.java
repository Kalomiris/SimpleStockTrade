package com.kalomiris.service;

import com.kalomiris.dataBase.DataBase;
import com.kalomiris.model.Stock;
import com.kalomiris.model.Trade;

public class StockServiceImpl implements StockService {
    private TradeServiceImpl tradeServiceImpl = new TradeServiceImpl();




    @Override
    public double calculateDividendYield(Stock stock) {
        int lastDividend = stock.getLastDividend();
        double tickerPrice = stock.getTickerPrice();
        double dividendYield = lastDividend / tickerPrice;
        return dividendYield;
    }

    @Override
    public double calculateRatio(Stock stock) {
        double tickerPrice = stock.getTickerPrice();
        double ratio = 0.0;
        if (calculateDividendYield(stock) != 0) {
            ratio = tickerPrice / calculateDividendYield(stock);
        }
        return ratio;
    }

    @Override
    public double calculateStockPrice(Stock stock) {        //stockPrice = Sum(tradePrice* quantity) / Sum(quantity).
        double sumProduction = 0.0;
        int sumQuantity = 0;
        for (Trade element : stock.getTradeList()) {
            sumProduction += element.getTradePrice() * element.getQuantity();
            sumQuantity += element.getQuantity();
        }
        double stockPrice = sumProduction / sumQuantity;
        return stockPrice;
    }

    @Override
    public double calculateStockPriceTime(Stock stock, int time) {            //stockPrice = Sum(tradePrice* quantity) / Sum(quantity).
        double sumProduction = 0;
        int sumQuantity = 0;
        for (Trade element : stock.getTradeList()){
            if (tradeServiceImpl.findTradeSpecificDate(element,time)){
                sumProduction += element.getTradePrice() * element.getQuantity();
                sumQuantity += element.getQuantity();
            }
        }
        double stockPriceTime = sumProduction / sumQuantity;
        return stockPriceTime;
    }

    @Override
    public double calculateGeoMean() {          //Geometric mean = root(p1*p2*p3).
        double productStockPrice = 1.0;
        int counter = 0;
        for (Stock element : DataBase.getStocksList()) {
            productStockPrice *= calculateStockPrice(element);
            counter++;
        }
        return Math.pow(productStockPrice, 1/counter);
    }
}
