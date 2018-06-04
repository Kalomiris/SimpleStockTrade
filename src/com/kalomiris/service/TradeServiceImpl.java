package com.kalomiris.service;

import com.kalomiris.dataBase.DataBase;
import com.kalomiris.model.Stock;
import com.kalomiris.model.Trade;

public class TradeServiceImpl implements TradeService {

    @Override
    public void createNewTrade(int quantity, double tradePrice, String indicator, Stock stock) {
        if (indicator.equalsIgnoreCase("b")){
            DataBase.addTrade(new Trade(quantity, tradePrice, Trade.Indicator.BUY),stock);
        }
        if (indicator.equalsIgnoreCase("s")){
            DataBase.addTrade(new Trade(quantity, tradePrice, Trade.Indicator.SELL),stock);
        }
    }

    @Override
    public void recordTrade(Stock stock) {
        for (Trade element : stock.getTradeList()){
            System.out.println(element.getDate() +
                    "\nGiven symbol of stock: " + stock.getSymbol() +
                    "\nQuantity: " + element.getQuantity() +
                    "\nIs " + element.getIndicator() +
                    "\nPrice: " + element.getTradePrice());
        }
    }




}
