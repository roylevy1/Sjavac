package oop.ex6.main.exceptions.sections;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we not found semocolon in sections
 */
public class SemicolonNotFound extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public SemicolonNotFound() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public SemicolonNotFound(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public SemicolonNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public SemicolonNotFound(String message) {
        super(message);
    }
}
