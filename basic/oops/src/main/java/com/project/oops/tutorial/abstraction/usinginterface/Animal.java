package com.project.oops.tutorial.abstraction.usinginterface;

public class Animal implements animalnature{
	private int id; 
	private String name;
	
	public Animal(int id, String name) {
		//parameterized constructor
	    // if no other constructors present, java will create a default empty constructor
		this.id = id;
		this.name = name;
	}
	public Animal() {
		//empty constructor
	    // if no other constructors present, java will create a default empty constructor
	}
	public int getId() {
		//method or function
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// when a class implements interface and overrides its methods/functions, we don't have to specify @Override 
	public void eats() {
		System.out.println("i eat like animal");
	}
	
	public void sleeps() {
		System.out.println("i sleep like animal");
	}

	public void walks() {
		System.out.println("i walk like animal");
	}
}
