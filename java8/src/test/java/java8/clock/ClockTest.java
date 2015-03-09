package java8.clock;

import org.junit.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.between;
import static java.time.LocalDate.of;
import static java.time.LocalDate.parse;
import static java.time.Period.between;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static org.junit.Assert.assertEquals;

public class ClockTest {
    @Test
    public void now() {
        getNows();
    }

    private List<Object> getNows() {
        List<Object> r = new ArrayList<>();
        r.add(LocalDate.now());
        r.add(LocalTime.now());
        r.add(LocalDateTime.now());
        r.add(Instant.now());
        r.add(Clock.systemUTC());
        r.add(ZonedDateTime.now());
        r.add(OffsetDateTime.now());
        r.add(OffsetTime.now());
        return r;
    }

    @Test
    public void format() {
        assertEquals("20120102", of(2012, 1, 2).format(BASIC_ISO_DATE));
    }

    @Test
    public void withGet() {
        assertEquals(31, of(2012, 1, 2).with(lastDayOfMonth()).get(DAY_OF_MONTH));
    }

    @Test
    public void plus() {
        assertEquals(parse("2012-02-03", ISO_DATE), of(2012, 1, 2).with(MONTH_OF_YEAR, 2).plus(1, DAYS));
    }

    @Test
    public void period() {
        assertEquals(1, between(parse("2012-02-03"), parse("2012-02-04")).getDays());
    }

    @Test
    public void duration() {
        Instant i = Instant.now();
        assertEquals(1, between(i, i.plus(1, SECONDS)).getSeconds());
    }
}
