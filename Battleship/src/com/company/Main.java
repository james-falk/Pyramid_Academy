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


        // 2nd Prompt
        // Set ships for player 1
//        Board.displayBoard(player1Board.gameBoard);
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

        // Gameplay prompt

        //Create attack Board for each player
        Board p1Attack = new Board();
        Board p2Attack = new Board();

        while(Player.player1.getShips() != 0 && Player.player2.getShips() != 0){

            //Player 1 attack
            Board.attack(p1Attack, player2Board, Player.player1, Player.player2);
            if(Player.player2.getShips() == 0) break;

            //Player 2 attack
            Board.attack(p2Attack, player1Board, Player.player2, Player.player1);
            if(Player.player1.getShips() == 0) break;





        }









    }
}
