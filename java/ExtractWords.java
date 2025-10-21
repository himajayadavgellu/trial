package com.zerocode.strings;

import java.util.Arrays;

public class ExtractWords {

	public static void main(String[] args) {
		String inputA = "hi my name is $$himaja$$ .Iam $from $$hyderabad$$ .In hyderabad $biriyani is very famous";
		String inputB = "@098#$himaja$$%&";
		String[] resA = extractWords(inputA, "$$");
		String[] resB = extractWords(inputB, "$$");
		System.out.println(Arrays.toString(resA));
		System.out.println(Arrays.toString(resB));
	}

	public static String[] extractWords(String sentence, String encloser) {
		String[] words = sentence.split(" ");
		String[] result = new String[words.length]; // only one array now
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].startsWith(encloser) && words[i].endsWith(encloser)) {
				String w = words[i].replace(encloser, "");
				result[count++] = w;
			}
		}
		// Return only the part of the array that has actual words
		return Arrays.copyOf(result, count);
	}
}
