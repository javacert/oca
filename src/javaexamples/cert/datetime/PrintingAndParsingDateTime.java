package javaexamples.cert.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PrintingAndParsingDateTime {

    public static void main(String[] args){
        formattingLocalDateExamples();
        formattingLocalTimeExamples();
        formattingLocalTimeDateExamples();
        parsingLocaleExample();
    }

    private static void formattingLocalDateExamples() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //String doesntWork = date.format(DateTimeFormatter.ISO_OFFSET_DATE); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
        String s3 = date.format(DateTimeFormatter.ISO_DATE);
        String s4 = date.format(DateTimeFormatter.ISO_ORDINAL_DATE);

        System.out.println(s1); // 20140318
        System.out.println(s2); // 2014-03-18
        System.out.println(s3); // 2014-03-18
        System.out.println(s4); // 2014-077

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date1); // 2014-03-18
    }

    private static void formattingLocalTimeExamples() {

        LocalTime time = LocalTime.of(23, 22, 59);
        String s1 = time.format(DateTimeFormatter.ISO_TIME);
        String s2 = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
        // String doesntWork = time.format(DateTimeFormatter.ISO_OFFSET_TIME); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds

        System.out.println(s1); // 23:22:59
        System.out.println(s2); // 23:22:59
    }

    private static void formattingLocalTimeDateExamples() {
        LocalDateTime dateTime = LocalDateTime.of(2014, 3, 18, 10, 11, 12);
        //String doesntWork = dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
        String s1 = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String s2 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        // String doesntWork = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME); // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds

        System.out.println(s1); // 2014-03-18T10:11:12
        System.out.println(s2); // 2014-03-18T10:11:12
    }

    private static void parsingLocaleExample() {
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date1 = LocalDate.of(2014, 3, 18);

        String formattedDate = date1.format(italianFormatter); // 18. marzo 2014
        System.out.println(date1); // 2014-03-18

        LocalDate parsedDate = LocalDate.parse("19. marzo 2014", italianFormatter); // 18. marzo 2014
        System.out.println(parsedDate); // 2014-03-19

        LocalDate date2 = LocalDate.parse(formattedDate, italianFormatter);
        System.out.println(date2); // 2014-03-18
    }
}
