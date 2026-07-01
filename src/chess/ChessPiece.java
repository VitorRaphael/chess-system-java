package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    // Construtor com argumentos
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Getters e Setters
    public Color getColor() {
        return color;
    }

    /* Eu tiro o Set pois não quero que a cor dela seja modificada
    public void setColor(Color color) {
        this.color = color;
    }
    */

    // Metodo para verificar se tem uma peça do oponente no raio de avanço da minha peça
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null &&  p.getColor() != color;
    }
}
