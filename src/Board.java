import java.util.Random;

public class Board {
    private Cell[][] grid;
    private int rows;
    private int cols;
    private int totalMines;
    private int safeRevealedCells;

    public Board(int rows, int cols, int totalMines) {
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.safeRevealedCells = 0;
        this.grid = new Cell[rows][cols];

        initializeBoard();
        placeMines();
        calculateAdjacentMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < totalMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            if (!grid[r][c].isMine()) {
                grid[r][c].setMine(true);
                minesPlaced++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].isMine()) continue;

                int count = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = i + dr;
                        int nc = j + dc;
                        if (isValidCoordinate(nr, nc) && grid[nr][nc].isMine()) {
                            count++;
                        }
                    }
                }
                grid[i][j].setAdjacentMines(count);
            }
        }
    }

    private boolean isValidCoordinate(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public boolean revealCell(int r, int c) {
        if (!isValidCoordinate(r, c) || grid[r][c].isRevealed() || grid[r][c].isFlagged()) {
            return true;
        }

        grid[r][c].setRevealed(true);
        safeRevealedCells++;

        if (grid[r][c].isMine()) {
            return false;
        }

        if (grid[r][c].getAdjacentMines() == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    revealCell(r + dr, c + dc);
                }
            }
        }
        return true;
    }

    public void toggleFlag(int r, int c) {
        if (isValidCoordinate(r, c) && !grid[r][c].isRevealed()) {
            grid[r][c].toggleFlag();
        }
    }

    public boolean checkWinCondition() {
        int totalCells = rows * cols;
        return (safeRevealedCells == (totalCells - totalMines));
    }

    public void printBoard(boolean showAll) {
        System.out.print("   ");
        for (int j = 0; j < cols; j++) System.out.print(j + " ");
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j].getSymbol(showAll) + " ");
            }
            System.out.println();
        }
    }
}