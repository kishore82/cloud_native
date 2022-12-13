package com.project.oops.tutorial.abstraction.usingclass;

public class Person extends actions{
    // access modifier ---> private, public and protected
	private int id; // this is called variable/states/properties
	private String name; // private access modifier used
	public String favourite_fruit = "apple";
	public Person(int id, String name) {
		//parameterized constructor
	    // if no other constructors present, java will create a default empty constructor
		this.id = id;
		this.name = name;
	}
	public Person() {
		// empty constructor 
	    // if no other constructors present, java will create a default empty constructor
	}
	public int getId() {
		//getters
		return id;
	}
	public void setId(int id) {
	    //setters
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String typeOfPerson(String name) {
		if(name.equalsIgnoreCase("selva")) {
			return "abnormal creature";
		}
		else if(name.equalsIgnoreCase("") || name.equals(null)) {
		    return "invalid name"; //exception can be used here to throw
		}
		else {
			return "normal";
		}
	}
	
	public void printInfo() {
		System.out.println("I am a person!!!!");
	}
	
    //	method(function) overriding or runtime polymorphism
	// when a class extends another class and overrides its methods/functions, we should use @Override 
	@Override
	public void speaking() {
		System.out.println("i speak very well");
	}
	@Override
	public void reading() {
		System.out.println("i read books daily");
	}
	@Override
	public void writing() {
		System.out.println("i don't write frequently");
	}
}
