package com.zerocode.collections;

import java.util.*;

public class TreeSetDemo {

	// 1. Create TreeSet
	public static TreeSet<String> createTreeSet() {
		TreeSet<String> ts = new TreeSet<>();
		ts.add("Banana");
		ts.add("Apple");
		ts.add("Cherry");
		ts.add("Mango");
		ts.add("Grapes");
		return ts;
	}

	// 2. Add element
	public static boolean addElement(TreeSet<String> ts, String e) {
		return ts.add(e);
	}

	// 3. Remove element
	public static boolean removeElement(TreeSet<String> ts, String e) {
		return ts.remove(e);
	}

	// 4. Check if element exists
	public static boolean containsElement(TreeSet<String> ts, String e) {
		return ts.contains(e);
	}

	// 5. Get first element
	public static String getFirst(TreeSet<String> ts) {
		return ts.first();
	}

	// 6. Get last element
	public static String getLast(TreeSet<String> ts) {
		return ts.last();
	}

	// 7. Get higher element
	public static String getHigher(TreeSet<String> ts, String e) {
		return ts.higher(e);
	}

	// 8. Get lower element
	public static String getLower(TreeSet<String> ts, String e) {
		return ts.lower(e);
	}

	// 9. Get descending set
	public static NavigableSet<String> getDescending(TreeSet<String> ts) {
		return ts.descendingSet();
	}

	// 10. Return size
	public static int getSize(TreeSet<String> ts) {
		return ts.size();
	}

	public static void main(String[] args) {

		TreeSet<String> fruits = createTreeSet();
		System.out.println("Initial TreeSet: " + fruits);
		addElement(fruits, "Pineapple");
		System.out.println("After adding 'Pineapple': " + fruits);
		removeElement(fruits, "Apple");
		System.out.println("After removing 'Apple': " + fruits);
		System.out.println("Contains 'Mango'? " + containsElement(fruits, "Mango"));
		System.out.println("First element: " + getFirst(fruits));
		System.out.println("Last element: " + getLast(fruits));
		System.out.println("Higher than 'Mango': " + getHigher(fruits, "Mango"));
		System.out.println("Lower than 'Mango': " + getLower(fruits, "Mango"));
		System.out.println("Descending order set: " + getDescending(fruits));
		System.out.println("TreeSet size: " + getSize(fruits));
	}
}
