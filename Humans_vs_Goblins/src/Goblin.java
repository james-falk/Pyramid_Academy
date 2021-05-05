import java.util.Random;

public class Goblin {
    Random rand = new Random();
    public char goblinChar = '?';
    public int health = rand.nextInt(10)+1;




    public void addGoblin(int numGoblins, char [][] grid) {
        Random rand = new Random();
        int randx = rand.nextInt(4);
        int randy = rand.nextInt(4);

        for(int i = 1; i <= numGoblins; i++) {
            while (grid[randx][randy] != '0') {
                randx = rand.nextInt(4);
                randy = rand.nextInt(4);
            }

            grid[randx][randy] = goblinChar;
        }
    }

    public void combat(char [][] grid, Human currentPlayer) {
        int winner = rand.nextInt(2)+1;  //Get random number 1 or 2
        System.out.println("Oh no!!!! You have encountered a Goblin. Combat ensues...");
        System.out.println();

        if(winner == 1){               //If winner is 1 Human wins
            currentPlayer.kills ++;    //Add 1 to the human's kills
            System.out.println("Congratulations you have killed the goblin.");
        }
        else {                          //If winner is 2 Goblin wins
            currentPlayer.health--;     // Players losses 1 health.
            System.out.println("You could not defeat the goblin, you lose 1 health.");
        }
        Land.addChest(grid);
        System.out.println();
        System.out.println("A new treasure chest has been added to the game.");
        System.out.println();
    }


}



