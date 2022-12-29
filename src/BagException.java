public class BagException extends Exception {
    public BagException() {
    }

    public BagException(String message) {
        super(message);
    }

    public BagException(String message, Throwable cause) {
        super(message, cause);
    }

    public BagException(Throwable cause) {
        super(cause);
    }

    public BagException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
