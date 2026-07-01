package boardgame;

public class BoardException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Construtor que recebe String
    public BoardException(String msg) {
        super(msg);
    }
}
