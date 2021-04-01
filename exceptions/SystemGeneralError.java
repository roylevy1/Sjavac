package oop.ex6.main.exceptions;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have system general error in variables
 */
public class SystemGeneralError extends Exception {
    /**
     * Constructs a new exception with as its detail message
     */
    public SystemGeneralError() {
        super();
    }

    /***
     *Constructs a new exception with the specified cause.
     * @param cause  the cause for the exception
     */
    public SystemGeneralError(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public SystemGeneralError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public SystemGeneralError(String message) {
        super(message);
    }
}
