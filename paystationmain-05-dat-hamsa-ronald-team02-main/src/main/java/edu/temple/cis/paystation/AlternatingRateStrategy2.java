package edu.temple.cis.paystation;
import java.util.Calendar;
public class AlternatingRateStrategy2 implements RateStrategy {

    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    int timeBought;

    @Override
    public int calculateTime(int moneyInserted) {
        RateStrategy rate;

        // Free for weekend
        if (day == 1 || day == 7){
            System.out.println("This is a Free Service for Weekend. Enjoy!");
        }
        else {
            rate = new LinearRateStrategy1();
            timeBought = rate.calculateTime(moneyInserted);
        }
        return timeBought;

    }

    public void setDay(int whichDay){
        day = whichDay;
    }
}
