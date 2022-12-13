package com.project.oops.tutorial.polymorphism;

import com.project.oops.tutorial.abstraction.usingclass.Person;

public class runtime extends Person{
    
	private String favourite_fruit = "strawberry";
	
	
	/*     If subclass (child class --> Student.java) has the same method as declared in the parent class(Person.java), 
	 *     it is known as method overriding/runtime polymorphism in Java.
	 */
	// when a class extends another class and overrides its methods/functions, we should use @Override 
	@Override
	public void printInfo() {
		System.out.println("I am a student!!");
		System.out.println("i like "+favourite_fruit);
		// calling parent class's variable value using super keyword
		System.out.println("i like "+super.favourite_fruit);
	}
}
