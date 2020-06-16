package utils;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtility {
	// define the starting and ending hour of a working day (24 hour format)
	public static final int WORKING_DAY_START = 8;
	public static final int WORKING_DAY_END = 16;
	
	private static Date now = new Date();
	private static Calendar calendar = Calendar.getInstance();
	
	public static boolean canOpenNewAccount() {
		return isWorkingDayOfWeek() && isWorkingHour();
	}
	
	public static boolean isWorkingDayOfWeek() {
		calendar.setTime(now);
		if ( Calendar.SATURDAY == calendar.get(Calendar.DAY_OF_WEEK) || Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK) ) {
			return false;
		}
		return true;
	}
	
	public static boolean isWorkingHour() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return hour >= WORKING_DAY_START && hour <= WORKING_DAY_END;
	}
	
}