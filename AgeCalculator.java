package com.zerocode.strings;

import java.time.*;

public class AgeCalculator {

	public static String calculateAge(int day, int month, int year) {
		LocalDate birthDate = LocalDate.of(year, month, day);
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime birthDateTime = birthDate.atStartOfDay();
		Period period = Period.between(birthDate, now.toLocalDate());
		Duration duration = Duration.between(birthDateTime, now);
		long totalSeconds = duration.getSeconds();
		long hours = totalSeconds / 3600; 
		long minutes = (totalSeconds % 3600) / 60;
		long seconds = totalSeconds % 60;
		return "Age is: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays()
				+ " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds. ";
	}

	public static void main(String[] args) {
		String age = calculateAge(31, 10, 2009);
		System.out.println(age);
	}
}
