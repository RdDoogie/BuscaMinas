import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner scanner;
    private boolean isGameOver;
    private boolean isGameWon;

    public Game(int rows, int cols, int mines) {
        this.board = new Board(rows, cols, mines);
        this.scanner = new Scanner(System.in);
        this.isGameOver = false;
        this.isGameWon = false;
    }

    public void start() {
        System.out.println("Welcome to Minesweeper!");

        while (!isGameOver && !isGameWon) {
            System.out.println("\nCurrent board:");
            board.printBoard(false);

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Reveal cell");
            System.out.println("2. Toggle flag");
            System.out.print("Choose an option (1 or 2): ");
            int option = scanner.nextInt();

            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter column: ");
            int col = scanner.nextInt();

            if (option == 1) {
                boolean safe = board.revealCell(row, col);
                if (!safe) {
                    isGameOver = true;
                } else {
                    isGameWon = board.checkWinCondition();
                }
            } else if (option == 2) {
                board.toggleFlag(row, col);
            } else {
                System.out.println("Invalid option.");
            }
        }

        endGame();
    }

    private void endGame() {
        System.out.println(" --- FINAL RESULT ---");
        board.printBoard(true);

        if (isGameWon) {
            System.out.println("Congratulations! You cleared the minefield.");
        } else {
            System.out.println("BOOM! You hit a mine. Game Over.");
        }
        scanner.close();
    }
}