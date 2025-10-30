package com.zerocode.collections;

import java.util.*;

public class CursorsDemo {

	public static void main(String[] args) {
		System.out.println(listIteratorDemo());
		System.out.println(enumerationDemo());
	}

	// Method 1: ListIterator
	public static List<String> listIteratorDemo() {
		List<String> l = new ArrayList<>();
		l.add("naina");
		l.add("deepu");
		l.add("bunny");

		ListIterator<String> itr = l.listIterator();

		while (itr.hasNext()) {
			itr.next();
		}
		while (itr.hasPrevious()) {
			itr.previous();
		}

		l.remove("bunny");
		l.add("dua");
		l.set(1, "ram");

		return l;
	}

	// Method 2: Enumeration
	public static List<Integer> enumerationDemo() {
		Vector<Integer> v = new Vector<>();
		v.add(10);
		v.add(20);
		v.add(30);
		v.add(3,40);
		v.add(4,50);
		v.add(null);
		v.remove(2);

		List<Integer> result = new ArrayList<>();
		Enumeration<Integer> e = v.elements();
		while (e.hasMoreElements()) {
			result.add(e.nextElement());
		}
		return result;
	}
}
