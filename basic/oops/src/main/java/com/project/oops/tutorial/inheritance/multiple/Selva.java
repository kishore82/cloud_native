package com.project.oops.tutorial.inheritance.multiple;

import com.project.oops.tutorial.abstraction.usinginterface.animalnature;

public class Selva implements humannature, animalnature
{
    public void eats(){
        System.out.println("i like eating anything");
    }

    public void sleeps(){
        System.out.println("i sleep upto 8 hrs");
    }

    public void walks(){
        System.out.println(" i don't walk quite often");
    }
    
    public void laughing() {
        System.out.println("i laugh like a monkey");
    }
    
    public void believeInGod() {
        System.out.println("i believe in god");
    }

    public void reasoning() {
        System.out.println("i reason with the knowledge that i gained");
    }
}
