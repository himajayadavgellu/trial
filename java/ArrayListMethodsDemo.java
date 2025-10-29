package com.zerocode.strings;

import java.util.*;
import java.util.function.UnaryOperator;

public class ArrayListMethodsDemo {

	// 1. Create ArrayList
	public static ArrayList<String> createList() {
		return new ArrayList<>();
	}

	// 2. Add element
	public static boolean addElement(ArrayList<String> list, String element) {
		return list.add(element);
	}

	// 3. Add element at index
	public static void addElementAtIndex(ArrayList<String> list, int index, String element) {
		list.add(index, element);
	}
	
	// 4. Get element
	public static String getElement(ArrayList<String> list, int index) { 
		return list.get(index);
	}

	// 5. Set element
	public static String setElement(ArrayList<String> list, int index, String element) {
		return list.set(index, element);
	}

	// 6. Remove element by index
	public static String removeElementByIndex(ArrayList<String> list, int index) {
		return list.remove(index);
	}

	// 7. Remove element by object
	public static boolean removeElement(ArrayList<String> list, String element) {
		return list.remove(element);
	}

	// 8. Size of list
	public static int getSize(ArrayList<String> list) {
		return list.size();
	}

	// 9. Check if empty
	public static boolean isEmpty(ArrayList<String> list) {
		return list.isEmpty();
	}

	// 10. Check if contains element
	public static boolean containsElement(ArrayList<String> list, String element) {
		return list.contains(element);
	}

	// 11. Clear list
	public static void clearList(ArrayList<String> list) {
		list.clear();
	}

	// 12. Index of element
	public static int indexOfElement(ArrayList<String> list, String element) {
		return list.indexOf(element);
	}

	// 13. Last index of element
	public static int lastIndexOfElement(ArrayList<String> list, String element) {
		return list.lastIndexOf(element);
	}

	// 14. Convert to array
	public static Object[] toArray(ArrayList<String> list) {
		return list.toArray();
	}

	// 15. Sublist
	public static List<String> subList(ArrayList<String> list, int start, int end) {
		return list.subList(start, end);
	}

	// 16. Clone list
	@SuppressWarnings("unchecked")
	public static ArrayList<String> cloneList(ArrayList<String> list) {
		return (ArrayList<String>) list.clone();
	}

	// 17. Add all elements from another list
	public static boolean addAllElements(ArrayList<String> list, ArrayList<String> otherList) {
		return list.addAll(otherList);
	}

	// 18. Remove all elements in another list
	public static boolean removeAllElements(ArrayList<String> list, ArrayList<String> otherList) {
		return list.removeAll(otherList);
	}

	// 19. Retain all elements in another list
	public static boolean retainAllElements(ArrayList<String> list, ArrayList<String> otherList) {
		return list.retainAll(otherList);
	}

	// 20. Iterate using Iterator
	public static void iterateList(ArrayList<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	// 21. Sort list
	public static void sortList(ArrayList<String> list) {
		Collections.sort(list);
	}

	// 22. Replace all elements
	public static void replaceAllElements(ArrayList<String> list, UnaryOperator<String> operator) {
		list.replaceAll(operator);
	}

	// 23. Remove elements matching condition
	public static boolean removeIfCondition(ArrayList<String> list, java.util.function.Predicate<String> filter) {
		return list.removeIf(filter);
	}

	public static void main(String[] args) {
		ArrayList<String> fruits = createList();

		addElement(fruits, "Apple");
		addElement(fruits, "Banana");
		addElement(fruits, "Orange");

		addElementAtIndex(fruits, 1, "Mango");

		System.out.println("Element at index 2: " + getElement(fruits, 2));
		setElement(fruits, 2, "Grapes");

		System.out.println("Removed element: " + removeElementByIndex(fruits, 0));
		removeElement(fruits, "Mango");

		System.out.println("Size: " + getSize(fruits));
		System.out.println("Is Empty: " + isEmpty(fruits));
		System.out.println("Contains Grapes: " + containsElement(fruits, "Grapes"));

		addElement(fruits, "Apple");
		addElement(fruits, "Banana");
		addElement(fruits, "Apple");

		System.out.println("Index of Apple: " + indexOfElement(fruits, "Apple"));
		System.out.println("Last index of Apple: " + lastIndexOfElement(fruits, "Apple"));

		System.out.println("Sublist (1-3): " + subList(fruits, 1, 3));

		ArrayList<String> clonedList = cloneList(fruits);
		System.out.println("Cloned list: " + clonedList);

		ArrayList<String> otherList = new ArrayList<>();
		addElement(otherList, "Pineapple");
		addAllElements(fruits, otherList);

		System.out.println("Fruits after addAll: " + fruits);

		removeAllElements(fruits, otherList);
		System.out.println("Fruits after removeAll: " + fruits);

		addAllElements(fruits, otherList);
		retainAllElements(fruits, otherList);
		System.out.println("Fruits after retainAll: " + fruits);

		System.out.println("Iterating list:");
		iterateList(fruits);

		addElement(fruits, "Cherry");
		sortList(fruits);
		System.out.println("Sorted fruits: " + fruits);

		replaceAllElements(fruits, s -> s.toUpperCase());
		System.out.println("Replaced all with uppercase: " + fruits);

		removeIfCondition(fruits, s -> s.startsWith("C"));
		System.out.println("After removeIf (starts with C): " + fruits);

		clearList(fruits);
		System.out.println("After clear: " + fruits);
	}
}
