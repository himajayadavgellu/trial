package com.zerocode.strings;

public class StringMethodsFullDemo {

	/** Returns number of characters in the string */
	int getLength(String str) {
		return str.length();
	}

	/** Returns character at given index */
	char getCharacter(String str, int index) {
		return str.charAt(index);
	}

	/** Returns substring from given index */
	String getSubstring(String str, int beginIndex) {
		return str.substring(beginIndex);
	}

	/** Returns substring between indexes */
	String getSubstringRange(String str, int beginIndex, int endIndex) {
		return str.substring(beginIndex, endIndex);
	}

	/** Compares content of strings */
	boolean isEqual(String s1, String s2) {
		return s1.equals(s2);
	}

	/** Compares strings ignoring case */
	boolean isEqualIgnoreCase(String s1, String s2) {
		return s1.equalsIgnoreCase(s2);
	}

	/** Lexicographically compares two strings */
	int compareToString(String s1, String s2) {
		return s1.compareTo(s2);
	}

	/** Lexicographically compares two strings ignoring case */
	int compareToIgnoreCase(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}

	/** Converts all characters to lowercase */
	String toLower(String str) {
		return str.toLowerCase();
	}

	/** Converts all characters to uppercase */
	String toUpper(String str) {
		return str.toUpperCase();
	}

	/** Removes leading and trailing spaces */
	String trimSpaces(String str) {
		return str.trim();
	}

	/** Removes all Unicode whitespace (Java 11+) */
	String stripSpaces(String str) {
		return str.strip();
	}

	/** Checks if string is empty ("") */
	boolean isEmpty(String str) {
		return str.isEmpty();
	}

	/** Checks if string is blank (spaces or empty) */
	boolean isBlank(String str) {
		return str.isBlank();
	}

	/** Checks if sequence exists in string */
	boolean containsSequence(String str, String seq) {
		return str.contains(seq);
	}

	/** Checks if string starts with prefix */
	boolean startsWithPrefix(String str, String prefix) {
		return str.startsWith(prefix);
	}

	/** Checks if string ends with suffix */
	boolean endsWithSuffix(String str, String suffix) {
		return str.endsWith(suffix);
	}

	/** Finds index of substring */
	int findFirstIndex(String str, String sub) {
		return str.indexOf(sub);
	}	

	/** Finds last occurrence of substring */
	int findLastIndex(String str, String sub) {
		return str.lastIndexOf(sub);
	}

	/** Replaces character */
	String replaceCharacter(String str, char oldChar, char newChar) {
		return str.replace(oldChar, newChar);
	}

	/** Replaces substring */
	String replaceSubstring(String str, String oldSub, String newSub) {
		return str.replace(oldSub, newSub);
	}

	/** Replaces all substrings matching regex */
	String replaceAllRegex(String str, String regex, String replacement) {
		return str.replaceAll(regex, replacement);
	}

	/** Replaces first match using regex */
	String replaceFirstRegex(String str, String regex, String replacement) {
		return str.replaceFirst(regex, replacement);
	}

	/** Splits string by regex */
	String[] splitString(String str, String regex) {
		return str.split(regex);
	}

	/** Joins elements with delimiter */
	String joinStrings(String delimiter, String... elements) {
		return String.join(delimiter, elements);
	}

	/** Appends another string */
	String concatenateStrings(String s1, String s2) {
		return s1.concat(s2);
	}

	/** Converts object to string (static) */
	String convertToString(Object obj) {
		return String.valueOf(obj);
	}

	/** Formats string like printf (static) */
	String formatString(String name, int age) {
		return String.format("My name is %s and I am %d years old.", name, age);
	}

	/** Tests if string matches regex */
	boolean matchesRegex(String str, String regex) {
		return str.matches(regex);
	}

	/** Returns canonical representation (string pool) */
	String getInternedString(String str) {
		return str.intern();
	}

