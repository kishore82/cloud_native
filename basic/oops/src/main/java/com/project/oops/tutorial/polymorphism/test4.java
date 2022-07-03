package com.project.oops.tutorial.polymorphism;

import java.util.Scanner;

import com.project.oops.tutorial.abstraction.usingclass.Person;
import com.project.oops.tutorial.inheritance.single.Student;

public class test4 {
    public static void main(String args[])
    { 
    	runtime obj1 = new runtime();
    	compile obj2 = new compile();
    	obj1.printInfo(); 
    	obj2.printInfo(); // compile.java class doesn't override the printinfo() method, so parent class method is called

    	System.out.println(obj2.isTopper(true));
    	System.out.println(obj2.isTopper("selva"));
    	System.out.println(obj2.isTopper(true,"kishore"));
    }  
}