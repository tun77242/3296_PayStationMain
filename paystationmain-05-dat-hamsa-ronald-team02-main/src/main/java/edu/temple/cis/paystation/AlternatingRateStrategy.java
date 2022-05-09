package edu.temple.cis.paystation;
import java.util.Calendar;
public class AlternatingRateStrategy implements RateStrategy {
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    int timeBought;

    @Override
    public int calculateTime(int moneyInserted) {
        RateStrategy rate;

        //liner1 for weekend
        if (day == 1 || day == 7){
            rate = new LinearRateStrategy1();
        }
        else
        {
            rate = new ProgressiveRateStrategy();
        }

        timeBought = rate.calculateTime(moneyInserted);
        return timeBought;

    }

    public void setDay(int whichDay){
        day = whichDay;
    }
}
