package com.kalomiris.service;

import com.kalomiris.model.Stock;
import com.kalomiris.model.Trade;

import java.util.ArrayList;
import java.util.List;

public interface TradeService {

    void recordTrade(Stock stock);
    void createNewTrade(int quantity, double tradePrice, String indicator, Stock stock);
}
