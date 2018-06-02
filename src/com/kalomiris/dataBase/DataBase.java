package com.kalomiris.dataBase;

import com.kalomiris.model.Stock;
import com.kalomiris.model.Trade;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<Stock> stocksList = new ArrayList<>();

    static {
        initializeDB();
    }

    public static void initializeDB() {
        Stock stock1 = new Stock("TEA", 0,
                0, 100, 20, Stock.Type.COMMON);
        Stock stock2 = new Stock("POP", 8,
                0, 100, 25,Stock.Type.COMMON);
        Stock stock3 = new Stock("ALE", 23,
                0, 60, 41,Stock.Type.COMMON);
        Stock stock4 = new Stock("GIN", 8,
                2, 100, 60,Stock.Type.PREFERRED);
        Stock stock5 = new Stock("JOE", 13,
                0, 250, 79,Stock.Type.COMMON);

        Trade trade1 = new Trade(100,120.3, Trade.Indicator.BUY);
        Trade trade2 = new Trade(150,125.5, Trade.Indicator.SELL);
        List<Trade> tradeList = new ArrayList<>();
        tradeList.add(trade1);
        tradeList.add(trade2);
        stock1.setTradeList(tradeList);
        stock2.setTradeList(tradeList);
        stock3.setTradeList(tradeList);
        stock4.setTradeList(tradeList);
        stock5.setTradeList(tradeList);


        stocksList.add(stock1);
        stocksList.add(stock2);
        stocksList.add(stock3);
        stocksList.add(stock4);
        stocksList.add(stock5);

    }

    public static Stock retrieveStock(String symbol){
        for (Stock element : stocksList){
            if(symbol.equalsIgnoreCase(element.getSymbol())){
                return element;
            }
        }
        return null;
    }

    public static List<Stock> getStocksList() {
        return stocksList;
    }
}
