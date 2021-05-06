package com.company;

public class Carrier extends Ship{

    Carrier(){
    setName("Carrier");
    setSize(5);
    }

    public static Carrier p1Carrier = new Carrier();
    public static Carrier p2Carrier = new Carrier();
}
