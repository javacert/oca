package javaexamples.cert.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;

public class DateTimeExamples {

    public static void main(String[] args) {

        //LocalDate localDate = new LocalDate(2015, 5, 21); // Error:(25, 31) java: LocalDate(int,int,int) has private access in java.time.LocalDate
        LocalDate localDate = LocalDate.of(2015, 5, 21);
        System.out.println(localDate); // 2015-05-21
        localDate.plusDays(3);
        System.out.println(localDate); // 2015-05-21 - remember plusDays returns a new LocalDate object
        LocalDate avoidTheTrick = localDate.plusDays(3);
        System.out.println(avoidTheTrick); // 2015-05-24 - remember plusDays returns a new LocalDate object

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

        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        zdt.minus(p);
        dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        System.out.println(zdt.format(dtf)); //11:22:33 BST
        dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        System.out.println(zdt.format(dtf)); //11:22:33 o'clock BST

    }
}
