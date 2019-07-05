package java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by amarendra on 27/08/17.
 */
public class Date8Test {

    public static void main(String[] args) {

        System.out.println(Instant.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))));
        LocalDate of = LocalDate.of(1564, Month.APRIL, 30);
        String format = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        System.out.println("formatted -> " + format);
        System.out.println(of);
        Period until = of.until(LocalDate.now());
        System.out.println(until.get(ChronoUnit.DAYS));

    }
}
