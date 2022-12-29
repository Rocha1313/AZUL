public class PiecesNotFoundException extends Exception {
    public PiecesNotFoundException() {
    }

    public PiecesNotFoundException(String message) {
        super(message);
    }

    public PiecesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PiecesNotFoundException(Throwable cause) {
        super(cause);
    }

    public PiecesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
