package com.zerocode.strings;

public class RegexUsingContains {

	public static void main(String[] args) {
		String sentence = "hi my name is $$himaja$$.I am from $$Hyderabad$$.";
		String[] words = sentence.split(" ");
		for (String w : words) {
			if (w.contains("$$")) {
				int start = w.indexOf("$$") + 2;
				int end = w.lastIndexOf("$$");
				if (end > start) {
					System.out.println(w.substring(start, end));
				}
			}
		}
	}
}
