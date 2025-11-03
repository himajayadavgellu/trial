package com.zerocode.collections;

import java.util.*;

public class HashMapDemo {

	// Method 1: Create and return a sample HashMap
	public static Map<Integer, String> createMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(109, null);
		map.put(102, "hania");
		map.put(103, "naina");
		map.put(null, "roshi");
		map.put(105, "talha");
		map.put(null, "ahad");
		return map;
	}

	// Method 2: Add or update entry (Set)
	public static Map<Integer, String> add(Map<Integer, String> map, Integer key, String value) {
		map.put(key, value);
		return map;
	}

	// Method 3: Get value by key
	public static String getValue(Map<Integer, String> map, Integer key) {
		return map.get(key);
	}

	// Method 4: Check if key exists
	public static boolean checkKey(Map<Integer, String> map, int key) {
		return map.containsKey(key);
	}

	// Method 5: Check if value exists
	public static boolean checkValue(Map<Integer, String> map, String value) {
		return map.containsValue(value);
	}

	// Method 6: Check if map is empty
	public static boolean checkEmpty(Map<Integer, String> map) {
		return map.isEmpty();
	}

	// Method 7: Get all keys
	public static Set<Integer> getKeys(Map<Integer, String> map) {
		return map.keySet();
	}

	// Method 8: Get all values
	public static Collection<String> getValues(Map<Integer, String> map) {
		return map.values();
	}

	// Method 9: Get all entries
	public static Set<Map.Entry<Integer, String>> getEntries(Map<Integer, String> map) {
		return map.entrySet();
	}

	// Method 10: Iterate through map entries
	public static void iterateMap(Map<Integer, String> map) {
		System.out.println("Iterating through map using Iterator:");
		Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

	public static void main(String[] args) {

		Map<Integer, String> map = createMap();

		System.out.println("Map contents: " + map);

		System.out.println("Contains key 105? " + checkKey(map, 105));
		System.out.println("Contains value 'tanha'? " + checkValue(map, "tanha"));
		System.out.println("Is map empty? " + checkEmpty(map));

		System.out.println("All keys: " + getKeys(map));
		System.out.println("All values: " + getValues(map));
		System.out.println("All entries: " + getEntries(map));

		// Get and Set examples
		System.out.println("\nValue of key 103: " + getValue(map, 103));
		add(map, 106, "dana");
		System.out.println("After adding key 106: " + map);

		// Iterate
		iterateMap(map);
	}
}
