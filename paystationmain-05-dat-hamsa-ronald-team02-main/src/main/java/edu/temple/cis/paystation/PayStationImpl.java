package edu.temple.cis.paystation;
import java.util.*;

/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStationImpl implements PayStation {

    private int insertedSoFar, timeBought, totalMoney;
    private Map<Integer, Integer> coinMap;
    private RateStrategy rateStrategy;

    // Constructor initializes instance variables
    public PayStationImpl() {
        this.coinMap = new HashMap<>();
        rateStrategy = new LinearRateStrategy1();
    }

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {

        switch (coinValue) {
            case 5:
                coinMap.put(5, coinMap.getOrDefault(5, 0) + 1);
                break;
            case 10:
                coinMap.put(10, coinMap.getOrDefault(10, 0) + 1);
                break;
            case 25:
                coinMap.put(25, coinMap.getOrDefault(25, 0) + 1);
                break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }

        /*
         * getOrDefault checks if a given key is present in a map
         * @returns the value if it exists, or the 'defaultValue' if it does not
         * add 1 to whatever the result of getOrDefault is and place that value in the map
         */
        //coinMap.put(coinValue, coinMap.getOrDefault(coinValue, 0) + 1);

        insertedSoFar += coinValue;
        timeBought = rateStrategy.calculateTime(insertedSoFar);
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        totalMoney += insertedSoFar;
        reset();
        return r;
    }

    @Override
    public Map<Integer, Integer> cancel()
    {
        Map<Integer, Integer> tempMap = coinMap;
        coinMap = new HashMap<>();
        reset();
        return tempMap;
    }

    private void reset() {
        timeBought = insertedSoFar = 0;
        coinMap.clear();
    }

    @Override
    public int empty()
    {
        int temp = totalMoney;
        totalMoney = 0;
        return temp;
    }

    @Override
    public void setRateStrategy(int value) {

    }

    public void setRateStrategy(RateStrategy rateStrategy){

        this.rateStrategy = rateStrategy;
    }
}
