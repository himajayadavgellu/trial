package com.zerocode.strings;

import java.util.*;

public class UniqueDigits {

	// Method 1: Generate one random alphanumeric string
	public static String generateRandomString(int length) {
		Random random = new Random();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}

	public static String findUniqueAllDigitStrings() {
		return findUniqueAllDigitStrings(6);
	}

	// Method 2: Generate 1 lakh OTPs and return both (as one string)
	public static String findUniqueAllDigitStrings(int length) {
		Set<String> uniqueAllDigit = new HashSet<>();
		for (int i = 0; i < 100000; i++) {
			String otp = generateRandomString(length);
			if (otp.matches("\\d{" + length + "}")) {
				uniqueAllDigit.add(otp);
			}
		}
		String result = "Unique All-Digit OTPs Found: " + uniqueAllDigit.size()
				+ "\n=======================================\n" + "All Unique OTPs: " + uniqueAllDigit;
		return result;
	}

	public static void main(String[] args) {
		String output = findUniqueAllDigitStrings(6);
		System.out.println(output);
	}
}
