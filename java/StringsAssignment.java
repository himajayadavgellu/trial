package com.zerocode.strings;

public class StringsAssignment {

	// 1. Reverse a String using reverse loop
	public static String reverseUsingLoop(String word) {
		if (word == null || word.isBlank())
			return "0";
		String rev = "";
		for (int i = word.length() - 1; i >= 0; i--)
			rev += word.charAt(i);
		return rev;
	}

	public static String reverseUsingCharArray(String word) {
		if (word == null || word.isBlank())
			return "0";
		String rev = "";
		for (char c : word.toCharArray())
			rev = c + rev;// h,eh,leh,lleh,olleh
		return rev;
	}

	public static String reverseUsingBuilder(String word) {
		if (word == null || word.isBlank())
			return "0";// reverse in place
		return new StringBuilder(word).reverse().toString();// reversed str of SB object(mutable) to immutable str
	}

	// 2. Check if Two Strings are Anagrams
	public static boolean areAnagrams(String firstString, String secondString) {
		if (firstString == null || firstString.isBlank() || secondString == null)
			return false;
		firstString = firstString.replaceAll(" ", "").toLowerCase();// remove spaces,to lowercase
		secondString = secondString.replaceAll(" ", "").toLowerCase();
		if (firstString.length() != secondString.length())// check length
			return false;
		String temp = secondString;// str is immutable so keep in temp
		for (int i = 0; i < firstString.length(); i++) {
			char ch = firstString.charAt(i);
			if (!temp.contains(String.valueOf(ch)))
				return false;
			temp = temp.replaceFirst(String.valueOf(ch), "");// listen(l)(A) removed in silent(B)
		}
		return temp.isEmpty();// each char of A removed in B if empty,same
	}

