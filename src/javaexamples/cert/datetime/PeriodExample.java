package javaexamples.cert.datetime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args){
        LocalDate ld = LocalDate.of(2015, 10, 10);
        Period period = Period.ofDays(50);
        ld.plus(period); // 2015-10-10 - DON'T FORGET IT'S IMMUTABLE!

        ld = ld.plus(period);

        System.out.println(ld); // 2015-11-29
    }
}
