package com.company;

import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> computerPositions = new ArrayList<>();


    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        String playAgain = "yes";
        do {
            playerPositions = new ArrayList<>();
            computerPositions = new ArrayList<>();
            char[][] gameBoard = {{' ', '|', ' ', '|', ' ',},
                    {' ', '|', ' ', '|', ' ', ' '},             //Initialize the 2 dimensional gameboard array
                    {' ', '|', ' ', '|', ' '}};



            Random rand = new Random();                     //Create random generator for computer moves
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Would you like to be X or 0?");
                char playerLetter = ' ';
                try {
                    playerLetter = scan.next().charAt(0);                                       //Get X or O from user
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            System.out.println("The computer will go first.");
            int compFirstMove = rand.nextInt(9) + 1;                                   //Let computer go first
            placeMove(gameBoard, compFirstMove, "computer", playerLetter);
            printGameBoard(gameBoard);

            while (true) {
                System.out.println("What is your next move? (1-9)");
                int playerPosition = 0;
                try {
                    playerPosition = scan.nextInt();                                   //Get next move from user
                } catch (Exception e) {
                    System.out.println(e);
                }


                while (playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
                    System.out.println("This move is already used. Enter an empty position.");
                    playerPosition = scan.nextInt();
                }

                placeMove(gameBoard, playerPosition, "player", playerLetter);

                String result = checkWinner();                                //Check for winner
                if (result.length() > 0) {
                    printGameBoard(gameBoard);
                    System.out.println(result);                                  //Display checkWinner message
                    break;
                }

                int computerPosition = rand.nextInt(9) + 1;                      //Get computer next move
                while (playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
                    computerPosition = rand.nextInt(9) + 1;
                }
                placeMove(gameBoard, computerPosition, "computer", playerLetter);

                printGameBoard(gameBoard);

                result = checkWinner();                                //Check for winner
                if (result.length() > 0) {
                    System.out.println(result);                                  //Display checkWinner message
                    break;
                }
            }
            System.out.println("Do you want to play again? (yes or no)");


            try {
                playAgain = scan.next();
            } catch (Exception e) {
                System.out.println(e);
            }

        } while (playAgain.equalsIgnoreCase("yes"));
        scan.close();
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (var row : gameBoard) {
            for (var c : row) {
                System.out.print(c);
            }
            System.out.println();
            System.out.println("-------");
        }

    }

    public static void placeMove(char[][] gameBoard, int position, String user, char playerLetter) {

        char computerLetter = ' ';

        if (playerLetter == 'X') {
            computerLetter = 'O';
        }
        if (playerLetter == 'O') {
            computerLetter = 'X';
        }
        if (user.equals("player")) {
            playerPositions.add(position);

            switch (position) {
                case 1:
                    gameBoard[0][0] = playerLetter;
                    break;
                case 2:
                    gameBoard[0][2] = playerLetter;
                    break;
                case 3:
                    gameBoard[0][4] = playerLetter;
                    break;
                case 4:
                    gameBoard[1][0] = playerLetter;
                    break;
                case 5:
                    gameBoard[1][2] = playerLetter;
                    break;
                case 6:
                    gameBoard[1][4] = playerLetter;
                    break;
                case 7:
                    gameBoard[2][0] = playerLetter;
                    break;
                case 8:
                    gameBoard[2][2] = playerLetter;
                    break;
                case 9:
                    gameBoard[2][4] = playerLetter;
                    break;
                default:
                    break;
            }

        }
        if (user.equals("computer")) {
            computerPositions.add(position);

            switch (position) {
                case 1:
                    gameBoard[0][0] = computerLetter;
                    break;
                case 2:
                    gameBoard[0][2] = computerLetter;
                    break;
                case 3:
                    gameBoard[0][4] = computerLetter;
                    break;
                case 4:
                    gameBoard[1][0] = computerLetter;
                    break;
                case 5:
                    gameBoard[1][2] = computerLetter;
                    break;
                case 6:
                    gameBoard[1][4] = computerLetter;
                    break;
                case 7:
                    gameBoard[2][0] = computerLetter;
                    break;
                case 8:
                    gameBoard[2][2] = computerLetter;
                    break;
                case 9:
                    gameBoard[2][4] = computerLetter;
                    break;
                default:
                    break;
            }
        }
    }

    public static String checkWinner() {              //Check gameBoard to see if there is a winner

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(var list : winning) {
            if(playerPositions.containsAll(list)) {
                return "Congratulations you won!";
            }
            else if(computerPositions.containsAll(list)){
                return "The computer has beaten you. You lose.";
            }
            else if(playerPositions.size() + computerPositions.size() == 9) {
                return "There is no winner, the game is a tie.";
            }
        }
        return "";
    }
}
