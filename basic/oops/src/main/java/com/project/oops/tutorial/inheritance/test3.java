package com.project.oops.tutorial.inheritance;

import java.util.Scanner;

import com.project.oops.tutorial.inheritance.hybrid.Kishore;
import com.project.oops.tutorial.inheritance.multiple.Selva;
import com.project.oops.tutorial.inheritance.single.Student;

public class test3 {
    public static void main(String args[])
    { 
    	Kishore obj = new Kishore(); //hybrid inheritance
    	obj.believeInGod();
    	
    	// we can pass the value directly inside print function
    	System.out.println(obj.typeOfPerson("selva")); // since the Kishore.java class doesn't override the reading() method, the default parent class's method definition is called
    	
    	Selva selva = new Selva(); //multiple inheritance
        selva.believeInGod();
        
    	Student student = new Student(); //single inheritance
    	
    	// we can also store the value in another variable
    	String value = student.typeOfPerson("selva"); // Student.java class overrides the typeOfPerson() method
    	System.out.println(value);
    }  
}