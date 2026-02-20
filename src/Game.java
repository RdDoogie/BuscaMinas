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
        System.out.println("Benvingut al Cerca Mines!");

        while (!isGameOver && !isGameWon) {
            System.out.println("Taulell acutal:");
            board.printBoard(false);

            System.out.println(" Selecciona el metode a activar");
            System.out.println("1. Revelar cel.la");
            System.out.println("2. Activar Bandera");
            System.out.print("Selecciona (1 o 2): ");
            int option = scanner.nextInt();

            System.out.print("Selecciona fila: ");
            int row = scanner.nextInt();

            System.out.print("Selecciona columna: ");
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
                System.out.println("Opcio invalida.");
            }
        }

        endGame();
    }

    private void endGame() {
        System.out.println(" --- RESULTAT FINAL ---");
        board.printBoard(true);

        if (isGameWon) {
            System.out.println("Enhorabona has guanyat.");
        } else {
            System.out.println("BOOM! Has ferit una mina. Has perdut.");
        }
        scanner.close();
    }
}