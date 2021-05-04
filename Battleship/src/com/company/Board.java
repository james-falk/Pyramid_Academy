package com.company;

public class Board {

    public char[][] gameBoard = createBoard();
    public static int numRows = 10;
    public static int numCols = 10;


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
    public static void placeShip(Ship ship, Board board, Player player) {
        int shipSize = ship.getSize();
        String name = ship.getName();
        String point = "";

        // Get starting point to place next ship
        while (true) {
            displayBoard(board.gameBoard);
            System.out.println("Please enter the coordinates for the " + name + " (" + shipSize + " spaces) :");
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
                    if (direction == 'v' && y <= 5 && (board.gameBoard[x][y+1] == '~' && board.gameBoard [x][y+2] == '~' && board.gameBoard[x][y+3] == '~' && board.gameBoard[x][y+4] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x][y + 1] = 'c';
                        board.gameBoard[x][y + 2] = 'c';
                        board.gameBoard[x][y + 3] = 'c';
                        board.gameBoard[x][y + 4] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 5 && (board.gameBoard[x+1][y] == '~' && board.gameBoard [x+2][y] == '~' && board.gameBoard[x+3][y] == '~' && board.gameBoard[x+4][y] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x + 1][y] = 'c';
                        board.gameBoard[x + 2][y] = 'c';
                        board.gameBoard[x + 3][y] = 'c';
                        board.gameBoard[x + 4][y] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 5 || x > 5) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == 'c') {
                    System.out.println("You can't place more than one ship at the same location.");
                    System.out.println();
                } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                } else {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                }
            } else if (shipSize == 4) {
                if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == '~') {
                    if (direction == 'v' && y <= 6 && (board.gameBoard[x][y+1] == '~' && board.gameBoard [x][y+2] == '~' && board.gameBoard[x][y+3] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x][y + 1] = 'c';
                        board.gameBoard[x][y + 2] = 'c';
                        board.gameBoard[x][y + 3] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 6 && (board.gameBoard[x+1][y] == '~' && board.gameBoard [x+2][y] == '~' && board.gameBoard[x+3][y] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x + 1][y] = 'c';
                        board.gameBoard[x + 2][y] = 'c';
                        board.gameBoard[x + 3][y] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 6 || x > 6) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == 'c') {
                    System.out.println("You can't place more than one ship at the same location.");
                    System.out.println();
                } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                } else {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                }
            } else if (shipSize == 3) {
                if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == '~') {
                    if (direction == 'v' && y <= 7 && (board.gameBoard[x][y+1] == '~' && board.gameBoard [x][y+2] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x][y + 1] = 'c';
                        board.gameBoard[x][y + 2] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 7 && (board.gameBoard[x+1][y] == '~' && board.gameBoard [x+2][y] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x + 1][y] = 'c';
                        board.gameBoard[x + 2][y] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 7 || x > 7) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == 'c') {
                    System.out.println("You can't place more than one ship at the same location.");
                    System.out.println();
                } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                } else {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                }
            } else if (shipSize == 2) {

                if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == '~') {
                    if (direction == 'v' && y <= 8 && (board.gameBoard[x][y+1] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x][y + 1] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 8 && (board.gameBoard[x+1][y] == '~')) {
                        board.gameBoard[x][y] = 'c';
                        board.gameBoard[x + 1][y] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 8 || x > 8) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == 'c') {
                    System.out.println("You can't place more than one ship at the same location.");
                    System.out.println();
                } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                } else {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                }
            } else if (shipSize == 1) {
                if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == '~') {
                    if (direction == 'v' && y <= 9) {
                        board.gameBoard[x][y] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 9) {
                        board.gameBoard[x][y] = 'c';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 9 || x > 9) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] == 'c') {
                    System.out.println("You can't place more than one ship at the same location.");
                    System.out.println();
                } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                } else {
                    System.out.println("This coordinate is not on the game board.");
                    System.out.println();
                }
            }
        }
    }

    public static void attack(Board attackBoard, Board shipBoard, Player attackingPlayer, Player defendingPlayer){


    }

}


