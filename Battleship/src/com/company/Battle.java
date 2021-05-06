package com.company;

public class Battle extends Ship{

    Battle(){
        setName("Battleship");
        setSize(4);
    }
    public static Battle p1Battle = new Battle();
    public static Battle p2Battle = new Battle();

}
