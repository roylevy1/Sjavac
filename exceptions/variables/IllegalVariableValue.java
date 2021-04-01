package oop.ex6.main.exceptions.variables;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have illegal variable value
 */
public class IllegalVariableValue extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public IllegalVariableValue() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public IllegalVariableValue(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public IllegalVariableValue(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public IllegalVariableValue(String message) {
        super(message);
    }
}
