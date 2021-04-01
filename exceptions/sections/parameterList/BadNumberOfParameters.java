package oop.ex6.main.exceptions.sections.parameterList;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have a bad number of parmter in compiler
 */
public class BadNumberOfParameters extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public BadNumberOfParameters() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public BadNumberOfParameters(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public BadNumberOfParameters(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public BadNumberOfParameters(String message) {
        super(message);
    }
}
