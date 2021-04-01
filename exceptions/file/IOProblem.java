package oop.ex6.main.exceptions.file;

import oop.ex6.main.exceptions.keywords.GeneralError;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that we  got when we have a null pointer in keywords
 */
public class IOProblem extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public IOProblem() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause
     *
     * @param cause the cause for the exception
     */
    public IOProblem(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public IOProblem(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public IOProblem(String message) {
        super(message);
    }
}
