package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    /*
     * get the today date
     * @return the date with type local date
     */
    public static LocalDate getTheCurrentDate() {
        // Current date
        LocalDate currentDate = LocalDate.now();
        return currentDate;
    }

    /*
     * get a specific date
     * @param year      specific year
     * @param month     specific month
     * @param day       specific day
     * @return the date with type local date
     */
    public static LocalDate getSpecificDate(int year, int month, int day) {
        // Current date
        LocalDate specificDate = LocalDate.of(year, month, day);
        return specificDate;
    }

    /*
     * get the current time
     * @return the time with type local time
     */
    public static LocalTime getTheCurrentTime() {
        // Current time
        LocalTime currentTime = LocalTime.now();
        return currentTime;
    }

    /*
     * get a specific time
     * @param hour      specific hour
     * @param min       specific minute
     * @param sec       specific second
     * @return the time with type local time
     */
    public static LocalTime getTheSpecificTime(int hour, int min, int sec) {
        // Current time
        LocalTime specificTime = LocalTime.of(hour, min, sec);
        return specificTime;
    }

    /*
     * make a specific format for the date
     * @param date          date with type local date
     * @param format        date formatter with type string
     * @return the date with the format in string
     */
    public static String dateFormatter(LocalDate date, String format) {
        // Function call
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String dateFormat = formatter.format(date);
        return dateFormat;

    }

    /*
     * make a specific format for the time
     * @param time          time with type local time
     * @param format        time formatter with type string
     * @return the time with the format in string
     */
    public static String timeFormatter(LocalTime time, String format) {
        // Function call
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String timeFormat = formatter.format(time);
        return timeFormat;
    }

    /*
     * check if the year is a leap year
     * @return boolean true or false
     */
    public static boolean isTheYearLeap() {
        LocalDate today = getTheCurrentDate();
        // Checking if a year is a leap year
        boolean isLeapYear = today.isLeapYear();
        System.out.println("Is " + today.getYear() + " a leap year? " + isLeapYear);
        return isLeapYear;
    }
}
