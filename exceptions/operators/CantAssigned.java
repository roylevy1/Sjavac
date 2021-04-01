package oop.ex6.main.exceptions.operators;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we cant assigned in variables
 */
public class CantAssigned extends oop.ex6.main.exceptions.variables.GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantAssigned() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public CantAssigned(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantAssigned(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantAssigned(String message) {
        super(message);
    }
}

