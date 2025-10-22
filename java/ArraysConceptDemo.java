package com.zerocode.strings;

import java.util.Arrays;

public class ArraysConceptDemo {

	public static void main(String[] args) {
		// int[] arr = createArr(5);
		int[] arr2 = initArr(new int[] { 1, 2, 3, 4, 5 });// Creates anonymous array {1,2,3,4,5}
		int first = getElem(arr2, 0);
		int last = getElem(arr2, arr2.length - 1);
		System.out.println("First = " + first + ", Last = " + last);
		System.out.println("For loop: " + Arrays.toString(traverseFor(arr2)));
		System.out.println("Foreach: " + Arrays.toString(traverseForEach(arr2)));
		System.out.println("While: " + Arrays.toString(traverseWhile(arr2)));
		System.out.println("Sum = " + sumArr(arr2));
		System.out.println("Avg = " + avgArr(arr2));
		System.out.println("Max = " + maxArr(arr2));
		System.out.println("Min = " + minArr(arr2));
		System.out.println("Access invalid index safely: " + getElem(arr2, 10));
		System.out.println("Access null array safely: " + getElem(null, 0));
	}

	// Declaration and initialization
	static int[] createArr(int n) {
		return n > 0 ? new int[n] : new int[0];
	}

	static int[] initArr(int[] vals) {
		return vals != null ? Arrays.copyOf(vals, vals.length) : new int[0];
	}

	// Access elements safely
	static int getElem(int[] arr, int i) {
		if (arr == null || i < 0 || i >= arr.length)
			return -1;
		return arr[i];
	}

	// Traverse using for.
	static int[] traverseFor(int[] arr) {
		if (arr == null)
			return new int[0];
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			res[i] = arr[i];
		return res;
	}

	// traverse using for each.
	static int[] traverseForEach(int[] arr) {
		if (arr == null)
			return new int[0];
		int[] res = new int[arr.length];
		int i = 0;
		for (int v : arr)
			res[i++] = v;
		return res;
	}

	// traverse using while.
	static int[] traverseWhile(int[] arr) {
		if (arr == null)
			return new int[0];
		int[] res = new int[arr.length];
		int i = 0;
		while (i < arr.length)
			res[i] = arr[i++];
		return res;
	}

	// Array operations
	static int sumArr(int[] arr) {
		if (arr == null)
			return 0;
		int s = 0;
		for (int v : arr)
			s += v;
		return s;
	}

	static double avgArr(int[] arr) {
		return (arr == null || arr.length == 0) ? 0 : (double) sumArr(arr) / arr.length;
	}

	static int maxArr(int[] arr) {
		if (arr == null || arr.length == 0)
			return Integer.MIN_VALUE;
		int m = arr[0];
		for (int v : arr)
			if (v > m)
				m = v;
		return m;
	}

	static int minArr(int[] arr) {
		if (arr == null || arr.length == 0)
			return Integer.MAX_VALUE;
		int m = arr[0];
		for (int v : arr)
			if (v < m)
				m = v;
		return m;
	}
}
