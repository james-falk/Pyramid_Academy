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
        Board.displayBoard(player1Board.gameBoard);
        System.out.println(player1.getName() + ", please enter the coordinates for your carrier ship. (5 spaces)");
        Carrier p1Carrier = new Carrier();
        Board.placeShip(p1Carrier, player1Board);
        Board.displayBoard(player1Board.gameBoard);







    }
}
