package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    // Construtor com argumentos
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    // Getters e Setters
    public char getColumn() {
        return column;
    }

    /* A coluna não pode ser livremente alterada

    public void setColumn(char column) {
        this.column = column;
    }
    */

    public int getRow() {
        return row;
    }

    /* A linha não pode ser livremente alterada

    public void setRow(int row) {
        this.row = row;
    }

     */

    // Método para calcular a coluna da matriz
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    // Método para calcular o inverso da coluna da matriz
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    // Fazendo o toString
    public String toString() {
        return "" + column + row;
    }

}
