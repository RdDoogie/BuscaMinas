public class Celda {
    private boolean esMina;
    private boolean revelada;
    private boolean marcada; // Para poner la "banderita"
    private int minasAdyacentes;

    public Celda() {
        this.esMina = false;
        this.revelada = false;
        this.marcada = false;
        this.minasAdyacentes = 0;
    }


    public boolean isEsMina() { return esMina; }
    public void setEsMina(boolean esMina) { this.esMina = public class Cell {
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
    }esMina; }

    public boolean isRevelada() { return revelada; }
    public void setRevelada(boolean revelada) { this.revelada = revelada; }

    public boolean isMarcada() { return marcada; }
    public void alternarMarca() { this.marcada = !this.marcada; }

    public int getMinasAdyacentes() { return minasAdyacentes; }
    public void setMinasAdyacentes(int minasAdyacentes) { this.minasAdyacentes = minasAdyacentes; }
    public void incrementarMinasAdyacentes() { this.minasAdyacentes++; }


    public String obtenerSimbolo(boolean mostrarTodo) {
        if (mostrarTodo && esMina) {
            return "*"; // Muestra la mina al final del juego
        }
        if (marcada) {
            return "F"; // Flag (Bandera)
        }
        if (!revelada) {
            return "O"; // Celda oculta
        }
        if (esMina) {
            return "*"; // Boom
        }
        if (minasAdyacentes == 0) {
            return " "; // Celda vacía sin minas cerca
        }
        return String.valueOf(minasAdyacentes); // Número de minas cerca
    }
}