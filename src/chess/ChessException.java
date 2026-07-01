package chess;

public class ChessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Construtor que recebe String
    public ChessException(String msg) {
        super(msg);
    }
}
