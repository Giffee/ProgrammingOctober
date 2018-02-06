package ua.org.oa.sergey_kost.lectures.lecture1;

public enum DayOfWeek {
    MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);

    int dayNumber;
    String name;

    DayOfWeek(int dayNumber) {
        this.dayNumber = dayNumber;
        this.name = name().substring(0,1).toUpperCase().concat(name().substring(1).toLowerCase());
    }

}
