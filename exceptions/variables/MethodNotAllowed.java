package oop.ex6.main.exceptions.variables;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have try to use method that not allowed
 */
public class MethodNotAllowed extends IllegalVariableName {
    /**
     * Constructs a new exception with as its detail message
     */
    public MethodNotAllowed() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public MethodNotAllowed(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public MethodNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public MethodNotAllowed(String message) {
        super(message);
    }
}
