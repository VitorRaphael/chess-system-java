package boardgame;

public class Piece {

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
}
