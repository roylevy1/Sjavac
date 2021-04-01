package oop.ex6.main.exceptions.modifiers;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we dont assigned a final
 */
public class FinalMustAssigned extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public FinalMustAssigned() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public FinalMustAssigned(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public FinalMustAssigned(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public FinalMustAssigned(String message) {
        super(message);
    }
}
