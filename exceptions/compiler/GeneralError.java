package oop.ex6.main.exceptions.compiler;


import oop.ex6.main.exceptions.SystemGeneralError;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have a general eroor in compiler
 */
public class GeneralError extends SystemGeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public GeneralError() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public GeneralError(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public GeneralError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public GeneralError(String message) {
        super(message);
    }
}
