package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    // Construtor com argumentos
    public King(Board board, Color color) {
        super(board, color);
    }

    // Criando o toString
    @Override
    public String toString() {
        return "K";
    }
}
