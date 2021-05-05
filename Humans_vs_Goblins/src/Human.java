import java.util.Random;

public class Human {

    public String name;
    public int health = 3;
    public char gameChar;
    public int kills = 0;
    public int gems = 0;
    public int goldCoins = 0;
    public int x = 2;
    public int y = 4;


    public Human(){};

    public void displayInventory(){
        System.out.println("Health: " + health);
        System.out.println("Kills: " + kills);
        System.out.println("Gems: " + gems);
        System.out.println("Gold Coins: " + goldCoins);
    }

    @Override
    public String toString() {
        return "Your health is " + health + " and you have killed " + kills + " goblins.";
    }


    public void addPlayer(char playerChar, char[][] grid) {
        // Adds player to the game board
        grid[x][y] = playerChar;
    }

    public void move(char move, char playerChar, char [][] grid, Human currentPlayer) {
        Random rand = new Random();
        int coins = 0;
        int gems = 0;

        if (move == 'n' && y != 0) {
            //move up one space
            grid[x][y] = '0';
            if (grid[x][y - 1] == '?') {
                Goblin goblin = new Goblin();
                goblin.combat(grid,currentPlayer);
                displayInventory();
                //System.out.println(toString());
            }
            if(grid[x][y-1] == '+'){
                System.out.println("You have found a treasure chest");
                System.out.println();
                coins = rand.nextInt(3)+1;
                currentPlayer.goldCoins += coins;
                gems = rand.nextInt(3)+1;
                currentPlayer.gems += gems;
                System.out.println(coins + " coins and " + gems + " gems have been added to your inventory.");
                displayInventory();
            }
            grid[x][y - 1] = playerChar;
            y--;
            System.out.println("You moved n one space.");
            System.out.println();
        } else if (move == 's' && y != 4) {
            //move down one space
            grid[x][y] = '0';
            if (grid[x][y + 1] == '?') {
                Goblin goblin = new Goblin();
                goblin.combat(grid,currentPlayer);
                displayInventory();
                //System.out.println(toString());
            }
            if(grid[x][y+1] == '+') {
                System.out.println("You have found a treasure chest");
                System.out.println();
                coins = rand.nextInt(3)+1;
                currentPlayer.goldCoins += coins;
                gems = rand.nextInt(3)+1;
                currentPlayer.gems += gems;
                System.out.println(coins + " coins and " + gems + " gems have been added to your inventory.");
                displayInventory();
            }
            grid[x][y + 1] = playerChar;
            y++;
            System.out.println("You moved s one space.");
            System.out.println();
        } else if (move == 'e' && x != 4) {
            //move right one space
            grid[x][y] = '0';
            if (grid[x + 1][y] == '?') {
                Goblin goblin = new Goblin();
                goblin.combat(grid,currentPlayer);
                displayInventory();
                //System.out.println(toString());
            }
            if(grid[x+1][y] == '+') {
                System.out.println("You have found a treasure chest");
                System.out.println();
                coins = rand.nextInt(3)+1;
                currentPlayer.goldCoins += coins;
                gems = rand.nextInt(3)+1;
                currentPlayer.gems += gems;
                System.out.println(coins + " coins and " + gems + " gems have been added to your inventory.");
                displayInventory();
            }
            grid[x + 1][y] = playerChar;
            x++;
            System.out.println("You moved e one space.");
            System.out.println();
        } else if (move == 'w' && x != 0) {
            //move left one space
            grid[x][y] = '0';
            if (grid[x - 1][y] == '?') {
                Goblin goblin = new Goblin();
                goblin.combat(grid,currentPlayer);
                displayInventory();
                //System.out.println(toString());
            }
            if(grid[x-1][y] == '+') {
                System.out.println("You have found a treasure chest");
                System.out.println();
                coins = rand.nextInt(3)+1;
                currentPlayer.goldCoins += coins;
                gems = rand.nextInt(3)+1;
                currentPlayer.gems += gems;
                System.out.println(coins + " coins and " + gems + " gems have been added to your inventory.");
                displayInventory();
            }
            grid[x - 1][y] = playerChar;
            x--;
            System.out.println("You moved w one space.");
            System.out.println();
        } else {
            System.out.println("Invalid entry, you are at the edge of the game world. Enter a different direction.");
            System.out.println();
        }

        if(currentPlayer.health == 0){
            System.out.println("Oh no! You have died. You lose :(");
        }
    }


}


