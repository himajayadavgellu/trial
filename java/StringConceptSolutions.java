package com.zerocode.strings;

public class StringConceptSolutions {

	// 1. Reverse a String (String-only)
	public static String reverseString_1(String s) {
		String rev = "";
		for (int i = s.length() - 1; i >= 0; i--)
			rev += s.charAt(i);
		return rev;
	}

	public static String reverseString_2(String s) {
		String rev = "";
		for (char c : s.toCharArray())
			rev = c + rev;
		return rev;
	}

	public static String reverseString_3(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static String reverseString_4(String s) {
		int len = s.length();
		String rev = "";
		for (int i = 0; i < len; i++)
			rev = s.charAt(i) + rev;
		return rev;
	}

	// 2. Check if Two Strings are Anagrams
	public static boolean isAnagram_1(String a, String b) {
		if (a.length() != b.length())
			return false;
		for (int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i);
			if (b.indexOf(ch) == -1)
				return false;
			b = b.replaceFirst(String.valueOf(ch), "");
		}
		return b.isEmpty();
	}

	public static boolean isAnagram_2(String a, String b) {
		if (a.length() != b.length())
			return false;
		for (int i = 0; i < a.length(); i++) {
			String ca = String.valueOf(a.charAt(i));
			b = b.replaceFirst(ca, "");
		}
		return b.equals("");
	}

	public static boolean isAnagram_3(String a, String b) {
		if (a.length() != b.length())
			return false;

		for (String ch : a.split("")) {
			if (!b.contains(ch))
				return false;
		}
		return true;
	}

	// 3. First Non-Repeated Character
	public static char firstUniqueChar_1(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (s.indexOf(c) == s.lastIndexOf(c))
				return c;
		}
		return '\0';
	}

	public static char firstUniqueChar_2(String s) {
		for (char c : s.toCharArray())
			if (s.replace(String.valueOf(c), "").length() == s.length() - 1)
				return c;
		return '\0';
	}

	// 4. Count Occurrences (String methods only)
	public static String countChars_1(String s) {
		String counted = "";
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counted.indexOf(c) != -1)
				continue;
			counted += c;
			int before = s.length();
			int after = s.replace(String.valueOf(c), "").length();
			int freq = before - after;
			result += c + " " + freq + " ";
		}
		return result.trim();
	}

	public static String countChars_2(String s) {
		String result = "";
		for (char c : s.toCharArray())
			if (result.indexOf(c) == -1)
				result += c + " " + (s.length() - s.replace(String.valueOf(c), "").length()) + " ";
		return result.trim();
	}

	// 5. Check if Palindrome (Strings only)
	public static boolean isPalindrome_1(String s) {
		s = s.replaceAll(" ", "").toLowerCase();
		return s.equals(reverseString_1(s));
	}

	public static boolean isPalindrome_2(String s) {
		s = s.toLowerCase().replace(" ", "");
		for (int i = 0; i < s.length() / 2; i++)
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(reverseString_1("hello"));
		System.out.println(isAnagram_3("listen", "silent"));
		System.out.println(firstUniqueChar_1("swiss"));
		System.out.println(countChars_1("banana"));
		System.out.println(isPalindrome_1("A man a plan a canal Panama"));
	}
}
