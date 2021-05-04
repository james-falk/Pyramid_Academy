package com.company;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here


        Board player1Board = new Board();
        Board player2Board = new Board();

        Board.displayBoard(player2Board.gameBoard);



        // 1st Prompt
        System.out.println("Hello, welcome to Battleship");
        System.out.println("Enter Player 1 name: ");
        Player player1 = new Player();
        player1.setName(scan.next());
        System.out.println("Enter player 2 name: ");
        Player player2 = new Player();
        player2.setName(scan.next());

        System.out.println(player1.getName());
        System.out.println(player2.getName());

        // 2nd Prompt
        // Set ships for player 1
//        Board.displayBoard(player1Board.gameBoard);
        System.out.println(player1.getName() + ", please enter the coordinates for your carrier ships.");
        Carrier p1Carrier = new Carrier();   // Set carrier ship
        Board.placeShip(p1Carrier, player1Board,player1);
        Battle p1Battle = new Battle();      // Set battleship
        Board.placeShip(p1Battle, player1Board,player1);
        Destroyer p1Destroyer = new Destroyer();  // Set destroyer
        Board.placeShip(p1Destroyer,player1Board,player1);
        Submarine p1Submarine = new Submarine(); // Set submarine
        Board.placeShip(p1Submarine, player1Board,player1);
        PatrolBoat p1PatrolBoat = new PatrolBoat();  // Set PatrolBoat
        Board.placeShip(p1PatrolBoat,player1Board,player1);

        // Set ships for payer 2
        System.out.println(player2.getName() + ", please enter the coordinates for your carrier ships.");
        Carrier p2Carrier = new Carrier();   // Set carrier ship
        Board.placeShip(p2Carrier, player2Board,player2);
        Battle p2Battle = new Battle();      // Set battleship
        Board.placeShip(p2Battle, player2Board,player2);
        Destroyer p2Destroyer = new Destroyer();  // Set destroyer
        Board.placeShip(p2Destroyer,player2Board,player2);
        Submarine p2Submarine = new Submarine(); // Set submarine
        Board.placeShip(p2Submarine, player2Board,player2);
        PatrolBoat p2PatrolBoat = new PatrolBoat();  // Set PatrolBoat
        Board.placeShip(p2PatrolBoat,player2Board,player2);

        // Gameplay prompt

        //Create attack Board for each player
        Board p1Attack = new Board();
        Board p2Attack = new Board();










    }
}
