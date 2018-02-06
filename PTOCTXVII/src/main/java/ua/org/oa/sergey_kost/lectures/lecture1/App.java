package ua.org.oa.sergey_kost.lectures.lecture1;

public class App {

    public static void main(String[] args) {

        Date date = new Date(28, 07, 2016);
        date.printFullDate();
        System.out.println("Inputted year have " + date.getDayOfYear() + " days");
        System.out.println("The week's day of your date is " + date.getDayOfWeek());
        System.out.println("This month have " + date.getDayOfMonth() + " days");
        System.out.println("There are " + date.daysBetween() + " days between date you inputted and today");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("*******************Task 2:***********************");

        Auto auto1 = new Auto("Mazda", 2019, 280, true, 18852.41) {
            @Override
            public String toString() {
                return ("Mark is " + getMark() + ", that has " + getMaxSpeed() + "km per hour and you can buy it for " + getPrice() + "$.");
            }
        };
        Auto auto2 = new Auto("VAZ-2101", 600, 100, false, 300) {
            @Override
            public String toString() {
                String mes;
                if (getTransmission() == false) {
                    mes = "This car has manual-transmission ";
                } else
                    mes = "This car has auto-transmission ";
                return mes + " and it cost " + getPrice() + " mark of this car is " + getMark();
            }
        };

        Auto auto3 = new Auto("ZIL", 3000, 150, false, 700) {
            @Override
            public String toString() {
                return getMark() + " is truck with " + getWeight() + " that cost " + getPrice();
            }
        };
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^1-st auto: ^^^^^^^^^^^^^^^^^^^^^^^^" +
                "\n" + auto1);
        System.out.println("^^^^^^^^^^^^^^^^^^2-nd auto: ^^^^^^^^^^^^^^^^^^^^^^^^" +
                "\n" + auto2);
        System.out.println("^^^^^^^^^^^^^^^^^^3-rd auto: ^^^^^^^^^^^^^^^^^^^^^^^^" +
                "\n" + auto3);

    }
}
