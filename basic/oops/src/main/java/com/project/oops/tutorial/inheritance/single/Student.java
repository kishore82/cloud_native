package com.project.oops.tutorial.inheritance.single;

import com.project.oops.tutorial.abstraction.usingclass.Person;

public class Student extends Person{
	// Student ---> child class
    // Person ---> parent class
    // single inheritance
    // Student is a person ---> inheritance = is-a relationship
	
	// overrides parent classs's method
	@Override
	public String typeOfPerson(String name) {
        if(name.equalsIgnoreCase("selva")) {
            return "active basketball player";
        }
        else if(name.equalsIgnoreCase("") || name.equals(null)) {
            return "invalid name"; //exception can be used here to throw
        }
        else {
            return "normal";
        }
    }
}
