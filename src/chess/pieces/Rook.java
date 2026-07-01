package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    // Construtor com argumento
    public Rook(Board board, Color color) {
        super(board, color);
    }

    // Fazendo o ToString
    @Override
    public String toString() {
        return "R";
    }

    // Implementando o metodo abstrato
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
