package oop.ex6.main.exceptions.sections.lines;

import oop.ex6.main.exceptions.sections.GeneralError;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we got something wrong in the line that is method call
 *         only variable type
 */
public class MethodCallFail extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public MethodCallFail() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public MethodCallFail(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public MethodCallFail(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public MethodCallFail(String message) {
        super(message);
    }
}
