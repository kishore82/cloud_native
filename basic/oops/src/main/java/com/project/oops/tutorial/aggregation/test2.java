package com.project.oops.tutorial.aggregation;

import java.util.Scanner;

public class test2 {
    public static void main(String args[])
    {
        //refer 19 line of Employee.java class for constructor
    	Employee kishore = new Employee("kishore"); // address object is created directly inside the constructor itself (line number 22)
    	
    	Address address = new Address("221/3","main road paloothu"," kadamalaikundu","theni","TN",607001);
    	
    	//refer 12 line of Employee.java class for constructor
    	Employee selva = new Employee(address,"selva"); // address object reference is passed in the constructor while creating Employee object
    	
    	System.out.println(kishore.toString());
    	System.out.println(selva.toString());
    }  
}