package ua.org.oa.sergey_kost.lectures.lecture1;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class Date {

    private Day day;
    private Month month;
    private Year year;


    public Date(int day, int month, int year) {
        this.day = new Day(day);
        this.month = new Month(month);
        this.year = new Year(year);
    }

    public void printFullDate() {
        System.out.println("Date: " + day.dayNumber + " " + month.monthName + " " + year.yearNumber);
    }

    public String getDayOfWeek() {
        LocalDate localDate = LocalDate.of(year.yearNumber, month.monthNumber, day.dayNumber);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return DayOfWeek.valueOf(dayOfWeek.toString()).name;
    }

    public int getDayOfYear() {
        return year.dayOfYear;
    }

    public int getDayOfMonth() {
        int dayOfMonth = 0;
        switch (month.monthNumber) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayOfMonth = 30;
                break;
            case 2:
                if (year.bissexile) {
                    dayOfMonth = 29;
                } else {
                    dayOfMonth = 28;
                }
                break;
        }
        return dayOfMonth;
    }

// Working with some bugs!!!
    public int daysBetween() {
        LocalDate date1 = LocalDate.of(year.yearNumber, month.monthNumber, day.dayNumber);
        Period period = Period.between(date1, LocalDate.now());
        return period.getDays();
    }

    public class Year {
        private int yearNumber;
        int dayOfYear = 365;
        boolean bissexile;

        Year(int year) {
            yearNumber = year;
            if (yearNumber % 4 == 0) {
                dayOfYear = dayOfYear + 1;
            }
        }
    }

    public class Month {
        private int monthNumber;
        private String monthName;

        Month(int month) {
            this.monthNumber = month;
            for (MonthName monthName : MonthName.values()) {
                if (monthName.monthNumber == month) {
                    this.monthName = monthName.name;
                }
            }
        }
    }

    public class Day {
        private int dayNumber;

        Day(int day) {
            this.dayNumber = day;
        }
    }


}