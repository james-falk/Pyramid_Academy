package com.company;

public class Destroyer extends Ship{

    Destroyer(){
        setName("Destroyer");
        setSize(3);
    }

    public static Destroyer p1Destroyer = new Destroyer();
    public static Destroyer p2Destroyer = new Destroyer();
}
