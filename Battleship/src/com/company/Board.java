package com.company;

public class Board {

    public char[][] gameBoard = createBoard();
    public static int numRows = 9;
    public static int numCols = 9;


    // Method to create new game board
    public static char[][] createBoard() {

        return new char[][]{{' ', '1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'2', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'3', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'4', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'5', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'6', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'7', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'8', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'9', '~', '~', '~', '~', '~', '~', '~', '~', '~'}};
    }

    //Method to display the game board
    public static void displayBoard(char[][] board) {


        for (int i = 0; i < board.length; i++) {
            String line = "";
            for (int c = 0; c < board.length; c++) {
                line += "[" + board[c][i] + "]";
            }
            System.out.println(line);
        }
    }

    //Method to check if ship can be placed
    public static void doesShipFit(Board board) {

    }

    //Method to place ship(s) on board.
    public static void placeShip(Ship ship, Board board) {
        int shipSize = ship.getSize();
        String name = ship.getName();
        String point = "";


        // Get starting point to place next ship
        System.out.println("Enter the coordinates for the " + name + ":");
        point = Main.scan.next();
        System.out.println("Place horizontally or vertically (h or v)? :");
        char direction = Main.scan.next().charAt(0);

        String[] pointStr = point.split("");
        int x = Integer.parseInt(pointStr[1]);
        int y = Integer.parseInt(pointStr[3]);
        System.out.println(x);
        System.out.println(y);

        if (shipSize == 5) {
            if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == '~') {
                if (direction == 'v' && y <= 5) {
                    board.gameBoard[x][y] = 'c';
                    board.gameBoard[x][y + 1] = 'c';
                    board.gameBoard[x][y + 2] = 'c';
                    board.gameBoard[x][y + 3] = 'c';
                    board.gameBoard[x][y + 4] = 'c';
                    System.out.println("Your " + name + " has been added.");
                } else if (direction == 'h' && x <= 5) {
                    board.gameBoard[x][y] = 'c';
                    board.gameBoard[x + 1][y] = 'c';
                    board.gameBoard[x + 2][y] = 'c';
                    board.gameBoard[x + 3][y] = 'c';
                    board.gameBoard[x + 4][y] = 'c';
                    System.out.println("Your " + name + " has been added.");
                }
                else if (y > 5 || x > 5){
                    System.out.println("Ship does not fit here.");
                }
            } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == 'c') {
                System.out.println("You can't place more than one ship at the same location.");
            } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                System.out.println("This coordinate is not on the game board.");
            }
        }
        else if (shipSize == 4) {
        } else if (shipSize == 3) {

        } else if (shipSize == 2) {

        } else { //shipSize = 1

        }

//
//        switch (point) {
//            case "(1,1)":
//                board.gameBoard [1][1] = 'c';
//                break;
//            case "(1,2)":
//                board.gameBoard [1][2] = 'c';
//                break;
//            case "(1,3)":
//                board.gameBoard [1][3] = 'c';
//                break;
//            case "(1,4)":
//                board.gameBoard [1][4] = 'c';
//                break;
//            case "(1,5)":
//                board.gameBoard [1][5] = 'c';
//                break;
//            case "(1,6)":
//                board.gameBoard [1][6] = 'c';
//                break;
//            case "(1,7)":
//                board.gameBoard [1][7] = 'c';
//                break;
//            case "(1,8)":
//                board.gameBoard [1][8] = 'c';
//                break;
//            case "(1,9)":
//                board.gameBoard [1][9] = 'c';
//                break;
//            case "(2,1)":
//                board.gameBoard [2][1] = 'c';
//                break;
//            case "(2,2)":
//                board.gameBoard [2][2] = 'c';
//                break;
//            case "(2,3)":
//                board.gameBoard [2][3] = 'c';
//                break;
//            case "(2,4)":
//                board.gameBoard [2][4] = 'c';
//                break;
//            case "(2,5)":
//                board.gameBoard [2][5] = 'c';
//                break;
//            case "(2,6)":
//                board.gameBoard [2][6] = 'c';
//                break;
//            case "(2,7)":
//                board.gameBoard [2][7] = 'c';
//                break;
//            case "(2,8)":
//                board.gameBoard [2][8] = 'c';
//                break;
//            case "(2,9)":
//                board.gameBoard [2][9] = 'c';
//                break;
//            case "(3,1)":
//                board.gameBoard [3][1] = 'c';
//                break;
//            case "(3,2)":
//                board.gameBoard [3][2] = 'c';
//                break;
//            case "(3,3)":
//                board.gameBoard [3][3] = 'c';
//                break;
//            case "(3,4)":
//                board.gameBoard [3][4] = 'c';
//                break;
//            case "(3,5)":
//                board.gameBoard [3][5] = 'c';
//                break;
//            case "(3,6)":
//                board.gameBoard [3][6] = 'c';
//                break;
//            case "(3,7)":
//                board.gameBoard [3][7] = 'c';
//                break;
//            case "(3,8)":
//                board.gameBoard [3][8] = 'c';
//                break;
//            case "(3,9)":
//                board.gameBoard [3][9] = 'c';
//                break;
//            case "(4,1)":
//                board.gameBoard [4][1] = 'c';
//                break;
//            case "(4,2)":
//                board.gameBoard [4][2] = 'c';
//                break;
//            case "(4,3)":
//                board.gameBoard [4][3] = 'c';
//                break;
//            case "(4,4)":
//                board.gameBoard [4][4] = 'c';
//                break;
//            case "(4,5)":
//                board.gameBoard [4][5] = 'c';
//                break;
//            case "(4,6)":
//                board.gameBoard [4][6] = 'c';
//                break;
//            case "(4,7)":
//                board.gameBoard [4][7] = 'c';
//                break;
//            case "(4,8)":
//                board.gameBoard [4][8] = 'c';
//                break;
//            case "(4,9)":
//                board.gameBoard [4][9] = 'c';
//                break;
//            case "(5,1)":
//                board.gameBoard [5][1] = 'c';
//                break;
//            case "(5,2)":
//                board.gameBoard [5][2] = 'c';
//                break;
//            case "(5,3)":
//                board.gameBoard [5][3] = 'c';
//                break;
//            case "(5,4)":
//                board.gameBoard [5][4] = 'c';
//                break;
//            case "(5,5)":
//                board.gameBoard [5][5] = 'c';
//                break;
//            case "(5,6)":
//                board.gameBoard [5][6] = 'c';
//                break;
//            case "(5,7)":
//                board.gameBoard [5][7] = 'c';
//                break;
//            case "(5,8)":
//                board.gameBoard [5][8] = 'c';
//                break;
//            case "(5,9)":
//                board.gameBoard [5][9] = 'c';
//                break;
//            case "(6,1)":
//                board.gameBoard [6][1] = 'c';
//                break;
//            case "(6,2)":
//                board.gameBoard [6][2] = 'c';
//                break;
//            case "(6,3)":
//                board.gameBoard [6][3] = 'c';
//                break;
//            case "(6,4)":
//                board.gameBoard [6][4] = 'c';
//                break;
//            case "(6,5)":
//                board.gameBoard [6][5] = 'c';
//                break;
//            case "(6,6)":
//                board.gameBoard [6][6] = 'c';
//                break;
//            case "(6,7)":
//                board.gameBoard [6][7] = 'c';
//                break;
//            case "(6,8)":
//                board.gameBoard [6][8] = 'c';
//                break;
//            case "(6,9)":
//                board.gameBoard [6][9] = 'c';
//                break;
//            case "(7,1)":
//                board.gameBoard [7][1] = 'c';
//                break;
//            case "(7,2)":
//                board.gameBoard [7][2] = 'c';
//                break;
//            case "(7,3)":
//                board.gameBoard [7][3] = 'c';
//                break;
//            case "(7,4)":
//                board.gameBoard [7][4] = 'c';
//                break;
//            case "(7,5)":
//                board.gameBoard [7][5] = 'c';
//                break;
//            case "(7,6)":
//                board.gameBoard [7][6] = 'c';
//                break;
//            case "(7,7)":
//                board.gameBoard [7][7] = 'c';
//                break;
//            case "(7,8)":
//                board.gameBoard [7][8] = 'c';
//                break;
//            case "(7,9)":
//                board.gameBoard [7][9] = 'c';
//                break;
//            case "(8,1)":
//                board.gameBoard [8][1] = 'c';
//                break;
//            case "(8,2)":
//                board.gameBoard [8][2] = 'c';
//                break;
//            case "(8,3)":
//                board.gameBoard [8][3] = 'c';
//                break;
//            case "(8,4)":
//                board.gameBoard [8][4] = 'c';
//                break;
//            case "(8,5)":
//                board.gameBoard [8][5] = 'c';
//                break;
//            case "(8,6)":
//                board.gameBoard [8][6] = 'c';
//                break;
//            case "(8,7)":
//                board.gameBoard [8][7] = 'c';
//                break;
//            case "(8,8)":
//                board.gameBoard [8][8] = 'c';
//                break;
//            case "(8,9)":
//                board.gameBoard [8][9] = 'c';
//                break;
//            case "(9,1)":
//                board.gameBoard [9][1] = 'c';
//                break;
//            case "(9,2)":
//                board.gameBoard [9][2] = 'c';
//                break;
//            case "(9,3)":
//                board.gameBoard [9][3] = 'c';
//                break;
//            case "(9,4)":
//                board.gameBoard [9][4] = 'c';
//                break;
//            case "(9,5)":
//                board.gameBoard [9][5] = 'c';
//                break;
//            case "(9,6)":
//                board.gameBoard [9][6] = 'c';
//                break;
//            case "(9,7)":
//                board.gameBoard [9][7] = 'c';
//                break;
//            case "(9,8)":
//                board.gameBoard [9][8] = 'c';
//                break;
//            case "(9,9)":
//                board.gameBoard [9][9] = 'c';
//                break;
//        }

    }
}

