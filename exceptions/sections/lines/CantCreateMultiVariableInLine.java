package oop.ex6.main.exceptions.sections.lines;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have cant create multi variables in line
 */
public class CantCreateMultiVariableInLine extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantCreateMultiVariableInLine() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public CantCreateMultiVariableInLine(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantCreateMultiVariableInLine(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantCreateMultiVariableInLine(String message) {
        super(message);
    }
}
