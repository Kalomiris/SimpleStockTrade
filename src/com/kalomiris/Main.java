package com.kalomiris;

import com.kalomiris.dataBase.DataBase;
import com.kalomiris.exception.WrongNumberException;
import com.kalomiris.model.Stock;
import com.kalomiris.model.Trade;
import com.kalomiris.service.StockServiceImpl;
import com.kalomiris.service.TradeServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {

    public static StockServiceImpl stockServiceImpl = new StockServiceImpl();
    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        boolean quit = false;
        while (!quit) {

            System.out.println("Press -1- for stock trade or -2- for calculating the GBCE All Shares\n" +
                    "-0- to quit.\n");
            int firstAction = enterAction();

            switch (firstAction) {

                case 0:

                    /** Quit from application  */
                    quit = true;
                    System.out.println("\n\nShout-down application...");
                    break;

                case 1:

                    /**    For a given stock   */

                    Stock newStock = chooseStock();

                    int secondAction = enterAction();

                    switch (secondAction) {

                        case 1:

                            /**  Compute dividend yield  */
                            double dividendYield = stockServiceImpl.calculateDividendYield(newStock);
                            System.out.println("Dividend yield: " + dividendYield);
                            break;

                        case 2:

                            /** Compute P/E Ratio  */
                            double ration = stockServiceImpl.calculateRatio(newStock);
                            if (ration != 0.0) {
                                System.out.println("Ratio: " + ration);
                            } else {
                                System.out.println("Try again...");
                            }
                            break;

                        case 3:

                            /** Record a trade  */
                            Trade currentTrade = newStock.getTradeList().get(1);   //Choose (randomly) one of two trade of specific stock.
                            System.out.println("\n\n" + currentTrade.getDate() +
                                                "\nGiven symbol of stock: " + newStock.getSymbol() +
                                                "\nQuantity: " + currentTrade.getQuantity() +
                                                "\nIs " + currentTrade.getIndicator() +
                                                "\nPrice: " + currentTrade.getTradePrice());
                            break;

                        case 4:

                            /**Compute the price of stock for all trade in past 15 min  */
                            double stockPrice = stockServiceImpl.calculateStockPriceTime(newStock, 15);
                            System.out.println("\n\nThe stock price in the 15 last minute is: " + stockPrice);
                            break;

                        case 5:

                            printActions();
                            break;

                        default:

                            System.out.println("Wrong input, press 1 to 5...\n");
                    }

                    break;

                case 2:

                    /**    Calculate the GBCE All Share Index using
                     * the geometric mean of prices for all stocks  */

                    double goeMeans = stockServiceImpl.calculateGeoMean();
                    System.out.println("The Geometric mean of all stocks is: " + goeMeans);
                    break;

                default:

                    System.out.println("Wrong input, press 1 or 2...\n");
            }
        }
    }

    public static Stock chooseStock() {
        do {
            System.out.println("\nChoose stock:\n" +
                    " TEA stock.\n" +
                    " POP stock.\n" +
                    " ALE stock.\n" +
                    " GIN stock.\n" +
                    " JOE stock.\n");
            String press;
            Stock myStock;
            try {
                press = scanner.readLine();
                myStock = DataBase.retrieveStock(press);
                return myStock;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("\nYou can press only the given symbol, please try again...\n\n");
            }
        } while (true);
    }

    public static int enterAction() {
        System.out.println("\n...Enter action: ");
        do {
            try {
                int action = Integer.parseInt(scanner.readLine());
            } catch (IOException e) {
                System.out.println("\nPlease try again...\n");
            } catch (WrongNumberException m) {
                System.out.println(m + "\nPlease try again...\n");
            } catch (NumberFormatException n) {
                System.out.println("\nPlease try again...\n");
            }
        } while (true);
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("1  -to calculate the dividend yield\n" +
                "2  -to calculate the P/E Ratio\n" +
                "3  -to record a trade\n" +
                "4  -to calculate Stock Price based on trades recorded in past 15 minutes\n" +
                "5  -to to show the available actions.");
    }
}
