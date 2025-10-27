package com.zerocode.strings;

import java.io.*;

// ===== Custom Checked Exception =====
class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

// ===== Custom Unchecked Exception =====
class NegativeNumberException extends RuntimeException {
	public NegativeNumberException(String message) {
		super(message);
	}
}

public class ExceptionHandlingDemo {

	// Checked Exception Example
	static void readFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName); // may throw FileNotFoundException
		fr.close();
	}

	// Custom Checked Exception Example
	static void checkAge(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("Age must be 18 or above to vote!");
		System.out.println("Eligible to vote");
	}

	// Unchecked Exception Example
	static void divideNumbers(int a, int b) {
		int result = a / b; // may throw ArithmeticException
		System.out.println("Division Result: " + result);
	}

	// Custom Unchecked Exception Example
	static void checkNumber(int num) {
		if (num < 0)
			throw new NegativeNumberException("Negative numbers are not allowed!");
		System.out.println("Number is positive");
	}

	public static void main(String[] args) {
		System.out.println("==== Java Exception Handling Demo ====\n");

		// 1️ Checked Exception Handling
		try {
			readFile("missing.txt"); // file may not exist
		} catch (FileNotFoundException e) {
			System.out.println("Checked Exception Caught: " + e);
		} catch (IOException e) {
			System.out.println("IO Exception Caught: " + e);
		}

		// 2️ Unchecked Exception Handling
		try {
			divideNumbers(10, 0);
		} catch (ArithmeticException e) {
			System.out.println("Unchecked Exception Caught: " + e);
		}

		// 3️ ArrayIndexOutOfBounds Example
		try {
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Unchecked Exception Caught: " + e);
		}

		// 4️ NumberFormatException Example
		try {
			int num = Integer.parseInt("abc");
		} catch (NumberFormatException e) {
			System.out.println("Unchecked Exception Caught: " + e);
		}

		// 5️ Custom Checked Exception Example
		try {
			checkAge(16);
		} catch (InvalidAgeException e) {
			System.out.println("Custom Checked Exception Caught: " + e.getMessage());
		}

		// 6️ Custom Unchecked Exception Example
		try {
			checkNumber(-5);
		} catch (NegativeNumberException e) {
			System.out.println("Custom Unchecked Exception Caught: " + e.getMessage());
		}

		// 7️ NullPointerException Example
		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("Unchecked Exception Caught: " + e);
		}

		// 8️ Demonstrating Finally Block
		try {
			System.out.println("\nOpening resource...");
			int x = 5 / 0; // cause exception
		} catch (Exception e) {
			System.out.println("Caught Exception: " + e);
		} finally {
			System.out.println("Finally block executed");
		}

		System.out.println("\n==== Program Completed Successfully ====");
	}
}
