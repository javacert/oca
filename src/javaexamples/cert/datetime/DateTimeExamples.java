package javaexamples.cert.datetime;

// Note that these exist in the java.time package
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

// Valid classes in the java.date package for OCA are:
// - LocalDate
// - LocalTime
// - LocalDateTime
// - DateTimeFormatter
//      --> MMMM (M - 1, MM - 01, MMM - Jan, MMMM - January) - Month
//      --> dd - (d - date, dd - include leading zero) - Date in the month, the more ds you have, the more verbose
//      --> yyyy (y - year, yy - two digit year, yyyy - four digit year)
//      --> uuuu (y - year, yy - two digit year, yyyy - four digit year) - safer than yyyy
//      --> hh (h - hour, hh - include the leading zero)
//      --> mm - represents the minute!!! WATCH FOR THIS and don't mix up with MMMM!!!
//          --> ofLocalizedDate, ofLocalizedDateTime, ofLocalizedTime

//      Symbol  Meaning             Presentation  Examples
//      ------  -------             ------------  -------
//      G       era                 text          AD; Anno Domini; A
//      u       year                year          2004; 04
//      y       year-of-era         year          2004; 04
//      M       month-of-year       number        01
//      D       day-of-year         number        189
//      d       day-of-month        number        10
//      E       day-of-week         text          Tue; Tuesday; T
//      H       hour (00-23)        number        00, 01..23.
//      h       hour (01-12 AM/PM)  number        01, 02..12.
//      k       hour (01-24)        number        01, 02..24.
//      m       minute              number        01, 59
//      s       seconds             number        01, 59
//      S       nano-seconds        number        12345678 (SSSSSSSS)

// An epoch day is 0 at 1970-01-01

// ChronoUnit - A standard set of date periods units.
// This set of units provide unit-based access to manipulate a date, time or date-time.
// The standard set of units can be extended by implementing TemporalUnit.
// LocalTime is 24hrs, so use 0-23 to define the hours. Any values out of range will throw a runtime exception.
// LocalDate parse method must be in the format "9999-99-99"
// LocalTime parse method must be in the format "15:08:23"
// LocalDateTime - T separates Date + Time and must be in the format "2050-06-05T14:00:00"

// Common LocalDate methods:
//  - getDayOfMonth, getDayOfWeek, getDayOfYear, getMonth (e.g. JANUARY), getMonthValue (e.g. 3), getYear (get are not the plural form)
//  - isAfter, isBefore
//  - minusDays, minusMonths, minusWeeks, minusYears
//  - plusDays, plusMonths, plusWeeks, plusYears
//  - withDayOfMonth, withDayOfYear, withMonth, withYear (takes current LocalDate and returns a new days withXXXX)

// LocalDateTime methods similar to LocalDate.

// LocalDateTime's toString method generates the String in ISO 8601 format - equivalent to DateTimeFormatter.ISO_DATE_TIME

// Common LocalTime methods:
//  - getHour, getMinute, getSecond, getNano (no plural for get methods)
//  - minusHours, minusMinutes, minusSeconds, minusNanos
//  - withHour, withMinute, withSecond, withNano
// Unlike the getXXX() methods, minusXXX() methods use the plural form: getHour() versus minusHours(), getMinute()
// versus minusMinutes(), getSecond() versus minusSeconds(), and getNano() versus minusNanos().

// Period / Duration have static methods and therefore do not support aggregated chaining.
// Most of the methods of LocalDate (as well as LocalTime and LocalDateTime) return an object of the same class.
// This allows you to chain the calls as done in this question. However, these  methods return a new object each time
// but aggregate the change from the previous method in the chain. Period / Duration will simply use the last change in
// the chain.
public class DateTimeExamples {

    public static void main(String[] args) {

        localTimeExamples();
        localDateExamples();
        localDateTimeExamples();
        zoneDateTimeExamples();
        trickLocalDateExampleA();
        trickLocalDateExampleB();
        periodExamples();
        chainingPeriodExample();
        chainingLocalDateMethods();
        isoFormattingExamples();
        isoZonedFormattingExamples();
        trickPeriodExample();
        invalidPeriodExample();
        smallestTimeInLocalTime();
        chronoUnitExamples();
        formattingExamples();
        parseExamples();
        atDateExamples();
        invalidLocalDateAssignment();
    }

