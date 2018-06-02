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
    public static TradeServiceImpl tradeServiceImpl = new TradeServiceImpl();
    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        boolean quit = false;
        while (!quit) {

            int firstAction;
            System.out.println("Press 1 for stock trade or 2 for calculating the GBCE All Shares.\n");
            firstAction = Integer.parseInt(scanner.readLine());

            switch (firstAction) {

                case 1:

                    /**	For a given stock   */

                    Stock newStock = chooseStock();

                    int action = enterAction();

                    switch (action) {
                        case 0:

                            /** Quit from application  */
                            quit = true;
                            System.out.println("\n\nShout-down application...");
                            break;
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
                                System.out.println("Impossibility.");
                            }
                            break;
                        case 3:

                            /** Record a trade  */
                            System.out.println("\n\n" + newStock. + "\nGiven symbol of stock: " + stockSymbol + "\nQuantity: " +
                                    myQuantity + "\nIs " + indicator1 + "\nPrice: " + myTradePrice);
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
                            System.out.println("Wrong input...\n");
                    }

                    break;

                case 2:

                    /** 	Calculate the GBCE All Share Index using
                     * the geometric mean of prices for all stocks  */

                    double goeMeans = stockServiceImpl.calculateGeoMean();
                    System.out.println("The Geometric mean of all stocks is: " + goeMeans);
                    break;
                default:
                    System.out.println("Wrong input...\n");
            }
        }
    }

//    public static Trade findTrade() throws IOException {
//        String indicator;
//        Trade newTrade;
//
//        do {
//            System.out.println("Press b (buy) if your trade is buy else press s (sell): ");
//            indicator = scanner.readLine();
//            //Restrict input...
//            if ("s".equals(indicator) || "b".equals(indicator)) {
//                break;
//            } else {
//                System.out.println("Wrong input, press b or s...");
//            }
//        } while (true);
//
//        return newTrade;
//    }

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
                System.out.println("\nYou can press only numbers, please try again...\n\n");
            }
        } while (true);
    }

    public static int enterAction() {
        System.out.println("\n...Enter action: ");
        do {
            printActions();
            try {
                int action = Integer.parseInt(scanner.readLine());
                if (action >= 0 && action <= 6) {
                    return action;
                } else {
                    System.out.println("Please try again...");
                }
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
        System.out.println("0  -to shutdown\n" +
                "1  -to calculate the dividend yield\n" +
                "2  -to calculate the P/E Ratio\n" +
                "3  -to record a trade\n" +
                "4  -to calculate Stock Price based on trades recorded in past 15 minutes\n" +
                "5  -to to show the available actions.");
    }
}
