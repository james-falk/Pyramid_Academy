import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Goblin goblin = new Goblin();


    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String playAgain = "yes";

        do {
            // Create new game board

            char[][] grid = Land.createGrid();

            Human currentPlayer = new Human();
            // Get the users name and character that they will be using.
            System.out.println("Hello, welcome to the game: Humans VS Goblins!");
            System.out.println("This will be you game world.");
            Land.displayGrid(grid);
            System.out.println("What is your name?");
            currentPlayer.name = scan.next();
            System.out.println("Okay, " + currentPlayer.name + " please enter a UTF Character for your player");
            currentPlayer.gameChar = scan.next().charAt(0);
            System.out.println("Thank you " + currentPlayer.name + ". You will use " + currentPlayer.gameChar + " to represent your character in this game.");
            System.out.println("You will begin the game with " + currentPlayer.health + " health. If you reach 0 health you will die and the game will end.");
            currentPlayer.displayInventory();
            // Add Goblins to the game board
            int numGobs = 8;
            goblin.addGoblin(numGobs, grid);
            //Add player to game board
            currentPlayer.addPlayer(currentPlayer.gameChar, grid);
            System.out.println("You have been placed in the bottom of the game world and " + numGobs + " goblins have also been placed in the game world, Good luck!!");
            Land.displayGrid(grid);

            System.out.println();


            while (currentPlayer.health != 0) {
                System.out.println("Which direction would you like to go. Please choose n/s/e/w:");
                currentPlayer.move(scan.next().charAt(0), currentPlayer.gameChar, grid,currentPlayer);
                Land.displayGrid(grid);
            }
            System.out.println();
            System.out.println("Would you like to play again? (yes or no)");
            if(scan.next().equalsIgnoreCase("no")) {
                playAgain = "no";
            }
            System.out.println();
            System.out.println();

        }while(playAgain.equals("yes"));
    }

}

