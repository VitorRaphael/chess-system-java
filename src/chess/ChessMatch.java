package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    // Construtor e definindo o tamanho do tabuleiro
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    // Método para retornar uma matriz de peças de xadrez correspondente a esta partida
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    // Método para tirar de uma peça de posição e adicionar a uma nova
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition(); // sourcePosition = posição de origem
        Position target = targetPosition.toPosition(); // targetPositon = posição de destino
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece)capturedPiece;
    }

    // Validação do makeMove
    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source); // Removendo a posição da peça
        Piece capturedPiece = board.removePiece(target); // Removendo uma possivel peça da posição de destino da minha peça
        board.placePiece(p, target); // Passando a minha peça para a posição de destino
        return capturedPiece; // Retornando a peça capturada
    }

    // Validação do validateSourcePosition
    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("Theres is no piece on source position");
        }
    }


    // Operação para colocar peças, passando a posição das coordenadas do xadrez
    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    // Fazendo o InitialSetup da minha partida de xadrez
    private void initialSetup() {

        // Colocando a peça Rook no tabuleiro
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

    }

}
