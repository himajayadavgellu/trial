package com.zerocode.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	// 1. Create and return a HashSet
	public static Set<String> createSet() {
		Set<String> set = new HashSet<>();
		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		return set;
	}

	// 2. Add element
	public static boolean addElement(Set<String> set, String element) {
		return set.add(element);
	}

	// 3. Remove element
	public static boolean removeElement(Set<String> set, String element) {
		return set.remove(element);
	}

	// 4. Check if element exists
	public static boolean containsElement(Set<String> set, String element) {
		return set.contains(element);
	}

	// 5. Get size
	public static int getSize(Set<String> set) {
		return set.size();
	}

	// 6. Check if empty
	public static boolean isEmpty(Set<String> set) {
		return set.isEmpty();
	}

	// 7. Clear all elements
	public static void clearSet(Set<String> set) {
		set.clear();
	}

	// 8. Add multiple elements from another set (addAll)
	public static boolean addAllElements(Set<String> set, Set<String> anotherSet) {
		return set.addAll(anotherSet);
	}

	// 9. Retain common elements (retainAll)
	public static boolean retainCommonElements(Set<String> set, Set<String> anotherSet) {
		return set.retainAll(anotherSet);
	}

	// 10. Remove all elements present in another set (removeAll)
	public static boolean removeAllElements(Set<String> set, Set<String> anotherSet) {
		return set.removeAll(anotherSet);
	}

	// 11. Convert set to array
	public static Object[] convertToArray(Set<String> set) {
		return set.toArray();
	}

	public static void main(String[] args) {

		// Create set
		Set<String> fruits = createSet();
		System.out.println("Initial Set: " + fruits);

		// Add element
		System.out.println("Added Mango: " + addElement(fruits, "Mango"));
		System.out.println("After adding Mango: " + fruits);

		// Remove element
		System.out.println("Removed Apple: " + removeElement(fruits, "Apple"));
		System.out.println("After removal: " + fruits);

		// Contains check
		System.out.println("Contains Banana? " + containsElement(fruits, "Banana"));

		// Size of set
		System.out.println("Size: " + getSize(fruits));

		// Empty check
		System.out.println("Is empty? " + isEmpty(fruits));

		// AddAll example
		Set<String> moreFruits = new HashSet<>();
		moreFruits.add("pineapple");
		moreFruits.add("Guava");
		System.out.println("Added all new fruits: " + addAllElements(fruits, moreFruits));
		System.out.println("After addAll: " + fruits);

		// Retain common
		Set<String> common = new HashSet<>();
		common.add("Guava");
		System.out.println("Retain common: " + retainCommonElements(fruits, common));
		System.out.println("After retainAll: " + fruits);

		// RemoveAll
		System.out.println("Remove all common: " + removeAllElements(fruits, common));
		System.out.println("After removeAll: " + fruits);

		// Convert to array
		Object[] arr = convertToArray(fruits);
		System.out.print("Array elements: ");
		System.out.println(Arrays.toString(arr));
		
		// Clear set
		clearSet(fruits);
		System.out.println("After clear: " + fruits);
		System.out.println("Is empty now? " + isEmpty(fruits));
	}
}
