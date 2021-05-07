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

        Player.registerPlayers();

        Player.setPlayerShips(player1Board, player2Board);

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
