package javaexamples.cert.datetime;

import java.time.*;

// Important thing to remember here is that Period is used to manipulate dates in terms of days, months, and years,
// while Duration is used to manipulate dates in terms of hours, minutes, and seconds.
// Therefore, Period doesn't mess with the time component of the date while Duration may changed the time component
// if the date is close to the DST  boundary.

// Durations and periods differ in their treatment of daylight savings time when added to ZonedDateTime.
// A Duration will add an exact number of seconds, thus a duration of one day is always exactly 24 hours.
// By contrast, a Period will add a conceptual day, trying to maintain the local time.
public class ZonedDateTimeExample {

    public static void main(String[] args){
        zonedDateTimeExample();
    }

    private static void zonedDateTimeExample() {
        LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

        ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        date = date.plus(Duration.ofDays(1));
        System.out.println(date); // 2015-11-01T09:00-05:00[US/Eastern]

        date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        date = date.plus(Period.ofDays(1));
        System.out.println(date); // 2015-11-01T10:00-05:00[US/Eastern]
    }
}
