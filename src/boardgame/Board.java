package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;


    // Construtor sem a quantidades de peças
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Getters e Setters
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    // Método para retornar a peça dada uma coluna
    public Piece piece(int row, int column) {
        return pieces[row][column];
    }
    // Método para retornar a peça dada uma posição
    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }
}
