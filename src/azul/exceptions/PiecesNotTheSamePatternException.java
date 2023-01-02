public class PiecesNotTheSamePatternException extends Exception {
    public PiecesNotTheSamePatternException() {
    }

    public PiecesNotTheSamePatternException(String message) {
        super(message);
    }

    public PiecesNotTheSamePatternException(String message, Throwable cause) {
        super(message, cause);
    }

    public PiecesNotTheSamePatternException(Throwable cause) {
        super(cause);
    }

    public PiecesNotTheSamePatternException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
