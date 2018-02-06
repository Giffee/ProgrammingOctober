package ua.org.oa.sergey_kost.lectures.lecture1;

public enum MonthName {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7),
    AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

    int monthNumber;
    String name;

    MonthName(int monthNumber) {
        this.monthNumber = monthNumber;
        this.name = name().substring(0,1).toUpperCase().concat(name().substring(1).toLowerCase());
    }
}