	/** Repeats the string multiple times (Java 11+) */
	String repeatString(String str, int count) {
		return str.repeat(count);
	}

	/** Returns a stream of lines (Java 11+) */
	java.util.stream.Stream<String> getLines(String str) {
		return str.lines();
	}

	/** Returns bytes of the string */
	byte[] getBytes(String str) {
		return str.getBytes();
	}

	/** Converts string to char array */
	char[] convertToCharArray(String str) {
		return str.toCharArray();
	}

	/** Returns character sequence */
	CharSequence getSubSequence(String str, int start, int end) {
		return str.subSequence(start, end);
	}

	/** Returns hashcode of string */
	int getHashCode(String str) {
		return str.hashCode();
	}

	public static void main(String[] args) {
		StringMethodsFullDemo demo = new StringMethodsFullDemo();
		String text = "  Hello Java  ";

		System.out.println("Length: " + demo.getLength(text));
		System.out.println("CharAt(1): " + demo.getCharacter("Java", 1));
		System.out.println("Substring(2): " + demo.getSubstring("Hello", 2));
		System.out.println("Substring(1,4): " + demo.getSubstringRange("Hello", 1, 4));
		System.out.println("Equals: " + demo.isEqual("Java", "java"));
		System.out.println("EqualsIgnoreCase: " + demo.isEqualIgnoreCase("Java", "java"));
		System.out.println("CompareTo: " + demo.compareToString("a", "b"));
		System.out.println("ToLower: " + demo.toLower("JAVA"));
		System.out.println("ToUpper: " + demo.toUpper(text));
		System.out.println("Trim: '" + demo.trimSpaces(text) + "'");
		System.out.println("Strip: '" + demo.stripSpaces("  hello  ") + "'");
		System.out.println("IsEmpty(\"\"): " + demo.isEmpty(""));
        System.out.println("IsBlank(\"   \"): " + demo.isBlank("   "));
		System.out.println("Contains 'av': " + demo.containsSequence("Java", "av"));
		System.out.println("StartsWith 'He': " + demo.startsWithPrefix("Hello", "He"));
		System.out.println("EndsWith 'va': " + demo.endsWithSuffix("Java", "va"));
		System.out.println("FindFirstIndex of 'l': " + demo.findFirstIndex("Hello", "l"));
        System.out.println("FindLastIndex of 'l': " + demo.findLastIndex("Hello", "l"));
        System.out.println("Replace character: " + demo.replaceCharacter("ball", 'l', 't'));
        System.out.println("Replace substring: " + demo.replaceSubstring("Hello World", "World", "Java"));
		System.out.println("ReplaceAll digits: " + demo.replaceAllRegex("a1b2c3", "\\d", "-"));
		System.out.println("ReplaceFirst digit: " + demo.replaceFirstRegex("a1b2c3", "\\d", "="));
        System.out.println("Split string by 'l': ");
        for (String s : demo.splitString("Hello", "l")) 
        	System.out.print("'" + s + "' ");
        System.out.println();
		System.out.println("Join: " + demo.joinStrings("+", "ab", "bc", "ca"));
		System.out.println("Concat: " + demo.concatenateStrings("Hello", "World"));
		System.out.println("Format: " + demo.formatString("bunny", 21));
		System.out.println("Repeat: " + demo.repeatString("pap", 6));
        System.out.println("Bytes of string: ");
        for (byte b : demo.getBytes("ABC")) System.out.print(b + " ");
        System.out.println();
        System.out.println("Char array: ");
        for (char c : demo.convertToCharArray("ABC")) System.out.print(c + " ");
        System.out.println();
        System.out.println("SubSequence(1,4): " + demo.getSubSequence("Hello", 1, 4));
		System.out.println("ValueOf: " + demo.convertToString(12334));
		System.out.println("Matches regex [a-z]+: " + demo.matchesRegex("java21", "[a-z]+\\d+{6}"));
		System.out.println("HashCode: " + demo.getHashCode("Java"));
	}
}
