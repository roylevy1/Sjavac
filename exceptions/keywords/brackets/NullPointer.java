package oop.ex6.main.exceptions.keywords.brackets;

/**
 * @author roy.levy3
 * @author sharonbash
 *         This class represent an Exception that we got a bracket with null pointer.
 */

public class NullPointer extends GeneralError {
    /**
     * Constructs a new exception with as its detail message.
     */
    public NullPointer() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public NullPointer(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public NullPointer(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public NullPointer(String message) {
        super(message);
    }

}
