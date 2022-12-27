public class NotEnoughPiecesException extends Exception {
    public NotEnoughPiecesException() {
    }

    public NotEnoughPiecesException(String message) {
        super(message);
    }

    public NotEnoughPiecesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughPiecesException(Throwable cause) {
        super(cause);
    }

    public NotEnoughPiecesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
