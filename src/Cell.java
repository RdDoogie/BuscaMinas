public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int adjacentMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    public boolean isMine() { return isMine; }
    public void setMine(boolean mine) { isMine = mine; }

    public boolean isRevealed() { return isRevealed; }
    public void setRevealed(boolean revealed) { isRevealed = revealed; }

    public boolean isFlagged() { return isFlagged; }
    public void toggleFlag() { this.isFlagged = !this.isFlagged; }

    public int getAdjacentMines() { return adjacentMines; }
    public void setAdjacentMines(int adjacentMines) { this.adjacentMines = adjacentMines; }

    public String getSymbol(boolean showAll) {
        if (showAll && isMine) {
            return "*";
        }
        if (isFlagged) {
            return "F";
        }
        if (!isRevealed) {
            return "O";
        }
        if (isMine) {
            return "*";
        }
        if (adjacentMines == 0) {
            return " ";
        }
        return String.valueOf(adjacentMines);
    }
}