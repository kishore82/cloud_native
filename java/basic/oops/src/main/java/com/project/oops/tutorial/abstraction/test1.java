package com.project.oops.tutorial.abstraction;

import java.util.Scanner;

import com.project.oops.tutorial.abstraction.usingclass.Person;
import com.project.oops.tutorial.abstraction.usinginterface.Animal;

public class test1 {
    public static void main(String args[])
    { 
    	String name = "selva"; // static typed (data type declared)
    	// name = "selva"; ---> dynamic typed (data type not declared)
    	
    	//List<String> listOfItems = new ArrayList<>();  ---> using ArrayList implementation
    	//List<String> items = new LinkedList<>();       ---> using LinkedList implementation

    	// implements using interface ---> abstraction
    	Animal tiger = new Animal();
    	Person selva = new Person();
    	
    	selva.printInfo(); // calls the method definition
    	tiger.eats(); // calls the method definition
    	
    }  
}