package com.project.oops.tutorial.inheritance.hybrid;

import com.project.oops.tutorial.abstraction.usingclass.Person;
import com.project.oops.tutorial.abstraction.usinginterface.animalnature;
import com.project.oops.tutorial.inheritance.multiple.humannature;

public class Kishore extends Person implements animalnature, humannature{

    public void eats(){
        System.out.println("i like eating dosa");
    }

    public void sleeps(){
        System.out.println("i sleep more than 8 hrs");
    }

    public void walks(){
        System.out.println(" i don't walk often when i'm at home");
    }
    
    public void laughing() {
        System.out.println("i laugh like a human being");
    }
    
    public void believeInGod() {
        System.out.println("i don't believe in a superior being");
    }

    public void reasoning() {
        System.out.println("i ask questions about everything and reason with myself");
    }

}
