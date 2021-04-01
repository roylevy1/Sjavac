package oop.ex6.main.exceptions.sections.conditions;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have cant create condition
 */
public class CantCreateCondition extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantCreateCondition() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public CantCreateCondition(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantCreateCondition(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantCreateCondition(String message) {
        super(message);
    }
}
