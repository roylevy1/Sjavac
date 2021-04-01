package oop.ex6.main.exceptions.file;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that we got not found the file
 */
public class NotFound extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public NotFound() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public NotFound(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public NotFound(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public NotFound(String message) {
        super(message);
    }

}
