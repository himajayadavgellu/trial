package com.zerocode.collections;

import java.util.Stack;

public class StackDemo {

	public static Stack<Integer> createStack() {
		Stack<Integer> s = new Stack<>();
		s.push(10);
		s.push(20);
		s.push(30);
		return s;
	}

	public static Integer pushElement(Stack<Integer> s, int e) {
		return s.push(e);
	}

	public static Integer popElement(Stack<Integer> s) {
		return s.pop();
	}

	public static Integer peekElement(Stack<Integer> s) {
		return s.peek();
	}

	public static boolean isEmpty(Stack<Integer> s) {
		return s.isEmpty();  
	}

	public static void clearStack(Stack<Integer> s) {
		s.clear();
	}

	public static void main(String[] args) {
		Stack<Integer> stack = createStack();
		System.out.println("Initial: " + stack);

		pushElement(stack, 40);
		System.out.println("After push: " + stack);

		System.out.println("Popped: " + popElement(stack));
		System.out.println("After pop: " + stack);

		System.out.println("Top element: " + peekElement(stack));
		System.out.println("Is empty? " + isEmpty(stack));

		clearStack(stack);
		System.out.println("After clear: " + stack);
	}
}
