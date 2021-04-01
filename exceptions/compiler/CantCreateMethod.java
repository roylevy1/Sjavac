package oop.ex6.main.exceptions.compiler;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when the compiler cant create a method
 */
public class CantCreateMethod extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantCreateMethod() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public CantCreateMethod(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantCreateMethod(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantCreateMethod(String message) {
        super(message);
    }
}
