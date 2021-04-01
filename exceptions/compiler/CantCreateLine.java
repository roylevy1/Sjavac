package oop.ex6.main.exceptions.compiler;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when the compiler cant create a line
 */
public class CantCreateLine extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantCreateLine() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public CantCreateLine(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantCreateLine(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantCreateLine(String message) {
        super(message);
    }
}
