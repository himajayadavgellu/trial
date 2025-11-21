package com.zerocode.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 12, 9, 4, 5, 5, 8, 33, 98, 89);
		List<Integer> result = list.stream().filter(x -> x % 2 == 0).toList();
		System.out.println(result);
		int count = (int) IntStream.range(1, 20).filter(n -> n % 2 == 0).count();
		System.out.println(count);
		List<Integer> sorted = list.stream().sorted().toList();
		System.out.println(sorted);
		List<Integer> distinct = list.stream().distinct().toList();
		System.out.println(distinct);
		Stream<Integer> entry = list.stream().limit(4);
		System.out.println(entry.toList());
		Stream<Integer> stream = list.stream().filter(n -> n > 4).skip(5);
		System.out.println(stream.toList());
//		System.out.println(Arrays.asList(stream.map( n -> n * 1)));
//		stream.close();
//		System.out.println(stream.toArray());
		System.out.println(loopUsingFor());
		System.out.println(loopWithStream());
		System.out.println(countEvenOdd());
		System.out.println(evenOddCount());
	}

	public static List<Integer> loopUsingFor() {
		List<Integer> numList = new ArrayList<>(10000);
		for (int i = 0; i < 10; i++) {
			numList.add(i + 1);
		}
		return numList;
	}

	public static List<Integer> loopWithStream() {
		return IntStream.range(0, 10).map(n -> n + 1).boxed().toList();
	}

	public static Map<String, Integer> countEvenOdd() {
		Map<String, Integer> countMap = new HashMap<>();
		int even = 0;
		int odd = 0;
		for (int i = 0; i < 10000; i++) {
			if (i % 2 == 0)
				even++;
			else
				odd++;
		}
		countMap.put("even", even);
		countMap.put("odd", odd);
		return countMap;
	}

	public static Map<String, Integer> evenOddCount() {
		Map<String, Integer> result = new HashMap<>();
		result.put("even", 0);
		result.put("odd", 0);
		IntStream.range(0, 10000).forEach(n -> {
			if (n % 2 == 0) {
				result.put("even", result.get("even") + 1);
			} else {
				result.put("odd", result.get("odd") + 1);
			}
		});
		return result;
	}

}
