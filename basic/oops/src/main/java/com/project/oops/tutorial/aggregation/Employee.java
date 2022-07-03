package com.project.oops.tutorial.aggregation;

public class Employee{ 
    //inside a class, u r using another class --> aggregate class
	private int id;
	private String name;
	
	// Code reuse is best achieved by aggregation 
	// Employee has an address --> aggregation = has-a relationship
	private Address address;
	
	public Employee(Address address, String name) {
	    // parameterized constructor
	    // if no other constructors present, java will create a default empty constructor
		this.address = address; 
		this.name = name;
	}
	
	public Employee(String name) { 
	    // parameterized constructor
	    // if no other constructors present, java will create a default empty constructor
		this.address = new Address("11/2","wikilmiyar Street sorakalpet","cuddalore","cuddalore","TN",607001);
		this.name = name;
	}
	
	public Employee() {
	    // empty constructor
	    // if no other constructors present, java will create a default empty constructor
	} 
	
	// overrides default Object.java class's toString() method
    // All classes that we define will inherit Object.java class
	@Override
	public String toString() {
		return "Name: "+ name + " and "+ "Address: " +address.toString();
	}
}
