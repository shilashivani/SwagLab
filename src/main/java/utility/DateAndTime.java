package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	public static String getDateAndTime() {
		LocalDateTime dateTime=LocalDateTime.now();
		DateTimeFormatter time=DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
	    String timeDate=dateTime.format(time);
	    return timeDate;
	}
	

}
