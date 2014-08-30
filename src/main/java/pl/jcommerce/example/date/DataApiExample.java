package pl.jcommerce.example.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Data API live demo examples
 * 
 * @author Michal Orlowski
 *
 */
public class DataApiExample {

	public static void main(String[] args) {

		// System.currentTimeMillis()
		Clock clock = Clock.systemDefaultZone();
		clock.millis();

		Instant now = Instant.now();
		Date legacyDate = Date.from(now);

		ZonedDateTime today = ZonedDateTime.now();
		Month month = today.getMonth();
		DayOfWeek dayOfWeek = today.getDayOfWeek();

		System.out.println(today.with(
				TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).truncatedTo(
				ChronoUnit.MINUTES));

		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("MMM dd, yyyy - HH:mm");
		
		LocalDateTime formatDate = LocalDateTime.now();
		System.out.println(formatter.format(formatDate));

	}

}
