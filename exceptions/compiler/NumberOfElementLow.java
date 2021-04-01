package oop.ex6.main.exceptions.compiler;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we got number of elemnt low then allow
 */
public class NumberOfElementLow extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public NumberOfElementLow() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public NumberOfElementLow(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public NumberOfElementLow(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public NumberOfElementLow(String message) {
        super(message);
    }
}
