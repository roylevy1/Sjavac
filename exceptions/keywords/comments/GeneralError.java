package oop.ex6.main.exceptions.keywords.comments;

import oop.ex6.main.exceptions.SystemGeneralError;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that we got when we have a general error in comments
 */
public class GeneralError extends SystemGeneralError {
    /**
     * Constructs a new exception with as its detail message
     */

    /**
     * Constructs a new exception with the specified cause.
     * the cause for the exception
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
