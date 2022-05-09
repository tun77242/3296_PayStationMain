package edu.temple.cis.paystation;

public class LinearRateStrategy1 implements RateStrategy{
    @Override
    public int calculateTime(int coinValue) {

        return ((coinValue * 2) / 5);
    }
}
