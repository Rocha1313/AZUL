package azul.exceptions;

public class FactoryStillHasPiecesException extends FactoryException {
    public FactoryStillHasPiecesException() {
    }

    public FactoryStillHasPiecesException(String message) {
        super(message);
    }

    public FactoryStillHasPiecesException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactoryStillHasPiecesException(Throwable cause) {
        super(cause);
    }

    public FactoryStillHasPiecesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
