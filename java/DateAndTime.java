package com.zerocode.strings;

import java.time.*;
//import java.time.LocalTime;
//import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class DateAndTime {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		TimeZone t = TimeZone.getDefault();
		System.out.println(t);
		
		LocalDate date = LocalDate.now(); 
		System.out.println(date);

		LocalTime time = LocalTime.now();
		System.out.println(time);
		
        ZonedDateTime dt = ZonedDateTime.now(); 	  
	    System.out.println(dt);
	}
}
