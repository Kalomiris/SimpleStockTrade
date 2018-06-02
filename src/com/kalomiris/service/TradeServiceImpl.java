package com.kalomiris.service;

import com.kalomiris.dateUtils.ComputeDate;
import com.kalomiris.model.Trade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TradeServiceImpl implements TradeService {



    public boolean findTradeSpecificDate(Trade trade, int time) {
        Date date = ComputeDate.computeSpecificDate(time);
        boolean isBefore = (trade.getDate().after(date)) ? true : false;
        return isBefore;
    }

//    @Override
//    public void addRecord(Trade trade) {
//        newTrade = ("b".equals(indicator)) ? new Trade(quantity, tradePrice, Trade.INDICATOR.BUY) :
//                new Trade(quantity, tradePrice, Trade.INDICATOR.SELL);
//
//        newStock.addTrade(newTrade);              //add new trade in my list (in Stock class)
//        tradeServiceImpl.addRecord(newTrade);            //record each new trade
//        tradeRecords.add(trade);
//    }


}
