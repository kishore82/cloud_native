package com.project.oops.tutorial.polymorphism;

import com.project.oops.tutorial.abstraction.usingclass.Person;

public class compile extends Person{
    
	/*     If a class has multiple methods having same name but different in parameters, 
	 *     it is known as Method Overloading.
	 */
	// method(function) overloading or compile time polymorphism 
	public boolean isTopper(boolean value) {
		System.out.println("------first------");
		return value;
	}
	public boolean isTopper(boolean value,String name) {
		System.out.println("------second------");
		if(name.equals("kishore") && value == true) return value;
		return false;
	}
	public boolean isTopper(String name) {
		System.out.println("------third------");
		return name=="selva"?true:false;
	}
}
