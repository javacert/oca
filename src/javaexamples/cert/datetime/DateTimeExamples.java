package javaexamples.cert.datetime;

// Note that these exist in the java.time package
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

// Valid classes in the java.date package for OCA are:
// - LocalDate
// - LocalTime
// - LocalDateTime
// - DateTimeFormatter
//      --> MMMM (M - 1, MM - 01, MMM - Jan, MMMM - January) - Month
//      --> dd - (d - date, dd - include leading zero) - Date in the month, the more ds you have, the more verbose
//      --> yyyy (y - year, yy - two digit year, yyyy - four digit year)
//      --> hh (h - hour, hh - include the leading zero)
//      --> mm - represents the minute!!! WATCH FOR THIS and don't mix up with MMMM!!!
//          --> ofLocalizedDate, ofLocalizedDateTime, orLocalizedTime
public class DateTimeExamples {

    public static void main(String[] args) {

        localDateExamples();
        localDateTimeExamples();
        zoneDateTimeExamples();
        trickLocalDateExampleA();
        trickLocalDateExampleB();
        periodExamples();
        trickPeriodExample();
        invalidPeriodExample();
        smallestTimeInLocalTime();
    }

    private static void localDateExamples() {

        // Error:(25, 31) java: LocalDate(int,int,int) has private access in java.time.LocalDate
        // LocalDate localDate = new LocalDate(2015, 5, 21); --> Can't do this!

        LocalDate localDate = LocalDate.of(2015, 5, 21);
        System.out.println(localDate); // 2015-05-21
        localDate.plusDays(3);
        System.out.println(localDate); // 2015-05-21 - remember plusDays returns a new LocalDate object
        LocalDate avoidTheTrick = localDate.plusDays(3);
        System.out.println(avoidTheTrick); // 2015-05-24 - remember plusDays returns a new LocalDate object
    }

    private static void localDateTimeExamples() {

        LocalDateTime ldt = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        ldt.minus(p);
        // p.minus(ldt); // Make sure and access in correct way

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(ldt.format(dtf)); //11:22
        dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(ldt.format(dtf)); //11:22:33
        //dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        //System.out.println(ldt.format(dtf)); //Exception in thread "main" java.time.DateTimeException: Unable to extract value: class java.time.LocalDateTime
        //dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        //System.out.println(ldt.format(dtf)); //Exception in thread "main" java.time.DateTimeException: Unable to extract value: class java.time.LocalDateTime
        //ZonedDateTime and OffsetDateTime should be provided when formatting using localized FormatStyles.
    }

    private static void zoneDateTimeExamples() {

        LocalDateTime ldt = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        ldt.minus(p);
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        zdt.minus(p);
        dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        System.out.println(zdt.format(dtf)); //11:22:33 BST
        dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        System.out.println(zdt.format(dtf)); //11:22:33 o'clock BST
    }

    private static void trickLocalDateExampleA() {
        LocalDate xmas = LocalDate.of(2016, 12, 25);
        xmas.plusDays(-1); // Remember LocalDate is immutable and will always return a new LocalDate Object!!!
        System.out.println(xmas.getDayOfMonth()); // 25

        LocalDate xmasEve = xmas.plusDays(-1);
        System.out.println(xmasEve.getDayOfMonth()); // 24
    }

    private static void trickLocalDateExampleB() {
        LocalDate nye = LocalDate.of(2017, 01, 01);

        LocalDate almostNye = nye.plusDays(-1);
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        System.out.println(almostNye.format(dtf)); // 31/12/16

        dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(almostNye.format(dtf)); // 31 December 2016

        // Both of the following would result in an UnsupportedTemporalTypeException
        dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        System.out.println(almostNye.format(dtf)); // UnsupportedTemporalTypeException: Unsupported field: HourOfDay
    }

    private static void periodExamples() {
        // There is NO ofTime
        Period periodA = Period.ofDays(1);
        Period periodB = Period.ofWeeks(1);
        Period periodC = Period.ofMonths(1);
        Period periodD = Period.ofYears(1);
        Period periodE = Period.of(1, 2, 3);
        Period periodF = Period.between(LocalDate.of(2016, 12, 22), LocalDate.of(2017, 11, 11));
        Period periodG = Period.parse("P2Y"); // Period.ofYears(2)
        Period periodH = Period.parse("P3M"); // Period.ofMonths(3)
        Period periodI = Period.parse("P4W"); // Period.ofWeeks(4)
        Period periodJ = Period.parse("P5D"); // Period.ofDays(5)
        Period periodK = Period.parse("P2Y2M3W4D"); // Period.of(2, 2, 25)
        Period periodL = Period.parse("P-2Y2M"); // Period.of(-2, -2, 0)
    }

    private static void trickPeriodExample() {
        // The following are not the same Period of time!
        Period period1 = Period.ofWeeks(1).ofDays(3);
        Period period2 = Period.ofDays(10);

        // As you can see below, Period always returns a new Period instance.
        // period1 will therefore be only 3 days.

        //public static Period ofWeeks(int weeks) {
        //    return create(0, 0, Math.multiplyExact(weeks, 7));
        //}

        //private static Period create(int years, int months, int days) {
        //    if ((years | months | days) == 0) {
        //        return ZERO;
        //    }
        //    return new Period(years, months, days);
        //}
    }

    private static void invalidPeriodExample() {

        // This works...
        DateTimeFormatter validFormat = DateTimeFormatter.ofPattern("mm-dd-yyyy");
        LocalDateTime ldt = LocalDateTime.of(2017, 1, 1, 1, 50, 1,1);
        System.out.println(validFormat.format(ldt.minus(Period.ofDays(1)))); // 50-31-2016 - notice the 50 which is the minute!

        // But the following does not...
        LocalDate newYears =  LocalDate.of(2017, 1, 1);
        Period period = Period.ofDays(1);

        // Remember that mm is minute and does not apply to LocalDate
        DateTimeFormatter format = DateTimeFormatter.ofPattern("mm-dd-yyyy");

        // Throws an UnsupportedTemporalTypeException: Unsupported field: HourOfDay
        System.out.println(format.format(newYears.minus(period)));
    }

    private static void smallestTimeInLocalTime() {
        // (hour, minute, second, nanoOfSecond) = nano second
        LocalTime.of(1, 2, 3, 4);
    }
}
