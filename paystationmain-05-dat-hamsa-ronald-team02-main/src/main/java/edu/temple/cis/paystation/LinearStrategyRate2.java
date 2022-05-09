package edu.temple.cis.paystation;

public class LinearStrategyRate2 implements RateStrategy{
    @Override
    public int calculateTime(int coinValue) {

        return (coinValue / 5);
    }
}
