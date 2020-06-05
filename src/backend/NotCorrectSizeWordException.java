package backend;

public class NotCorrectSizeWordException extends Exception {

    public NotCorrectSizeWordException() {
    }

    public NotCorrectSizeWordException(String message) {
        super(message);
    }

    public NotCorrectSizeWordException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectSizeWordException(Throwable cause) {
        super(cause);
    }

    public NotCorrectSizeWordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