	// 3. First Non-Repeated Character
	public static char getFirstUniqueChar(String word) {
		if (word == null || word.isBlank())
			return '0';
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);// each char in word
			if (word.indexOf(c) == word.lastIndexOf(c))// char first index and last is same then unique
				return c;
		}
		return '0';// no unique character
	}

	public static char getFirstUniqueCharUsingReplace(String word) {
		if (word == null || word.isBlank())
			return '0';
		for (char c : word.toCharArray())
			if (word.replace(String.valueOf(c), "").length() == word.length() - 1)// swiss->siss(4)==(swiss(5)-1)
				return c;
		return '0';
	}

	// 4. Count Occurrences
	public static String countCharacterFrequency(String word) {
		if (word == null || word.isBlank())
			return "0";
		String counted = "";// frequency
		String result = "";// output
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (counted.indexOf(c) != -1)// check if char is in counted
				continue;// leave and next
			counted += c;// add char to counted
			int freq = word.length() - word.replace(String.valueOf(c), "").length();// swiss(5)-wi(2)=3(frequency of s)
			result += c + " " + freq + " ";
		}
		return result.trim();
	}

	public static String countCharacterFrequencyByReplace(String word) {
		if (word == null || word.isBlank())
			return "0";
		String result = "";
		String counted = "";
		for (char c : word.toCharArray()) {
			if (counted.indexOf(c) == -1) {
				int freq = word.length() - word.replace(String.valueOf(c), "").length();
				result += c + " " + freq + " ";
				counted += c;
			}
		}
		return result.trim();
	}

	public static String countCharFreqWhile(String word) {
		if (word == null || word.isBlank())
			return "0";
		String res = "", done = "";
		int i = 0;
		while (i < word.length()) {
			char c = word.charAt(i++);
			if (done.indexOf(c) == -1) {
				res += c + " " + (word.length() - word.replace(c + "", "").length()) + " ";
				done += c;
			}
		}
		return res.trim();
	}

	public static String countCharFreqDoWhile(String word) {
		if (word == null || word.isBlank())
			return "0";
		String res = "", done = "";
		int i = 0;
		if (word.isEmpty())
			return "0";
		do {
			char c = word.charAt(i++);
			if (done.indexOf(c) == -1) {
				res += c + " " + (word.length() - word.replace(c + "", "").length()) + " ";
				done += c;
			}
		} while (i < word.length());
		return res.trim();
	}

	public static String countCharFreqRec(String word) {
		return helper(word, "", "", 0);
	}

	public static String helper(String word, String done, String res, int i) {
		if (word == null || word.isBlank())
			return "0";
		if (i == word.length())
			return res.trim();
		char c = word.charAt(i);
		if (done.indexOf(c) == -1)
			res += c + " " + (word.length() - word.replace(c + "", "").length()) + " ";// b1a3n2 after a -> skip
		done += c;
		return helper(word, done, res, i + 1);// calls with updated params,upto i == word.len()
	}

	// 5. Check if Palindrome
	public static boolean isPalindromeUsingReverse(String word) {
		if (word == null || word.isBlank())
			return false;
		word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();// remove spaces and lower case
		return word.equals(reverseUsingLoop(word));
	}

	public static boolean isPalindromeUsingCharCompare(String word) {
		if (word == null || word.isBlank())
			return false;
		word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		for (int i = 0; i < word.length() / 2; i++)
			if (word.charAt(i) != word.charAt(word.length() - i - 1))
				return false;
		return true;
	}

	// 6. Remove duplicate characters
	public static String removeDuplicateChars(String word) {
		if (word == null || word.isBlank())
			return "0";
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (result.indexOf(ch) == -1)// if char not in result add
				result += ch;
		}
		return result;
	}

	public static String removeDuplicateCharsUsingSubstring(String word) {
		if (word == null || word.isBlank())
			return "0";
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			String current = word.substring(i, i + 1);
			if (!result.contains(current))
				result += current;
		}
		return result;
	}

	public static String removeDuplicateCharsUsingCharArray(String word) {
		if (word == null || word.isBlank())
			return "0";
		String result = "";
		for (char c : word.toCharArray())
			if (result.indexOf(c) == -1)
				result += c;
		return result;
	}

	// 7. Permutations
	public static String generatePermutationsRecursive(String word, String ans) {
		if (word.isEmpty()) 
			return ans + " ";
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			result += generatePermutationsRecursive(word.substring(0, i) + word.substring(i + 1), ans + word.charAt(i));
		}
		return result;
	}

	public static String printPermutations(String word) {
		if (word == null || word.isBlank())
			return "0";
		int n = word.length();
		String result = "";
		if (n == 1) {
			result = word;
		} else if (n == 2) {
			result += word + " ";// original str added to result(AB)
			result += "" + word.charAt(1) + word.charAt(0);// reverse the 2 char and adds that permutation(BA)
		} else if (n == 3) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					for (int k = 0; k < n; k++)
						if (i != j && j != k && i != k)
							result += "" + word.charAt(i) + word.charAt(j) + word.charAt(k) + " ";
		} else 
			result = "Too long";
		return result.isEmpty() ? "0" : result.trim();
	}

	// 8. Longest Substring Without Repeating Characters
	public static String findLongestUniqueSubstring(String word) {
		if (word == null || word.isBlank())
			return "0";
		String current = "";
		String longest = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.indexOf(c) != -1) {// if char! in current
				int pos = current.indexOf(c);// find where it occured
				current = current.substring(pos + 1);// remove all before it
			}
			current += c;// add current char
			if (current.length() > longest.length())
				longest = current;
		}
		return longest;
	}

	// 9. Max Occurring Character
	public static char findMaxOccurringChar(String word) {
		if (word == null || word.isBlank())
			return '0';
		char maxChar = '\0';
		int maxCount = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int count = word.length() - word.replace(String.valueOf(c), "").length();// get frquency
			if (count > maxCount) {
				maxCount = count;
				maxChar = c;
			}
		}
		return maxChar;
	}

	// 10. Check if string contains only digit
	public static boolean isAllDigit(String word) {
		if (word == null || word.isBlank())
			return false;
		for (int i = 0; i < word.length(); i++)
			if (!Character.isDigit(word.charAt(i)))
				return false;
		return true;
	}

	public static boolean isAllDigitsUsingReplace(String word) {
		if (word == null || word.isBlank())
			return false;
		String digitsOnly = word.replaceAll("[0-9]", "");
		return digitsOnly.isEmpty();
	}

	// print all unique characters..
	public static String allUniqueCharsFor(String word) {
		if (word == null || word.isBlank())
			return "0";
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (word.indexOf(c) == word.lastIndexOf(c)) // occurs only once
				result += c;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Reverse: " + reverseUsingCharArray("madam"));
		System.out.println("Anagram check: " + areAnagrams("dormitory", "dirty room"));
		System.out.println("First unique char: " + getFirstUniqueChar("swiss"));
		System.out.println("Count chars: " + countCharacterFrequency("banana"));
		System.out.println("Palindrome check: " + isPalindromeUsingReverse("A man a plan a canal Panama"));
		System.out.println("Remove duplicates: " + removeDuplicateChars("programming"));
		System.out.println(generatePermutationsRecursive("abc", ""));
		System.out.println("Permutations: " + printPermutations("ABC"));
		System.out.println("Longest unique substring: " + findLongestUniqueSubstring("abcabcbb"));
		System.out.println("Max occurring char: " + findMaxOccurringChar("success"));
		System.out.println("All digits check: " + isAllDigit("BYReplace12345"));
		System.out.println("All unique characters: " + allUniqueCharsFor("swissroom"));
	}
}
