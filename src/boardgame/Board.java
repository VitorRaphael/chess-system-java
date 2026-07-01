package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;


    // Construtor sem a quantidades de peças
    public Board(int rows, int columns) {
        // Excessão de erro a criar um tabuleiro com medidas menor a 1
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be a t least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Getters e Setters
    public int getRows() {
        return rows;
    }

    /* Não permitir mudar o numero de linhas após criar o tabuleiro
    public void setRows(int rows) {
        this.rows = rows;
    }

     */

    public int getColumns() {
        return columns;
    }

    /* Não permitir mudar o numero de colunas após criar o tabuleiro
    public void setColumns(int columns) {
        this.columns = columns;
    }

     */

    // Método para retornar a peça dada uma coluna
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }
    // Método para retornar a peça dada uma posição
    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Método para acrescentar peças ao taboleiro
    public void placePiece(Piece piece,Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position" + position);
        }
        // Estamos atribuindo a posição dada a peça
        pieces[position.getRow()][position.getColumn()] = piece;
        // Atualizando a posição da peça
        piece.position = position;
    }

    // Método remove piece ( para mover as peças )
    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        // Verificando se há uma peça naquela determinada posição
        if (piece(position) == null) {
            return null;
        }
        // Se tiver vamos remover ( Conseguimos remover apenas declarando null a sua posição )
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    // Testando pela linha e coluna do que por posição
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    // Testando se tem um apeça nessa posição
    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
