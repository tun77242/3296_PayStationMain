package edu.temple.cis.paystation;
import java.util.Scanner;
import java.util.Map;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class PaystationMain {
    public static void main(String[] args) {
        PayStationImpl ps = new PayStationImpl();
        int numb;
        String options = "\n Enter your choice:" +
                "\n1/ Deposit" +
                "\n2/ Display" +
                "\n3/ Buy Ticket" +
                "\n4/ Cancel" +
                "\n5/ Empty" +
                "\n6/ Change Strategy Rate" +
                "\nEnter the number of your choice: ";
        do {
            Scanner pick = new Scanner(System.in);
            System.out.print(options);
            numb = pick.nextInt();
            switch (numb) {
                case 1:
                    System.out.print("Deposit amount: ");
                    int deposit = pick.nextInt();
                    try {
                        ps.addPayment(deposit);
                    } catch (IllegalCoinException e) {
                        System.out.println("Invalid entered amount");
                    }
                    break;
                case 2:
                    System.out.println("Current time bought: " + ps.readDisplay());
                    break;
                case 3:
                    Receipt rep = ps.buy();
                    System.out.println("Your current purchase is :" + rep.value());
                    System.out.print("Press 1 to continue and 2 to quit:");
                    int answer = pick.nextInt();
                    if (answer == 1) {
                        numb = 6;
                    } else {
                        break;
                    }
                case 4:
                    Map<Integer, Integer> cancel = ps.cancel();
                    System.out.println("Transaction is canceled. Please take your return");
                    if (!cancel.isEmpty()) {
                        for (Integer coin : cancel.keySet())
                            System.out.println("Type: " + coin + "Quantity: " + cancel.get(coin));
                    } else {
                        break;
                    }
                case 5:
                    ps.empty();
                    System.out.println("Clear the history and Quit!");
                    break;
                case 6:
                    System.out.println("Strategy Option:" +
                            "\n0/ ALPHATOWN" +//Linear Rate Strategy 1
                            "\n1/ DELTATOWN" +//Linear Rate Strategy 2
                            "\n2/ BETATOWN" +//Progressive Rate Strategy
                            "\n3/ GAMMATOWN" +//Alternating Rate Strategy 1
                            "\n4/ OMEGATOWN");// Alternating Rate Strategy 2
                    System.out.print("Your Choice: ");
                    int strategy = pick.nextInt();
                    while (strategy > 4 || strategy < 0) {
                        System.out.println("Please enter a valid strategy or 9 to exit:");
                        strategy = pick.nextInt();
                        if (strategy == 9) {
                            break;
                        }
                    }
                    if (strategy == 3 || strategy == 4) {
                        Calendar c = new GregorianCalendar();
                        int current = c.get(Calendar.DAY_OF_WEEK);
                        if (current == 1 || current == 7) {
                            System.out.println("WEEKEND strategy");
                        }
                    }
                    switch (strategy) {
                        // Create change strategy method in Paystation IMP
                        case 0:
                            ps.setRateStrategy(new LinearRateStrategy1());
                            break;

                        case 1:
                            ps.setRateStrategy(new LinearStrategyRate2());
                            break;

                        case 2:
                            ps.setRateStrategy(new ProgressiveRateStrategy());
                            break;
                        case 3:
                            ps.setRateStrategy(new AlternatingRateStrategy());
                            break;
                        case 4:
                            ps.setRateStrategy(new AlternatingRateStrategy2());
                            break;
                        default:
                            break;
                    }
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
        while (numb != 6);
        System.out.println("Thanks for using our Pay Station!");
    }
}
