package com.aires.utilities;

public class Child_B extends Parent_A {
	public static void eat() {
		System.out.println("inside child class");
	}


	
	public static void main(String args[]) {
		Parent_A A = new Child_B();
		A.eat();
	
		Parent_A B = new Parent_A();
		B.eat();
	
		
	}
}
