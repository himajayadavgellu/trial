package com.zerocode.strings;

import java.util.LinkedList;

public class LinkedListDemo {

	// 1. Create LinkedList
	public static LinkedList<String> createList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("Dum Biryani");
		list.add("Palak Paneer");
		list.add("Boti Kabab");
		list.add("Kheema Naan");
		list.add("Mutton Korma");
		return list;
	}

	// 2. Add element at specific index
	public static LinkedList<String> addAtIndex(LinkedList<String> list) {
		list.add(2, "Mutton Dalcha");
		return list;
	}

	// 3. Add elements at first and last
	public static LinkedList<String> addFirstAndLast(LinkedList<String> list) {
		list.addFirst("Chicken 65");
		list.addLast("Mutton Haleem");
		return list;
	}

	// 4. Access elements
	public static void accessElements(LinkedList<String> list) {
		System.out.println("First element: " + list.getFirst());
		System.out.println("Last element: " + list.getLast());
		System.out.println("Element at index 3: " + list.get(3));
	}

	// 5. Update element
	public static LinkedList<String> updateElement(LinkedList<String> list) {
		list.set(3, "Tandoori Chicken");
		return list;
	}

	// 6. Remove elements
	public static LinkedList<String> removeElements(LinkedList<String> list) {
		list.remove("Kheema Naan");
		list.remove(2);
		list.removeFirst();
		list.removeLast();
		return list;
	}

	// 7. Check properties
	public static void checkProperties(LinkedList<String> list) {
		System.out.println("Contains 'Boti Kabab'? " + list.contains("Boti Kabab"));
		System.out.println("Size of LinkedList: " + list.size());
		System.out.println("Is list empty? " + list.isEmpty());
	}

	// 8. Clear LinkedList
	public static LinkedList<String> clearList(LinkedList<String> list) {
		list.clear();
		return list;
	}

	public static void main(String[] args) {
		LinkedList<String> list = createList();
		System.out.println("Initial LinkedList: " + list);
		list = addAtIndex(list);
		System.out.println("After adding at index 2: " + list);
		list = addFirstAndLast(list);
		System.out.println("After addFirst & addLast: " + list);
		accessElements(list);
		list = updateElement(list);
		System.out.println("After updating index 3: " + list);
		list = removeElements(list);
		System.out.println("After removals: " + list);
		checkProperties(list);
		list = clearList(list);
		System.out.println("After clearing: " + list);
	}
}
