package boardgame;

public class Position {

    private int row;
    private int column;

    // Construtor com argumentos
    public Position(int column, int row) {
        this.column = column;
        this.row = row;
    }

    // Getters e Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // toString para imprimir a posição na tela
    @Override
    public String toString() {
        return row + ", " + column;
    }
}
