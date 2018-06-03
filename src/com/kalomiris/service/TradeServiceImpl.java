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
        boolean isBefore = (date.after(trade.getDate())) ? true : false;
        return isBefore;
    }


}
