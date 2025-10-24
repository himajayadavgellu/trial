package com.zerocode.strings;

public class StringArrayAssignment {

	// 1. Find the Longest Palindromic Substring
	public String getLongestPalindrome(String input) {
		if (input == null || input.isBlank())
			return "";
		String longestPalindrome = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j < input.length(); j++) {
				String substring = input.substring(i, j + 1);
				if (isPalindrome(substring) && substring.length() > longestPalindrome.length())
					longestPalindrome = substring;
			}
		}
		return longestPalindrome;
	}

	public boolean isPalindrome(String text) {
		if (text == null)
			return false;
		return new StringBuilder(text).reverse().toString().equals(text);
	}

	// 2. Implement Regular Expression Matching (simplified)
	public boolean isPatternMatching(String text, String pattern) {
		if (text == null || pattern == null)
			return false;
		if (pattern.equals(".*") || text.equals(pattern))
			return true;
		if (pattern.equals("."))
			return text.length() == 1;
		return text.contains(pattern.replace(".", ""));
	}

	// 3. Group Words That Are Anagrams
	public String[] groupAnagramWords(String[] words) {
		if (words == null || words.length == 0)
			return new String[0];
		for (int i = 0; i < words.length; i++) {
			if (words[i] == null)
				words[i] = "";
			for (int j = i + 1; j < words.length; j++) {
				if (words[j] == null)
					words[j] = "";
				if (areAnagrams(words[i], words[j])) {
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
		return words;
	}

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

	// 4. Longest Substring with Equal 0s and 1s
	public int getLongestSubstring(String binaryString) {
		if (binaryString == null || binaryString.isEmpty())
			return 0;
		int maxLength = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			int countZero = 0, countOne = 0;
			for (int j = i; j < binaryString.length(); j++) {
				char current = binaryString.charAt(j);
				if (current == '0')
					countZero++;
				else if (current == '1')
					countOne++;
				if (countZero == countOne)
					maxLength = Math.max(maxLength, j - i + 1);
			}
		}
		return maxLength;
	}

	// 5. Minimum Window Substring
	public String getMinWindowSubstring(String text, String target) {
		if (text == null || target == null || text.isEmpty() || target.isEmpty())
			return "";
		for (int length = target.length(); length <= text.length(); length++) {
			for (int i = 0; i + length <= text.length(); i++) {
				String substring = text.substring(i, i + length);
				boolean isValid = true;
				for (char c : target.toCharArray()) {
					if (!substring.contains(String.valueOf(c))) {
						isValid = false;
						break;
					}
				}
				if (isValid)
					return substring;
			}
		}
		return "";
	}
     
	// 6. Evaluate Expression
	public int evaluateExpression(String expression) {
		if (expression == null || expression.isBlank())
			return 0;
		String[] terms = expression.split("\\+");
		int sum = 0;
		for (String term : terms) {
			term = term.trim();
			if (!term.isEmpty() && term.matches("-?\\d+")) {
				sum += Integer.parseInt(term);
			}
		}
		return sum;
	}

	// 7. Implement atoi()
	public int convertStringToInteger(String input) {
		if (input == null || input.isBlank())
			return 0;
		input = input.trim();
		int sign = 1, index = 0, result = 0;
		if (input.charAt(0) == '-' || input.charAt(0) == '+') {
			if (input.charAt(0) == '-')
				sign = -1;
			index++;
		}
		while (index < input.length() && Character.isDigit(input.charAt(index))) {
			result = result * 10 + (input.charAt(index++) - '0');
		}
		return result * sign;
	}

	// 8. Longest Common Prefix
	public String getLongestCommonPrefix(String[] words) {
		if (words == null || words.length == 0 || words[0] == null)
			return "";
		String prefix = words[0];
		for (int i = 1; i < words.length; i++) {
			if (words[i] == null)
				continue;
			while (!words[i].startsWith(prefix)) {
				if (prefix.isEmpty())
					return "";
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

	// 9. Extract Data Using Regex-like Parsing
	public String extractUserData(String data) {
		if (data == null || data.isBlank())
			return "";
		try {
			String[] parts = data.split(",");
			if (parts.length < 3)
				return "";
			String name = parts[0].split(" ")[1];
			String email = parts[1].split(" ")[2];
			String age = parts[2].split(" ")[2];
			return "name: " + name + ", email: " + email + ", age: " + age;
		} catch (Exception e) {
			return "Invalid data format";
		}
	}

	// 10. Longest Increasing Subsequence
	public int getLongestIncreasingSubsequenceLength(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return 0;
		int maxLength = 1;
		for (int i = 0; i < numbers.length; i++) {
			int length = 1, lastValue = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] > lastValue) {
					length++;
					lastValue = numbers[j];
				}
			}
			if (length > maxLength)
				maxLength = length;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		StringArrayAssignment program = new StringArrayAssignment();

		System.out.println("1. Longest Palindromic Substring: " + program.getLongestPalindrome("babad"));

		System.out.println("2. Regex Match: " + program.isPatternMatching("mississippi", "mis*is*p*."));

		System.out.println("3. Grouped Anagrams: "
				+ String.join(", ", program.groupAnagramWords(new String[] { "bat", "tab", "tan", "ant", "cat" })));

		System.out.println("4. Longest Equal 0s/1s: " + program.getLongestSubstring("1101010"));

		System.out.println("5. Minimum Window Substring: " + program.getMinWindowSubstring("ADOBECODEBANC", "ABC"));

		System.out.println("6. Evaluate Expression: " + program.evaluateExpression("3+2+5+2"));

		System.out.println("7. Atoi Conversion: " + program.convertStringToInteger(" -42"));

		System.out.println("8. Longest Common Prefix: "
				+ program.getLongestCommonPrefix(new String[] { "flower", "flow", "flight" }));

		System.out.println(
				"9. Extracted Data: " + program.extractUserData("User John, Email john.doe@example.com, Age 28"));

		System.out.println("10. Longest Increasing Subsequence: "
				+ program.getLongestIncreasingSubsequenceLength(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}
}
