package pl.jcommerce.exercises.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.*;

/**
 * Java 8 Date API exercises
 * Very important change
 *
 * @author Michal Orlowski
 */
public class DateApiExercise {

    public static void main(String[] args) {
        //exercise1(2014);
        //exercise2();
        //exercise3(DayOfWeek.MONDAY, 2014, Month.AUGUST);
        //exercise4();
        exercise5();
    }

    /**
     * For given year return lenght of each month
     */
    private static void exercise1(Integer year) {

        final SortedMap<YearMonth, Integer> monthLengths = new TreeMap<>();
        for (final Month month : Month.values()) {
            final YearMonth yearMonth = YearMonth.of(year, month);
            monthLengths.put(yearMonth, yearMonth.lengthOfMonth());
        }

        System.out.println(monthLengths);
    }

    /**
     *
     * Return next sunday date (with zoned date time), truncated to minutes
     *
     */
    private static void exercise2() {
        ZonedDateTime today = ZonedDateTime.now();

        System.out.println(today.with(
                TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).truncatedTo(
                ChronoUnit.MINUTES));
    }

    /**
     * Day of week counter for specified year and month
     *
     * @param year
     * @param month
     */
    private static void exercise3(DayOfWeek dow, Integer year, Month month) {
        List<LocalDate> dayOfweek = new ArrayList<>();

        LocalDate date = LocalDate.of(year, month, 1).with(
                TemporalAdjusters.firstInMonth(dow));

        Month monthForDate = date.getMonth();
        while (monthForDate == month) {
            dayOfweek.add(date);
            date = date.with(TemporalAdjusters.next(dow));
            monthForDate = date.getMonth();
        }

        System.out.println(dayOfweek);
    }

    /**
     * Write own Temporal Adjuster which will return next working day
     */
    private static void exercise4() {
        LocalDate date = LocalDate.of(2014, 9, 27);
        date = date.with(new NextWorkingDay());
        System.out.println(date);
    }

    /**
     * Custom Temporal Adjuster
     */
    private static class NextWorkingDay implements TemporalAdjuster {

        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }

    /**
     * Implement own custom date formatter
     */
    private static void exercise5() {
        LocalDate date = LocalDate.of(2014, 9, 27);

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" -> ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ENGLISH);

        System.out.println(date.format(complexFormatter));
    }

}
