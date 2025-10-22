package com.zerocode.strings;

public class RegexForLoop {

	public static void main(String[] args) {
		String sentence = "hi my name is $$himaja$$ .I am from $$Hyderabad$$ .";
		String[] words = sentence.split(" ");
		for (String w : words) {
			if (w.startsWith("$$") && w.endsWith("$$")) {
				System.out.println(w.substring(2, w.length() - 2));
			}
		}
	}
}
