package com.zerocode.strings;

import java.util.ArrayList;
import java.util.List;

public class StudentClass {
	int order;
	String name;

	StudentClass(int order, String name) {
		this.order = order;
		this.name = name;
	}

	public static List<StudentClass> getSortedList(List<StudentClass> originalList) {
		if (originalList == null || originalList.isEmpty()) {
			return new ArrayList<>();
		}
		List<StudentClass> list = new ArrayList<>();
		for (StudentClass sc : originalList) {
			if (sc != null) {
				list.add(sc);
			}
		}
		for (int i = 1; i < list.size(); i++) {
			StudentClass current = list.get(i);
//			if (current == null)
//				continue;
			int j = i - 1;
			while (j >= 0 && list.get(j).order > current.order) {
				list.set(j + 1, list.get(j));
				j--;
			}
			list.set(j + 1, current);
		}
		return list;
	}

	public String toString() {
		return order + "-" + name;
	}

	public static void main(String[] args) {
		List<StudentClass> result = new ArrayList<>();
		result.add(new StudentClass(7, "VII"));
		result.add(new StudentClass(10, "X"));
		result.add(null);
		result.add(new StudentClass(1, "I"));
		result.add(new StudentClass(5, "V"));
		result.add(new StudentClass(8, "VIII"));
		result.add(null);
		result.add(new StudentClass(2, "II"));
		result.add(new StudentClass(4, "IV"));
		result.add(new StudentClass(3, "III"));
		result.add(new StudentClass(9, "IX"));
		result.add(new StudentClass(6, "VI"));
		List<StudentClass> sorted = getSortedList(result);
		System.out.println(sorted);
//		System.out.println(sorted.stream().filter(s -> s!= null).map(s -> s.order + "-" + s.name).toList());
	}
}