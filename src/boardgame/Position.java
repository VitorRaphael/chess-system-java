package boardgame;

public class Position {

    private int row;
    private int column;

    // Construtor com argumentos
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
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

    // Método para atualizar os valores de uma posição

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // toString para imprimir a posição na tela
    @Override
    public String toString() {
        return row + ", " + column;
    }
}
