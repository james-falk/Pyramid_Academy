package com.company;

import java.util.Scanner;

public class Player {
    private String name;
    private int ships = 0;
    private int playerNum = 0;

    public static Player player1 = new Player();
    public static Player player2 = new Player();


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

    public static void registerPlayers() {
        Scanner scan = new Scanner(System.in);

        // 1st Prompt
        System.out.println("Hello, welcome to Battleship");
        System.out.println("Enter Player 1 name: ");
        Player.player1.setName(scan.nextLine());        //Set player 1 name
        Player.player1.setPlayerNum(1);                 // Set player 1 playerNum to 1
        System.out.println("Enter player 2 name: ");
        Player.player2.setName(scan.nextLine());        // Set player 2 name
        Player.player2.setPlayerNum(2);                 // Set player 2 playerNum to 2
        System.out.println();
        System.out.println("In this game of Battleship your ships will be shown on the game board with letters corresponding to their names.");
        System.out.println("Carrier: C");
        System.out.println("Battleship: B");
        System.out.println("Destroyer: D ");
        System.out.println("Submarine: S ");
        System.out.println("Patrol Boat: P ");
        System.out.println();
    }

    public static void setPlayerShips(Board player1Board, Board player2Board) {

        // 2nd Prompt
        // Set ships for player 1
        System.out.println(Player.player1.getName() + ", please enter the coordinates for your carrier ships.");
        // Set carrier ship
        Board.placeShip(Carrier.p1Carrier, player1Board,Player.player1);
        // Set battleship
        Board.placeShip(Battle.p1Battle, player1Board,Player.player1);
        // Set destroyer
        Board.placeShip(Destroyer.p1Destroyer,player1Board,Player.player1);
        // Set submarine
        Board.placeShip(Submarine.p1Submarine, player1Board,Player.player1);
        // Set PatrolBoat
        Board.placeShip(PatrolBoat.p1PatrolBoat,player1Board,Player.player1);

        // Set ships for payer 2
        System.out.println(Player.player2.getName() + ", please enter the coordinates for your carrier ships.");
        // Set carrier ship
        Board.placeShip(Carrier.p2Carrier, player2Board,Player.player2);
        // Set battleship
        Board.placeShip(Battle.p2Battle, player2Board,Player.player2);
        // Set destroyer
        Board.placeShip(Destroyer.p2Destroyer,player2Board,Player.player2);
        // Set submarine
        Board.placeShip(Submarine.p2Submarine, player2Board,Player.player2);
        // Set PatrolBoat
        Board.placeShip(PatrolBoat.p2PatrolBoat,player2Board,Player.player2);

    }


}
