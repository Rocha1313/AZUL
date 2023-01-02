package azul.exceptions;

public class PieceBagWithEnoughPiecesToFillFactoriesException extends BagException {
    public PieceBagWithEnoughPiecesToFillFactoriesException() {
    }

    public PieceBagWithEnoughPiecesToFillFactoriesException(String message) {
        super(message);
    }

    public PieceBagWithEnoughPiecesToFillFactoriesException(String message, Throwable cause) {
        super(message, cause);
    }

    public PieceBagWithEnoughPiecesToFillFactoriesException(Throwable cause) {
        super(cause);
    }

    public PieceBagWithEnoughPiecesToFillFactoriesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
