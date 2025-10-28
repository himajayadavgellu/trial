package com.zerocode.strings;
//File: InterfaceExamples.java

//===== Example 1: Basic Interface =====
interface Animal {
 void eat();
 void sleep();
}

class Dog implements Animal {
 public void eat() { 	
     System.out.println("Dog eats bones.");
 }

 public void sleep() {
     System.out.println("Dog sleeps in a kennel.");
 }
}

//===== Example 2: Multiple Interfaces =====
interface Pet {
 void play();
}

class Cat implements Animal, Pet {
 public void eat() {
     System.out.println("Cat eats fish.");
 }

 public void sleep() {
     System.out.println("Cat sleeps on a mat.");
 }

 public void play() {
     System.out.println("Cat plays with a ball.");
 }
}

//===== Example 3: Default and Static Methods =====
interface Vehicle {
 void start();

 default void stop() {
     System.out.println("Vehicle stopped.");
 }

 static void service() {
     System.out.println("Vehicle needs servicing.");
 }
}

class Car implements Vehicle {
 public void start() {
	 
     System.out.println("Car started.");
 }
}

//===== Example 4: Interface Reference =====
interface Shape {
 void draw();
}

class Circle implements Shape {
 public void draw() {
     System.out.println("Drawing a circle.");
 }
}

//===== MAIN CLASS =====
public class InterfaceExample {
 public static void main(String[] args) {

     System.out.println("=== Example 1: Basic Interface ===");
     Dog dog = new Dog();
     dog.eat();
     dog.sleep();

     System.out.println("\n=== Example 2: Multiple Interfaces ===");
     Cat cat = new Cat();
     cat.eat();
     cat.sleep();
     cat.play();

     System.out.println("\n=== Example 3: Default & Static Methods ===");
     Car car = new Car();
     car.start();
     car.stop();          // default method
     Vehicle.service();   // static method

     System.out.println("\n=== Example 4: Interface Reference ===");
     Shape shape = new Circle(); // Interface reference
     shape.draw();
 }
}

