package oop.ex6.main.exceptions.compiler;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when the compiler cant read the coomend that in the file
 */
public class CantReadCommend extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantReadCommend() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public CantReadCommend(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantReadCommend(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantReadCommend(String message) {
        super(message);
    }
}
