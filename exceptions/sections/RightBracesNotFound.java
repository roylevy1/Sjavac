package oop.ex6.main.exceptions.sections;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we not found right braclet in sections
 */
public class RightBracesNotFound extends BracketNotFound {
    /**
     * Constructs a new exception with as its detail message
     */
    public RightBracesNotFound() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public RightBracesNotFound(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public RightBracesNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public RightBracesNotFound(String message) {
        super(message);
    }
}
