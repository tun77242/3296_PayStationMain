package edu.temple.cis.paystation;

public class ProgressiveRateStrategy implements RateStrategy{
    @Override
    public int calculateTime(int valueOfMoneyInserted) {
        int time = 0;
        if(valueOfMoneyInserted >= 350){
            valueOfMoneyInserted = valueOfMoneyInserted - 350;
            time = (valueOfMoneyInserted / 5) + 120;
        }
        else if(valueOfMoneyInserted >= 150){
            valueOfMoneyInserted = valueOfMoneyInserted - 150;
            time = ((valueOfMoneyInserted * 3) / 10) + 60;
        }
        else{
            time = (valueOfMoneyInserted * 2) / 5;
        }

        return time;
    }
}
