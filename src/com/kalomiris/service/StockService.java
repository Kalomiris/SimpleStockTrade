package com.kalomiris.service;

import com.kalomiris.model.Stock;
import java.util.ArrayList;
import java.util.List;

public interface StockService {
     double calculateDividendYield(Stock stock);
     double calculateRatio(Stock stock);
     double calculateStockPrice(Stock stock);
     double calculateGeoMean();
     double calculateStockPriceTime(Stock stock, int time);
}
