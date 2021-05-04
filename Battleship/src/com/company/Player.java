package com.company;

public class Player {
    private String name;
    private int ships = 0;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setShips(int ships) {
        this.ships = ships;
    }
    public int getShips() {
        return ships;
    }
}
