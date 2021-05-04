package com.company;

public abstract class Ship {
    private String name;
    private int size;


    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
