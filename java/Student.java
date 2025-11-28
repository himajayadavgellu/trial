package com.zerocode.strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
	String name;
	
	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		if(s.name.equals(this.name)) {
			return true;			
		}
		return false;
	}
	public int hashCode() {
		return Objects.hash(name);
	}

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		s1.name = "himaja";
		s2.name = "himaja";
		// equals()
		System.out.println("two objects : " + s1.equals(s2));// false
		System.out.println("s1 == s2 : " + (s1 == s2));
//		Student s1 = new Student();
//		Student s2 = s1;
//		System.out.println(s1.equals(s2));
		// compare string objects
		String str1 = new String("himaja");
		String str2 = new String("himaja");
		System.out.println("two Strings :" + str1.equals(str2));// true
		// hashcode()
		Set<Student> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		System.out.println("size : " + set.size());// 2
		System.out.println("two hashcodes : " + (s1.hashCode() == s2.hashCode()));
	}
}