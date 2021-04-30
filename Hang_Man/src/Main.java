package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Main {

    static public void guess(String word, int lives){

        String answer;
        do {
            char[] filler = new char[word.length()];
            int i = 0;
            while (i < word.length()) {                     //fills array with underscores chars
                filler[i] = '_';
                if (word.charAt(i) == ' ') {
                    filler[i] = ' ';
                }
                i++;
            }
            Scanner in = new Scanner(System.in);  //read player guesses

            ArrayList<Character> missedLetters = new ArrayList<Character>();

            while (lives > 0) {
                System.out.println("HANGMAN");
                System.out.println("+---+");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                System.out.println("                  Missed letters: " + missedLetters);
                System.out.print(filler);
                System.out.println("            You have " + lives + " lives remaining");
                System.out.println("");
                System.out.println("Guess a letter:");
                char x = in.next().charAt(0);               // get char input
                x = toLowerCase(x);

                if (missedLetters.contains(x)) {
                    System.out.println("You have already guessed that letter. Choose again.");
                    continue;                                  // while loop continues
                }
                if(!word.contains(String.valueOf(x))){
                    missedLetters.add(x);
                }

                if (word.contains(x + "")) {
                    for (int y = 0; y < word.length(); y++) {      //checks all indexes for char
                        if (word.charAt(y) == x) {
                            filler[y] = x;                      // replaces filler with char
                        }
                    }
                } else {
                    lives--;                             // wrong guess loses a life
                }

                if (word.equals(String.valueOf(filler))) {       //checking if filler equals the word
                    System.out.println(filler);
                    System.out.println("Yes the secret word is " + word + "! You have won!");
                    System.out.println("");
                    break;
                }

                System.out.print(filler);
                System.out.println("            You have " + lives + " lives remaining");

                if(lives == 0) {
                    System.out.println("Sorry you have lost all of your lives.");
                    System.out.println("");
                    break;
                }
            }

            System.out.println("Do you want to play again? (yes or no)");
            answer = in.next();
        }
        while (answer.equalsIgnoreCase("yes"));

    }

    public static void main(String[] args) {
        // write your code here

        String word = "cat"; //create random word
        int lives = 6;
        guess(word,lives);

    }
}