    private static void localTimeExamples() {
        LocalTime lt = LocalTime.of(22, 10);
        System.out.println(lt);
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

        LocalDate localDateYearDay = LocalDate.ofYearDay(2015, 363);
        System.out.println("ofYearDay " + localDateYearDay); // ofYearDay 2015-12-29
        LocalDate localDateEpochDay = LocalDate.ofEpochDay(123456);
        System.out.println("ofEpochDay " + localDateEpochDay); // ofEpochDay 2308-01-06

        System.out.println(localDateYearDay.lengthOfMonth()); // 31
        System.out.println(localDateYearDay.lengthOfYear()); // 365

        LocalDate localDateOfYearDay = LocalDate.ofYearDay(2016, 22);
        System.out.println(localDateOfYearDay); // 2016-01-22
        System.out.println(localDateOfYearDay.getDayOfMonth()); // 22
        System.out.println(localDateOfYearDay.getMonthValue()); // 1 - 22nd day is in January
        System.out.println(localDateOfYearDay.getMonth()); // JANUARY
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

        //LocalDateTime greatDay = LocalDateTime.parse("2015-01-01"); // java.time.format.DateTimeParseException: Text '2015-01-01' could not be parsed at index 10
        LocalDateTime greatDay = LocalDateTime.parse("2015-01-01T17:13:50");
        String greatDayStr = greatDay.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(greatDayStr); // 2015-01-01T17:13:50
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

        LocalDate ld = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = ld.plus(Period.of(0, 1, 1));
        System.out.println(ld2); // 2015-02-02
    }

    private static void chainingPeriodExample() {
        // Important to remember that with Period you cannot chain in the following way so it adds all the values,
        // it simply takes the last value in the train, which is ofDays(1) (ofXXX are static methods of Period class)
        LocalDate ld = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = ld.plus(Period.ofYears(1).ofMonths(1).ofWeeks(1).ofDays(1));
        System.out.println(ld2); // 2015-01-02
    }

    private static void chainingLocalDateMethods() {
        // Most of the methods of LocalDate (as well as LocalTime and LocalDateTime) return an object of the same class.
        // This allows you to chain the calls as done in this question. However, these  methods return a new object.
        // They don't modify the object on which the method is called.
        LocalDate dt = java.time.LocalDate.parse("2015-01-01").minusMonths(1).minusDays(1).plusYears(1);
        System.out.println(dt); // 2015-11-30
    }

    public static void isoFormattingExamples() {

        // The following output fine:
        System.out.println(LocalTime.of(10,10,10).format(DateTimeFormatter.ISO_TIME)); // 10:10:10
        System.out.println(LocalDate.of(2015, Month.JANUARY, 01).format(DateTimeFormatter.ISO_DATE)); // 2015-01-01
        System.out.println(LocalDateTime.of(2015, Month.JANUARY, 01, 01, 01, 01).format(DateTimeFormatter.ISO_DATE_TIME)); // 2015-01-01T01:01:01

        // There work! You can format just for time or date in LocalDateTime
        System.out.println(LocalDateTime.of(2015, Month.JANUARY, 01, 01, 01, 01).format(DateTimeFormatter.ISO_TIME)); // 01:01:01
        System.out.println(LocalDateTime.of(2015, Month.JANUARY, 01, 01, 01, 01).format(DateTimeFormatter.ISO_DATE)); // 2015-01-01

        // The following throw runtime exceptions - make sure and match the ISO type to the object type!
        System.out.println(LocalTime.of(10,10,10).format(DateTimeFormatter.ISO_DATE)); // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: Year
        System.out.println(LocalDate.of(2015, Month.JANUARY, 01).format(DateTimeFormatter.ISO_DATE_TIME)); // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
    }

