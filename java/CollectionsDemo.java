package com.zerocode.collections;

import java.util.*;

public class CollectionsDemo {
	public static void main(String[] args) {

		// ===================== 1. ArrayList =====================
		System.out.println("---- ArrayList Methods ----");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Apple"); // Adds element to list
		list.add("Banana");
		list.add("Cherry");
		System.out.println("ArrayList: " + list); // [Apple, Banana, Cherry]
		System.out.println("get(1): " + list.get(1)); // Returns element at index 1
		list.set(2, "Grapes"); // Replaces element at index 2
		System.out.println("After set(2, Grapes): " + list);
		list.remove("Apple"); // Removes specific element
		System.out.println("After remove(Apple): " + list);
		System.out.println("contains(Banana): " + list.contains("Banana")); // true if present
		System.out.println("size(): " + list.size()); // Returns count
		list.clear(); // Removes all elements
		System.out.println("After clear(): " + list); // []
		
		// ===================== 2. LinkedList =====================
		System.out.println("\n---- LinkedList Methods ----");
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.addFirst(5); // Adds element at begin 
		ll.addLast(40); // Adds element at end
		System.out.println("linkedlist: " + ll);
		System.out.println("get(2) : " + ll.get(2));
		System.out.println("getFirst(): " + ll.getFirst()); // 5
		System.out.println("getLast(): " + ll.getLast()); // 40
		ll.removeFirst(); // Removes first element
		ll.removeLast(); // Removes last element
		System.out.println("After removeFirst/Last: " + ll);
		System.out.println("contains(20): " + ll.contains(20)); // true

		// ===================== 3. HashSet =====================
		System.out.println("\n---- HashSet Methods ----");
		HashSet<String> hs = new HashSet<String>();
		hs.add("Red");
		hs.add("Green");
		hs.add("Blue");
		hs.add("Green"); // Duplicates are allowed
		System.out.println("HashSet: " + hs); // Random order
		hs.remove("Blue");
		System.out.println("After remove: " + hs);
		System.out.println("contains(red): " + hs.contains("Red")); // true
		System.out.println("size(): " + hs.size()); // 2

		// ===================== 4. LinkedHashSet =====================
		System.out.println("\n---- LinkedHash Methods-----");
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
		lhs.add(11);
		lhs.add(22);
		lhs.add(33);
		lhs.add(22); // duplicate ignored
		System.out.println("LinkedHashSet: " + lhs); // Maintains insertion order
		lhs.remove(11);
		System.out.println("After remove(11): " + lhs);

		// ===================== 5. TreeSet =====================
		System.out.println("\n---- TreeSet Methods ----");
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(50);
		ts.add(10);
		ts.add(40);
		ts.add(30);
		System.out.println("TreeSet: " + ts); // Ascending order
		System.out.println("first(): " + ts.first()); // Smallest element
		System.out.println("last(): " + ts.last()); // Largest element
		System.out.println("higher(30): " + ts.higher(30)); // Next greater
		System.out.println("lower(30): " + ts.lower(30)); // Next smaller
		ts.remove(10);
		System.out.println("After remove(10): " + ts);

		// ===================== 6. HashMap =====================
		System.out.println("\n---- HashMap Methods ----");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(101, "ahad");
		hm.put(102, "hania");
		hm.put(103, "roshi");
		hm.put(null, "NullKey");
		System.out.println("HashMap: " + hm); // Random order
		System.out.println("get(102): " + hm.get(102)); // Returns value for key 102
		hm.replace(103, "dana");
		System.out.println("After replace: " + hm);
		hm.remove(101);
		System.out.println("After remove(101): " + hm);
		System.out.println("containsKey(102): " + hm.containsKey(102)); // true
		System.out.println("containsValue: " + hm.containsValue("hania")); // true
		System.out.println("keySet(): " + hm.keySet()); // All keys
		System.out.println("values(): " + hm.values()); // All values
		System.out.println("entrySet(): " + hm.entrySet()); // key=value pairs

		// ===================== 7. LinkedHashMap =====================
		System.out.println("\n---- LinkedHashMap Methods ----");
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
		lhm.put(1, "Dog");
		lhm.put(2, "Cat");
		lhm.put(3, "Bird");
		System.out.println("LinkedHashMap: " + lhm); // Maintains insertion order
		lhm.remove(2);
		System.out.println("After remove(2): " + lhm);
		System.out.println("getOrDefault: " + lhm.getOrDefault(5, "NotFound"));

		// ===================== 9. TreeMap =====================
		System.out.println("\n---- TreeMap Methods ----");
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(300, "Three Hundred"); 
		tm.put(100, "One Hundred");
		tm.put(200, "Two Hundred");
		System.out.println("TreeMap (sorted by key): " + tm);
		System.out.println("firstKey(): " + tm.firstKey()); // Smallest key
		System.out.println("lastKey(): " + tm.lastKey()); // Largest key
		System.out.println("higherKey(100): " + tm.higherKey(100)); // Next higher key
		System.out.println("lowerKey(300): " + tm.lowerKey(300)); // Next lower key
		tm.remove(200);
		System.out.println("After remove(200): " + tm);
	}
}