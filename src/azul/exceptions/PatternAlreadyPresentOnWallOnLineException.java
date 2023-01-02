package azul.exceptions;

public class PatternAlreadyPresentOnWallOnLineException extends PlayerException {
    public PatternAlreadyPresentOnWallOnLineException() {
    }

    public PatternAlreadyPresentOnWallOnLineException(String message) {
        super(message);
    }

    public PatternAlreadyPresentOnWallOnLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatternAlreadyPresentOnWallOnLineException(Throwable cause) {
        super(cause);
    }

    public PatternAlreadyPresentOnWallOnLineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
