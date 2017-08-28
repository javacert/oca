package javaexamples.cert.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExample {
    public static void main(String[] args){
        temporalAdjusterExamples();
    }

    private static void temporalAdjusterExamples() {

        // This will display the next available Tuesday (does not include today)
        System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));

        // This will return today's date if it is a tuesday
        System.out.println(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));

        // This is an alternative to the above, but it is recommended you use 'with' as it is easier to read.
        System.out.println(TemporalAdjusters.next(DayOfWeek.TUESDAY).adjustInto(LocalDate.now()));
    }
}
