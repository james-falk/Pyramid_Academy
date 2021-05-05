import java.util.Random;

public class Land{



    public Land(){};

    public static char [] [] createGrid() {

        char [] [] grid = { {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}};

        return grid;
    }

    public static void displayGrid(char [] [] grid) {

        for (int i = 0; i < grid.length; i++) {
            String line = "";
            for (int c = 0; c < grid.length; c++) {
                line += "[" + grid[c][i] + "]";
            }
            System.out.println(line);
        }
    }
    public static void addChest(char[][] grid) {                  //Add chest to game board
        Random rand = new Random();
        int randx = rand.nextInt(4);
        int randy = rand.nextInt(4);

        while (grid[randx][randy] != '0') {
            randx = rand.nextInt(4);
            randy = rand.nextInt(4);
        }

        grid[randx][randy] = '+';
    }

}
