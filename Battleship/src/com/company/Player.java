package com.company;

public class Player {
    private String name;
    private int ships = 0;
    private int playerNum = 0;


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

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    public int getPlayerNum() {
        return playerNum;
    }


    public static Player player1 = new Player();
    public static Player player2 = new Player();
}
