import java.util.ArrayList;

// * problem number 7
// * algorithm written after the submission of application

public class Problem7 {

    public int[][] grid = new int[9][9];

    public static final int[][] ALL_ZERO_CONFIG = {

            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }

    };

    public Problem7(int[][] initialConfig) {
        this.grid = initialConfig;
    }

    public Problem7() {
        this(ALL_ZERO_CONFIG);
    }

    public int findAllSolutions(int[][] grid) {


        int[][] threebythree = new int[3][3];
        ArrayList<int[][]> threebythreePossibilities = new ArrayList<int[][]>();
        for (int i = 0; i < 8; i++) {
            
        }

        generateFirstRow(grid[0]);
        return -1;
    }

    private void generateFirstRow(int[] row) {

        // we are assuming that this will be either 0, 1, or 2
        int initialOnes = 0;

        // put -1 for all initial unavailable positions
        for (int i = 0; i < row.length; i++) {

            if (row[i] == 1) {

                initialOnes++;

                if (i >= 1)
                    row[i - 1] = -1;
                row[i + 1] = -1;

            }
        }

    }

}