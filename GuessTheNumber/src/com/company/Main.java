package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);

        int guessCount = 0;
        int upperbound = 21;
        String answer;

        System.out.println("Hello! What is your name?");
        String name = in.nextLine();


        do{
            guessCount = 0;
            Random rand = new Random();
            int random = rand.nextInt(upperbound);
            System.out.println("Well, " + name + " I am thinking of a number between 1 and 20.");
            System.out.println("Take a guess.");
            int userInput = in.nextInt();

            while (userInput != random) {
                if( userInput >20 || userInput < 0) {
                    System.out.println("Your guess is not between 1 and 20. Please guess again.");
                }
                else if (userInput > random) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
                System.out.println("Take a guess.");
                userInput = in.nextInt();
                ++guessCount;
            }
            ++guessCount;
            if(guessCount <= 6) {
                System.out.println("Good job, " + name + "! You guessed my number in " + guessCount + " guesses!");
            }
            else{
                System.out.println("You took " + guessCount + " guesses to guess the number, so unfortunately you did not win.");
            }
            System.out.println("Would you like to play again? (y/n)");
            answer = in.next();


        }while (answer.equalsIgnoreCase("y"));
        }

    }



