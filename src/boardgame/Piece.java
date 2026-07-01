package boardgame;

public abstract class Piece {

    // Uma peça tem uma posição incial no tabuleiro, e ela não deve ser acessivel, então vamos
    // usar o protected com ela, para impedir sua violação
    protected Position position;
    private Board board;

    // Contstrutor apenas o tabuleiro, pois a posição inicial de uma peça criada, vai ser nula
    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    // Getters e Setters
    protected Board getBoard() { // deixamos ele como protected para não ser acessivel por demais
        return board;
    }

    /* Eu tiro o Set pois não quero que a borda do tabuleiro seja modificada
    public void setBoard(Board board) {
        this.board = board;
    }
    */

    // Método para definir os possiveis movimentos de uma peça
    public abstract boolean[][] possibleMoves();

    // Método para definir se é possivel mover uma dada peça para uma dada possição
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Método que verifica se existe pelo menos 1 movimento para essa peça
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