    public static void isoZonedFormattingExamples() {
        // Note that LocalDateTime class does not contain Zone information but ISO_ZONED_DATE_TIME requires it.
        // DateTimeException extends RuntimeException, so it need not be caught or declared in the throws clause.
        // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
        LocalDateTime ldt = LocalDateTime.of(2015, 1, 1, 1, 1,1);
        System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ldt));
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

    private static void chronoUnitExamples() {

        LocalDateTime oldDate = LocalDateTime.of(1982, Month.AUGUST, 31, 10, 20, 55);
        LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

        System.out.println(oldDate);    // 1982-08-31T10:20:55
        System.out.println(newDate);    // 2016-11-09T10:21:56

        // count between dates
        long years = ChronoUnit.YEARS.between(oldDate, newDate);
        long months = ChronoUnit.MONTHS.between(oldDate, newDate);
        long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
        long days = ChronoUnit.DAYS.between(oldDate, newDate);
        long hours = ChronoUnit.HOURS.between(oldDate, newDate);
        long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
        long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
        long millis = ChronoUnit.MILLIS.between(oldDate, newDate);
        long nano = ChronoUnit.NANOS.between(oldDate, newDate);

        System.out.println(years + " years");       // 34 years
        System.out.println(months + " months");     // 410 months
        System.out.println(weeks + " weeks");       // 1784 weeks
        System.out.println(days + " days");         // 12489 days
        System.out.println(hours + " hours");       // 299736 hours
        System.out.println(minutes + " minutes");   // 17984161 minutes
        System.out.println(seconds + " seconds");   // 1079049661 seconds
        System.out.println(millis + " millis");     // 1079049661000 millis
        System.out.println(nano + " nano");         // 1079049661000000000 nano

        LocalTime lt = LocalTime.of(22, 10);
        lt = lt.truncatedTo(ChronoUnit.HALF_DAYS); // last half day of current time passed. It's either 12:00 or 00:00, so appears to be closest in the past.
        System.out.println(lt); // 12:00

        lt = LocalTime.of(11, 30);
        lt = lt.truncatedTo(ChronoUnit.HALF_DAYS); // Unit that represents the concept of half a day, as used in AM/PM.
        System.out.println(lt); // 00:00

        lt = LocalTime.of(2, 2, 15);
        System.out.println(lt.getLong(ChronoField.valueOf("MINUTE_OF_DAY"))); // 122 (2*60) + 2 = 122
        System.out.println(lt.getLong(ChronoField.valueOf("SECOND_OF_DAY"))); // 7335
        System.out.println(lt.getLong(ChronoField.valueOf("SECONDOFDAY"))); // No output, invalid chrono
    }


    private static void formattingExamples() {
        LocalDateTime ldt = LocalDateTime.of(2015, 5, 10, 11, 22, 33);

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        // Notes:
        // Can only have maximum 2 d - java.lang.IllegalArgumentException: Too many pattern letters: d
        // Can only have maximum 3 D - java.lang.IllegalArgumentException: Too many pattern letters: D
        // Can only have maximum 5 E - java.lang.IllegalArgumentException: Too many pattern letters: E
        // Can only have maximum 2 m - java.lang.IllegalArgumentException: Too many pattern letters: m
        // Can only have maximum 5 M - java.lang.IllegalArgumentException: Too many pattern letters: M
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("GGG uuuuuu yyyyyy DDD dd EEEEE mm MMM"); // AD 002015 002015 130 10 S 22 May
        System.out.println(ldt.format(formatter));

        formatter = DateTimeFormatter.ofPattern("G u y D d E m M"); // AD 2015 2015 130 10 Sun 22 5
        System.out.println(ldt.format(formatter));
    }

    private static void parseExamples() {
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        System.out.println(dateTime); // 1986-04-08T12:30

        str = "AD 2017 5 11 07 02 01 333";
        formatter = DateTimeFormatter.ofPattern("GG yyyy d MM HH mm ss SSS");
        dateTime = LocalDateTime.parse(str, formatter);
        System.out.println(dateTime); // 2017-11-05T07:02:01.333
    }

    private static void atDateExamples() {
        LocalTime time = LocalTime.of(14, 10, 0);
        LocalDate date = LocalDate.of(2016,02,28);

        LocalDateTime dateTime = time.atDate(date); // Returns a LocalDateTime
        System.out.println(dateTime); // 2016-02-28T14:10
    }

    private static void invalidLocalDateAssignment() {
        // Exception in thread "main" java.time.DateTimeException: Invalid value for DayOfMonth (valid values 1 - 28/31): 40
        LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
        System.out.println(date);

        // Exception in thread "main" java.time.format.DateTimeParseException: Text '2017-55-10' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 5
        date = LocalDate.parse("2017-55-10");
        System.out.println(date);
    }
}