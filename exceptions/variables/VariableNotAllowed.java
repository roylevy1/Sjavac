package oop.ex6.main.exceptions.variables;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have try to use method that not allowed
 */
public class VariableNotAllowed extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public VariableNotAllowed() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public VariableNotAllowed(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public VariableNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public VariableNotAllowed(String message) {
        super(message);
    }
}
