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
                        board.gameBoard[x][y] = 'C';
                        board.gameBoard[x][y + 1] = 'C';
                        board.gameBoard[x][y + 2] = 'C';
                        board.gameBoard[x][y + 3] = 'C';
                        board.gameBoard[x][y + 4] = 'C';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 5 && (board.gameBoard[x+1][y] == '~' && board.gameBoard [x+2][y] == '~' && board.gameBoard[x+3][y] == '~' && board.gameBoard[x+4][y] == '~')) {
                        board.gameBoard[x][y] = 'C';
                        board.gameBoard[x + 1][y] = 'C';
                        board.gameBoard[x + 2][y] = 'C';
                        board.gameBoard[x + 3][y] = 'C';
                        board.gameBoard[x + 4][y] = 'C';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 5 || x > 5) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] != '~') {
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
                        board.gameBoard[x][y] = 'B';
                        board.gameBoard[x][y + 1] = 'B';
                        board.gameBoard[x][y + 2] = 'B';
                        board.gameBoard[x][y + 3] = 'B';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 6 && (board.gameBoard[x+1][y] == '~' && board.gameBoard [x+2][y] == '~' && board.gameBoard[x+3][y] == '~')) {
                        board.gameBoard[x][y] = 'B';
                        board.gameBoard[x + 1][y] = 'B';
                        board.gameBoard[x + 2][y] = 'B';
                        board.gameBoard[x + 3][y] = 'B';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 6 || x > 6) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] != '~') {
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
                        board.gameBoard[x][y] = 'D';
                        board.gameBoard[x][y + 1] = 'D';
                        board.gameBoard[x][y + 2] = 'D';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 7 && (board.gameBoard[x+1][y] == '~' && board.gameBoard [x+2][y] == '~')) {
                        board.gameBoard[x][y] = 'D';
                        board.gameBoard[x + 1][y] = 'D';
                        board.gameBoard[x + 2][y] = 'D';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 7 || x > 7) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] != '~') {
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
                        board.gameBoard[x][y] = 'S';
                        board.gameBoard[x][y + 1] = 'S';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 8 && (board.gameBoard[x+1][y] == '~')) {
                        board.gameBoard[x][y] = 'S';
                        board.gameBoard[x + 1][y] = 'S';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 8 || x > 8) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] != '~') {
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
                        board.gameBoard[x][y] = 'P';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (direction == 'h' && x <= 9) {
                        board.gameBoard[x][y] = 'P';
                        System.out.println("Your " + name + " has been added.");
                        System.out.println();
                        player.setShips(player.getShips()+1);
                        break;
                    } else if (y > 9 || x > 9) {
                        System.out.println("Ship does not fit here.");
                        System.out.println();
                    }
                } else if ((x > 0 && x < numRows) && (y > 0 && y < numCols) && board.gameBoard[x][y] != '~') {
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

        do{
            System.out.println(attackingPlayer.getName() + ", enter the coordinates for an attack: ");
            String point = Main.scan.next();
            String[] pointStr = point.split("");
            int x = Integer.parseInt(pointStr[1]);
            int y = Integer.parseInt(pointStr[3]);
            if(defendingPlayer.getShips() == 0) {
                break;
            }
            if((x >= 1 && x < numRows) && (y >= 1 && y < numCols )) {
                while (true) {
                    if(defendingPlayer.getShips() == 0) {
                        break;
                    }
                    point = Main.scan.next();
                    pointStr = point.split("");
                    x = Integer.parseInt(pointStr[1]);
                    y = Integer.parseInt(pointStr[3]);

                    // If the player has already guessed the given coordinate
                    if(attackBoard.gameBoard[x][y] == 'X' || attackBoard.gameBoard[x][y] == 'M') {
                        System.out.println("You have already guessed those coordinates. Try again.");
                        Board.displayBoard(attackBoard.gameBoard);
                    }
                    // If attack hits the Carrier
                    if (shipBoard.gameBoard[x][y] == 'C') {
                        System.out.println("Hit!!!");
                        attackBoard.gameBoard[x][y] = 'X';
                        if(defendingPlayer.getPlayerNum() == 1) {
                            Carrier.p1Carrier.setSize(Carrier.p1Carrier.getSize() - 1);
                            checkShip(Carrier.p1Carrier, Player.player1);
                        }
                        if(defendingPlayer.getPlayerNum() == 2) {
                            Carrier.p2Carrier.setSize(Carrier.p2Carrier.getSize()-1);
                            checkShip(Carrier.p2Carrier, Player.player2);
                        }
                        Board.displayBoard(attackBoard.gameBoard);
                        System.out.println("Enter coordinates for next attack: ");           // Since hit, they get to attack again
                    }
                    // If attack hits the Battleship
                    if (shipBoard.gameBoard[x][y] == 'B') {
                        System.out.println("Hit!!!");
                        attackBoard.gameBoard[x][y] = 'X';
                        if(defendingPlayer.getPlayerNum() == 1) {
                            Battle.p1Battle.setSize(Battle.p1Battle.getSize() - 1);
                            checkShip(Battle.p1Battle, Player.player1);
                        }
                        if(defendingPlayer.getPlayerNum() == 2) {
                            Battle.p2Battle.setSize(Battle.p2Battle.getSize()-1);
                            checkShip(Battle.p2Battle, Player.player2);
                        }
                        Board.displayBoard(attackBoard.gameBoard);
                        System.out.println("Enter coordinates for next attack: ");           // Since hit, they get to attack again
                    }
                    // If attack hits the destroyer
                    if (shipBoard.gameBoard[x][y] == 'D') {
                        System.out.println("Hit!!!");
                        attackBoard.gameBoard[x][y] = 'X';
                        if(defendingPlayer.getPlayerNum() == 1) {
                            Destroyer.p1Destroyer.setSize(Destroyer.p1Destroyer.getSize() - 1);
                            checkShip(Destroyer.p1Destroyer, Player.player1);
                        }
                        if(defendingPlayer.getPlayerNum() == 2) {
                            Destroyer.p2Destroyer.setSize(Destroyer.p2Destroyer.getSize()-1);
                            checkShip(Destroyer.p2Destroyer, Player.player2);
                        }
                        Board.displayBoard(attackBoard.gameBoard);
                        System.out.println("Enter coordinates for next attack: ");           // Since hit, they get to attack again
                    }
                    // If attack hits the Submarine
                    if (shipBoard.gameBoard[x][y] == 'S') {
                        System.out.println("Hit!!!");
                        attackBoard.gameBoard[x][y] = 'X';
                        if(defendingPlayer.getPlayerNum() == 1) {
                            Submarine.p1Submarine.setSize(Submarine.p1Submarine.getSize() - 1);
                            checkShip(Submarine.p1Submarine, Player.player1);
                        }
                        if(defendingPlayer.getPlayerNum() == 2) {
                            Submarine.p2Submarine.setSize(Submarine.p2Submarine.getSize()-1);
                            checkShip(Submarine.p2Submarine, Player.player2);
                        }
                        Board.displayBoard(attackBoard.gameBoard);
                        System.out.println("Enter coordinates for next attack: ");           // Since hit, they get to attack again
                    }
                    // If attack hits the Patrol Boat
                    if (shipBoard.gameBoard[x][y] == 'P') {
                        System.out.println("Hit!!!");
                        attackBoard.gameBoard[x][y] = 'X';
                        if(defendingPlayer.getPlayerNum() == 1) {
                            PatrolBoat.p1PatrolBoat.setSize(PatrolBoat.p1PatrolBoat.getSize() - 1);
                        }
                        if(defendingPlayer.getPlayerNum() == 2) {
                            PatrolBoat.p2PatrolBoat.setSize(PatrolBoat.p2PatrolBoat.getSize()-1);
                        }
                        System.out.println("Nice! You have sunk your opponents Patrol Boat");
                        if(defendingPlayer.getPlayerNum() == 1){
                            Player.player1.setShips(Player.player1.getShips()-1);
                        }
                        if(defendingPlayer.getPlayerNum() == 2){
                            Player.player2.setShips(Player.player2.getShips()-1);
                        }
                        Board.displayBoard(attackBoard.gameBoard);
                        System.out.println("Enter coordinates for next attack: ");     // Since hit, they get to attack again
                    }
                    if (shipBoard.gameBoard[x][y] == '~') {
                        System.out.println("You missed!");
                        attackBoard.gameBoard[x][y] = 'M';
                        Board.displayBoard(attackBoard.gameBoard);
                        break;
                    }
                }
                break;
            }
            else {
                System.out.println("Those coordinates are not on the game board. Try again.");
            }
        } while(true);

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
    }

    public static void checkShip(Ship ship, Player player) {

        if(ship.getSize() == 0) {
            player.setShips(player.getShips()-1);
            System.out.println("Nice! You have sunk your opponents " + ship.getName());
            System.out.println("Your opponent has " + player.getShips() + " ships remaining.");
        }
    }
}


