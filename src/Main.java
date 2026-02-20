public class Main {
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        int mines = 10;

        Game minesweeper = new Game(rows, cols, mines);
        minesweeper.start();
    }
}