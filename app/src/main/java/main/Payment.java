package main;

import java.util.logging.Logger;

public class Payment {
    public static final int WEEKDAY_CHARGE = 200;
    public static final int WEEKEND_CHARGE = 250;
    private int money;
    private final double totalCharge;

    public Payment(Discount discount, String dateTime) {

        String week = InputNormalization.extractWeek(dateTime);
        switch (week) {
            case "週一":
            case "週二":
            case "週三":
            case "週四":
            case "週五":
                money = WEEKDAY_CHARGE;
                break;
            case "週六":
            case "週日":
                money = WEEKEND_CHARGE;
                break;
            default:
                break;
        }

        totalCharge = money * discount.getDiscountRate();
    }
    public int getMoney() { return money; }
    public String print() {
        String display = "Please pay $" + (int) totalCharge + ".";
        Logger.getGlobal().info(display);
        return display;
    }

    public double getTotalCharge(){
        return totalCharge;
    }
}
