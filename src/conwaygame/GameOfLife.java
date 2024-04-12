package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {
        // WRITE YOUR CODE HERE
        StdIn.setFile(file);
        int r = StdIn.readInt();
        int c = StdIn.readInt();
        grid = new boolean[r][c]; 
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                    grid[i][j]= StdIn.readBoolean(); 
                    if(grid[i][j] ==ALIVE) {
                        totalAliveCells++; 
                    }
            }
        }
    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {

        // WRITE YOUR CODE HERE
        if(grid[row][col] == ALIVE) {
            return true; 
        }

        else 
            return false; 
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {

        // WRITE YOUR CODE HERE
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) 
            {
                if(grid[i][j] == ALIVE)
                    return true;
            }
        }
        return false; // update this line, provided so that code compiles
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {

        // WRITE YOUR CODE HERE
        int count = 0; 
        if(row == 0 && col == 0) {  // LEFT TOP CORNER

            if(grid[0][grid[0].length-1] == ALIVE ) {
                count++; //left
            }

            if(grid[0][1] == ALIVE) {
                count++; // right
            }

            if(grid[grid.length-1][0] == ALIVE) {
                count++; //top
            }

            if(grid[1][0]==ALIVE) {
                count++; //bottom
            }

            if(grid[grid.length-1][grid[0].length-1] == ALIVE) {
                count++; //left top diagonal
            }

            if(grid[grid.length-1][1] == ALIVE) {
                count++; //right top diagonal
            }

            if(grid[1][grid[0].length-1]==ALIVE) {
                count++; //left bottom diagonal
            }

            if(grid[1][1]==ALIVE) {
                count++; //right bottom diagonal
            }
        }

        else if(row == 0 && col == grid[0].length-1) {   // RIGHT TOP CORNER

            if(grid[0][col-1] == ALIVE ) {
                count++; // left
            }

            if(grid[0][0] == ALIVE) {
                count++; //right 
            }

            if(grid[grid.length-1][col] == ALIVE) {
                count++; //top
            }

            if(grid[1][col]==ALIVE) {
                count++; //bottom  
            }

            if(grid[grid.length-1][col-1] == ALIVE) {
                count++; //left top diagonal 
            }

            if(grid[grid.length-1][0] == ALIVE) {
                count++; //right top diagonal 
            }

            if(grid[1][col-1]==ALIVE) {
                count++; //left bottom diagonal 
            }

            if(grid[1][0]==ALIVE) {
                count++; //right bottom diagonal
            }
        }

        else if(row == grid.length-1 && col == 0) {  // LEFT BOTTOM CORNER

            if(grid[row][grid[0].length-1] == ALIVE ) {
                count++; // left
            }

            if(grid[row][1] == ALIVE) {
                count++; //right
            }

            if(grid[row-1][0] == ALIVE) {
                count++; //top
            }

            if(grid[0][0]==ALIVE) {
                count++; // bottom 
            }

            if(grid[row-1][grid[0].length-1] == ALIVE) {
                count++; // left top diagonal
            }

            if(grid[row-1][1] == ALIVE) {
                count++; // right top diagonal 
            }

            if(grid[0][grid[0].length-1]==ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[0][1]==ALIVE) {
                count++; // right bottom diagonal 
            }
        }

        else if(row == grid.length-1 && col == grid[0].length-1) { // RIGHT BOTTOM CORNER

            if(grid[row][col-1] == ALIVE ) {
                count++; // left 
            }

            if(grid[row][0] == ALIVE) {
                count++; // right 
            }

            if(grid[row-1][col] == ALIVE) {
                count++; // top 
            }

            if(grid[0][col]==ALIVE) {
                count++; // bottom 
            }

            if(grid[row-1][col-1] == ALIVE) {
                count++; // left top diagonal 
            }

            if(grid[row-1][0] == ALIVE) {
                count++; // right top diagonal 
            }

            if(grid[0][col-1]==ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[0][0]==ALIVE) {
                count++; // right bottom diagonal
            }
        }

        else if(row == 0) { // TOP VERTICAL ENDS
            if(grid[0][col-1] == ALIVE) {
                count++; // left 
            }

            if(grid[0][col+1] == ALIVE) {
                count++; // right 
            }

            if(grid[grid.length-1][col]== ALIVE) {
                count++; // top 
            }

            if(grid[row+1][col] == ALIVE) {
                count++; // bottom 
            }

            if(grid[grid.length-1][col-1] == ALIVE) {
                count++; // left top diagonal 
            }

            if(grid[grid.length-1][col+1] == ALIVE) {
                count++; // right top diagonal 
            }

            if(grid[row+1][col-1] == ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[row+1][col+1] == ALIVE) {
                count++; // right bottom diagonal 
            }
        }

        else if(row == grid.length-1) { // BOTTOM VERTICAL ENDS
            if(grid[row][col-1] == ALIVE) {
                count++; // left 
            }

            if(grid[row][col+1] == ALIVE) {
                count++; // right 
            }

            if(grid[row-1][col]== ALIVE) {
                count++; // top 
            }

            if(grid[0][col] == ALIVE) {
                count++; // bottom 
            }

            if(grid[row-1][col-1] == ALIVE) {
                count++; // left top diagonal 
            }

            if(grid[row-1][col+1] == ALIVE) {
                count++; // right top diagonal 
            }

            if(grid[0][col-1] == ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[0][col+1] == ALIVE) {
                count++; // right bottom diagonal 
            }
        }

        else if(col == 0) { // LEFT HORIZONTAL 
            if(grid[row][grid[0].length-1] == ALIVE) {
                count++; // left
            }

            if(grid[row][1] == ALIVE) {
                count++; // right 
            }

            if(grid[row-1][col]== ALIVE) {
                count++; // top
            }

            if(grid[row+1][col] == ALIVE) {
                count++; // bottom
            }

            if(grid[row-1][grid[0].length-1] == ALIVE) {
                count++; // left top diagonal 
            }

            if(grid[row-1][col+1] == ALIVE) {
                count++; // right top diagonal
            }

            if(grid[row+1][grid[0].length-1] == ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[row+1][col+1] == ALIVE) {
                count++; // right bottom diagonal
            }
        }

        else if(col == grid[0].length-1) { // RIGHT HORIZONTAL ENDS
            if(grid[row][col-1] == ALIVE) {
                count++; // left 
            }

            if(grid[row][0] == ALIVE) {
                count++; // right 
            }

            if(grid[row-1][col]== ALIVE) {
                count++; // top
            }

            if(grid[row+1][col] == ALIVE) {
                count++; // bottom
            }

            if(grid[row-1][col-1] == ALIVE) {
                count++; // left top diagonal
            }

            if(grid[row-1][0] == ALIVE) {
                count++; // right top diagonal 
            }

            if(grid[row+1][col-1] == ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[row+1][0] == ALIVE) {
                count++; // right bottom diagonal
            }
        }

        else { // NORMAL NO EDGE CASE 
            if(grid[row][col-1] == ALIVE) {
                count++; // left 
            }

            if(grid[row][col+1] == ALIVE) {
                count++; // right 
            }

            if(grid[row-1][col] == ALIVE) {
                count++; // top
            }

            if(grid[row+1][col] == ALIVE) {
                count++; // bottom
            }

            if(grid[row-1][col-1] == ALIVE) {
                count++; // left top diagonal
            }

            if(grid[row-1][col+1] == ALIVE) {
                count++; // right top diagonal
            }

            if(grid[row+1][col-1] == ALIVE) {
                count++; // left bottom diagonal 
            }

            if(grid[row+1][col+1] == ALIVE) {
                count++; // right bottom diagonal 
            }
        }
        return count;
    }
    

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {
        boolean[][] newGrid = new boolean[grid.length][grid[0].length]; 

        for(int i = 0; i<newGrid.length; i++) {
            for(int j = 0; j < newGrid[0].length; j++) {
                 
            if(grid[i][j]==ALIVE && (numOfAliveNeighbors(i, j) == 0 || numOfAliveNeighbors(i, j) == 1)) {
                newGrid[i][j]=DEAD; 
            }


            if((grid[i][j] == DEAD && numOfAliveNeighbors(i, j) == 3)) {
                newGrid[i][j]=ALIVE; 
            }

            if(grid[i][j]==ALIVE && (numOfAliveNeighbors(i, j) == 2 || numOfAliveNeighbors(i, j) == 3)) {
                newGrid[i][j]=ALIVE; 
            }


            if(grid[i][j]==ALIVE && (numOfAliveNeighbors(i, j) >=4)) {
                newGrid[i][j]=DEAD; 
            }
        }
    }
        
        return newGrid;// update this line, provided so that code compiles
    }

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {

        // WRITE YOUR CODE HERE
        grid = computeNewGrid(); 
        int totCellsAlive = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == ALIVE) {
                    totCellsAlive++; 
                }
            }
        }

        totalAliveCells = totCellsAlive; 
    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        // WRITE YOUR CODE HERE
        for(int i = n; i>0; i--) {
            grid = computeNewGrid(); 
        }
    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {

        // WRITE YOUR CODE HERE
        WeightedQuickUnionUF comm = new WeightedQuickUnionUF(grid.length, grid[0].length); 
        
        //same as method 4, instead of counting, it unions the neighbors
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col<grid[0].length; col++) {
                if(grid[row][col] == ALIVE) {
                    if(row == 0 && col == 0) {  // LEFT TOP CORNER

                        if(grid[0][grid[0].length-1] == ALIVE ) {
                            comm.union(row, col, 0, grid[0].length-1); //left
                        }
            
                        if(grid[0][1] == ALIVE) {
                            comm.union(row, col, 0, 1); // right
                        }
            
                        if(grid[grid.length-1][0] == ALIVE) {
                            comm.union(row, col, grid.length-1, 0); //top
                        }
            
                        if(grid[1][0]==ALIVE) {
                            comm.union(row, col, 1, 0); //bottom
                        }
            
                        if(grid[grid.length-1][grid[0].length-1] == ALIVE) {
                            comm.union(row, col, grid.length-1, grid[0].length-1); //left top diagonal
                        }
            
                        if(grid[grid.length-1][1] == ALIVE) {
                            comm.union(row, col, grid.length-1, 1); //right top diagonal
                        }
            
                        if(grid[1][grid[0].length-1]==ALIVE) {
                            comm.union(row, col, 1, grid[0].length-1); //left bottom diagonal
                        }
            
                        if(grid[1][1]==ALIVE) {
                            comm.union(row, col, 1, 1); //right bottom diagonal
                        }
                    }
            
                    else if(row == 0 && col == grid[0].length-1) {   // RIGHT TOP CORNER
            
                        if(grid[0][col-1] == ALIVE ) {
                            comm.union(row, col, 0, col-1); // left
                        }
            
                        if(grid[0][0] == ALIVE) {
                            comm.union(row, col, 0, 0); //right 
                        }
            
                        if(grid[grid.length-1][col] == ALIVE) {
                            comm.union(row, col, grid.length-1, col); //top
                        }
            
                        if(grid[1][col]==ALIVE) {
                            comm.union(row, col, 1, col); //bottom  
                        }
            
                        if(grid[grid.length-1][col-1] == ALIVE) {
                            comm.union(row, col, grid.length-1, col-1); //left top diagonal 
                        }
            
                        if(grid[grid.length-1][0] == ALIVE) {
                            comm.union(row, col, grid.length-1, 0); //right top diagonal 
                        }
            
                        if(grid[1][col-1]==ALIVE) {
                            comm.union(row, col, 1, col-1); //left bottom diagonal 
                        }
            
                        if(grid[1][0]==ALIVE) {
                            comm.union(row, col, 1, 0); //right bottom diagonal
                        }
                    }
            
                    else if(row == grid.length-1 && col == 0) {  // LEFT BOTTOM CORNER
            
                        if(grid[row][grid[0].length-1] == ALIVE ) {
                            comm.union(row, col, row, grid[0].length-1); // left
                        }
            
                        if(grid[row][1] == ALIVE) {
                            comm.union(row, col, row, 1); //right
                        }
            
                        if(grid[row-1][0] == ALIVE) {
                            comm.union(row, col, row-1, 0); //top
                        }
            
                        if(grid[0][0]==ALIVE) {
                            comm.union(row, col, 0, 0); // bottom 
                        }
            
                        if(grid[row-1][grid[0].length-1] == ALIVE) {
                            comm.union(row, col, row-1, grid[0].length-1); // left top diagonal
                        }
            
                        if(grid[row-1][1] == ALIVE) {
                            comm.union(row, col, row-1, 1); // right top diagonal 
                        }
            
                        if(grid[0][grid[0].length-1]==ALIVE) {
                            comm.union(row, col, 0, grid[0].length-1); // left bottom diagonal 
                        }
            
                        if(grid[0][1]==ALIVE) {
                            comm.union(row, col, 0, 1); // right bottom diagonal 
                        }
                    }
            
                    else if(row == grid.length-1 && col == grid[0].length-1) { // RIGHT BOTTOM CORNER
            
                        if(grid[row][col-1] == ALIVE ) {
                            comm.union(row, col, row, col-1); // left 
                        }
            
                        if(grid[row][0] == ALIVE) {
                            comm.union(row, col, row, 0); // right 
                        }
            
                        if(grid[row-1][col] == ALIVE) {
                            comm.union(row, col, row-1, col); // top 
                        }
            
                        if(grid[0][col]==ALIVE) {
                            comm.union(row, col, 0, col); // bottom 
                        }
            
                        if(grid[row-1][col-1] == ALIVE) {
                            comm.union(row, col, row-1, col-1); // left top diagonal 
                        }
            
                        if(grid[row-1][0] == ALIVE) {
                            comm.union(row, col, row-1, 0); // right top diagonal 
                        }
            
                        if(grid[0][col-1]==ALIVE) {
                            comm.union(row, col, 0, col-1); // left bottom diagonal 
                        }
            
                        if(grid[0][0]==ALIVE) {
                            comm.union(row, col, 0, 0); // right bottom diagonal
                        }
                    }
            
                    else if(row == 0) { // TOP VERTICAL ENDS
                        if(grid[0][col-1] == ALIVE) {
                            comm.union(row, col, 0, col-1); // left 
                        }
            
                        if(grid[0][col+1] == ALIVE) {
                            comm.union(row, col, 0, col+1); // right 
                        }
            
                        if(grid[grid.length-1][col]== ALIVE) {
                            comm.union(row, col, grid.length-1, col); // top 
                        }
            
                        if(grid[row+1][col] == ALIVE) {
                            comm.union(row, col, row+1, col); // bottom 
                        }
            
                        if(grid[grid.length-1][col-1] == ALIVE) {
                            comm.union(row, col, grid.length-1, col-1); // left top diagonal 
                        }
            
                        if(grid[grid.length-1][col+1] == ALIVE) {
                            comm.union(row, col, grid.length-1, col+1); // right top diagonal 
                        }
            
                        if(grid[row+1][col-1] == ALIVE) {
                            comm.union(row, col, row+1, col-1); // left bottom diagonal 
                        }
            
                        if(grid[row+1][col+1] == ALIVE) {
                            comm.union(row, col, row+1, col+1); // right bottom diagonal 
                        }
                    }
            
                    else if(row == grid.length-1) { // BOTTOM VERTICAL ENDS
                        if(grid[row][col-1] == ALIVE) {
                            comm.union(row, col, row, col-1); // left 
                        }
            
                        if(grid[row][col+1] == ALIVE) {
                            comm.union(row, col, row, col+1); // right 
                        }
            
                        if(grid[row-1][col]== ALIVE) {
                            comm.union(row, col, row-1, col);// top 
                        }
            
                        if(grid[0][col] == ALIVE) {
                            comm.union(row, col, 0, col); // bottom 
                        }
            
                        if(grid[row-1][col-1] == ALIVE) {
                            comm.union(row, col, row-1, col-1); // left top diagonal 
                        }
            
                        if(grid[row-1][col+1] == ALIVE) {
                            comm.union(row, col, row-1, col+1); // right top diagonal 
                        }
            
                        if(grid[0][col-1] == ALIVE) {
                            comm.union(row, col, 0, col-1); // left bottom diagonal 
                        }
            
                        if(grid[0][col+1] == ALIVE) {
                            comm.union(row, col, 0, col+1); // right bottom diagonal 
                        }
                    }
            
                    else if(col == 0) { // LEFT HORIZONTAL 
                        if(grid[row][grid[0].length-1] == ALIVE) {
                            comm.union(row, col, row, grid[0].length-1); // left
                        }
            
                        if(grid[row][1] == ALIVE) {
                            comm.union(row, col, row, 1); // right 
                        }
            
                        if(grid[row-1][col]== ALIVE) {
                            comm.union(row, col, row-1, col); // top
                        }
            
                        if(grid[row+1][col] == ALIVE) {
                            comm.union(row, col, row+1, col); // bottom
                        }
            
                        if(grid[row-1][grid[0].length-1] == ALIVE) {
                            comm.union(row, col, row-1, grid[0].length-1); // left top diagonal 
                        }
            
                        if(grid[row-1][col+1] == ALIVE) {
                            comm.union(row, col, row-1, col+1); // right top diagonal
                        }
            
                        if(grid[row+1][grid[0].length-1] == ALIVE) {
                            comm.union(row, col, row+1, grid[0].length-1); // left bottom diagonal 
                        }
            
                        if(grid[row+1][col+1] == ALIVE) {
                            comm.union(row, col, row+1, col+1); // right bottom diagonal
                        }
                    }
            
                    else if(col == grid[0].length-1) { // RIGHT HORIZONTAL ENDS
                        if(grid[row][col-1] == ALIVE) {
                            comm.union(row, col, row, col-1); // left 
                        }
            
                        if(grid[row][0] == ALIVE) {
                            comm.union(row, col, row, 0); // right 
                        }
            
                        if(grid[row-1][col]== ALIVE) {
                            comm.union(row, col, row-1, col); // top
                        }
            
                        if(grid[row+1][col] == ALIVE) {
                            comm.union(row, col, row+1, col); // bottom
                        }
            
                        if(grid[row-1][col-1] == ALIVE) {
                            comm.union(row, col, row-1, col-1); // left top diagonal
                        }
            
                        if(grid[row-1][0] == ALIVE) {
                            comm.union(row, col, row-1, 0); // right top diagonal 
                        }
            
                        if(grid[row+1][col-1] == ALIVE) {
                            comm.union(row, col, row+1, col-1); // left bottom diagonal 
                        }
            
                        if(grid[row+1][0] == ALIVE) {
                            comm.union(row, col, row+1, 0); // right bottom diagonal
                        }
                    }
            
                    else { // NORMAL NO EDGE CASE 
                        if(grid[row][col-1] == ALIVE) {
                            comm.union(row, col, row, col-1); // left 
                        }
            
                        if(grid[row][col+1] == ALIVE) {
                            comm.union(row, col, row, col+1); // right 
                        }
            
                        if(grid[row-1][col] == ALIVE) {
                            comm.union(row, col, row-1, col); // top
                        }
            
                        if(grid[row+1][col] == ALIVE) {
                            comm.union(row, col, row+1, col); // bottom
                        }
            
                        if(grid[row-1][col-1] == ALIVE) {
                            comm.union(row, col, row-1, col-1); // left top diagonal
                        }
            
                        if(grid[row-1][col+1] == ALIVE) {
                            comm.union(row, col, row-1, col+1); // right top diagonal
                        }
            
                        if(grid[row+1][col-1] == ALIVE) {
                            comm.union(row, col, row+1, col-1); // left bottom diagonal 
                        }
            
                        if(grid[row+1][col+1] == ALIVE) {
                            comm.union(row, col, row+1, col+1); // right bottom diagonal 
                        }
                    }

                }
            }
        }

        //creates an arraylist which allows us to add the number of communities in total
        ArrayList<Integer> nodes = new ArrayList<>(); 
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==ALIVE) {
                    if(!(nodes.contains(comm.find(i, j)))) {
                        nodes.add(comm.find(i, j));
                    }
                }
            }
        }

        return nodes.size();     
        }
    }
