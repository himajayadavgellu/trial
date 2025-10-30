package com.zerocode.collections;

import java.util.Vector;

public class VectorDemo {

	public static Vector<String> createVector() {
		Vector<String> v = new Vector<>();
		v.add("Apple");
		v.add("Banana");
		v.add("Cherry");
		return v;
	}

	public static boolean addElement(Vector<String> v, String e) {
		return v.add(e);
	}

	public static String getElement(Vector<String> v, int i) {
		return v.get(i);
	}

	public static String removeElement(Vector<String> v, int i) {
		return v.remove(i);
	}

	public static int getSize(Vector<String> v) {
		return v.size();
	}

	public static void clearVector(Vector<String> v) {
		v.clear();
	}
	public static int capacity(Vector<String> v) {
		return v.capacity();
	}

	public static void main(String[] args) {
		Vector<String> fruits = createVector();
		System.out.println("Initial: " + fruits);		
		addElement(fruits, "Mango");
		System.out.println("After add: " + fruits);
		System.out.println("Element at 1: " + getElement(fruits, 1));
		System.out.println("Removed: " + removeElement(fruits, 2));
		System.out.println("After remove: " + fruits);
		System.out.println("Size: " + getSize(fruits));
		System.out.println("capacity:" + capacity(fruits));
		clearVector(fruits);
		System.out.println("After clear: " + fruits);
	}
}
