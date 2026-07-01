package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

        //____________________implementando os possiveis movimentos da minha torre____________________________________//

        // Definindo posição inicial
        Position p = new Position(0, 0);

        // above ( para cima )......................................
        p.setValues(position.getRow() -1, position.getColumn());
        // Enquanto a não estiver peça adversária nessa posição, eu vou marcar como uma posição verdadeira
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1); // Enquanto for verdadeira eu posso andar
        }
        // e quando não tiver mais casa para andar, eu vou testar se tem uma peça e se ela é adversária
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true; // tendo uma peça oponente a posição se torna verdadeira
        }



        // left ( para cima ).......................................
        p.setValues(position.getRow(), position.getColumn() -1);
        // Enquanto a não estiver peça adversária nessa posição, eu vou marcar como uma posição verdadeira
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1); // Enquanto for verdadeira eu posso andar
        }
        // e quando não tiver mais casa para andar, eu vou testar se tem uma peça e se ela é adversária
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true; // tendo uma peça oponente a posição se torna verdadeira
        }



        // rigth ( para cima )......................................
        p.setValues(position.getRow(), position.getColumn() +1);
        // Enquanto a não estiver peça adversária nessa posição, eu vou marcar como uma posição verdadeira
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1); // Enquanto for verdadeira eu posso andar
        }
        // e quando não tiver mais casa para andar, eu vou testar se tem uma peça e se ela é adversária
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true; // tendo uma peça oponente a posição se torna verdadeira
        }



        // below ( para baixo ).....................................
        p.setValues(position.getRow() +1, position.getColumn());
        // Enquanto a não estiver peça adversária nessa posição, eu vou marcar como uma posição verdadeira
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1); // Enquanto for verdadeira eu posso andar
        }
        // e quando não tiver mais casa para andar, eu vou testar se tem uma peça e se ela é adversária
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true; // tendo uma peça oponente a posição se torna verdadeira
        }


        return mat;
    }
}
