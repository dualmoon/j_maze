package MazeGenerator.Types;

//TIP grid can be even, will handle needing odd dimensions for the array in Maze class

public class Grid {
    int width;
    int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        int[][] initializedGrid = initializeGrid(this.width, this.height);
        int[][] grid = generateEmptyGrid(initializedGrid);
    }

    private static int[][] initializeGrid(int width, int height) {
        int[][] grid = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }
    public int[][] generateEmptyGrid(int[][] grid) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }
}