package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {
    private static final long serialVersionUID = 1L;

    // Construtor que recebe String
    public ChessException(String msg) {
        super(msg);
    }
}
