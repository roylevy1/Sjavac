package oop.ex6.main.exceptions.sections.lines;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have illegal line
 */
public class IllegalLine extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public IllegalLine() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public IllegalLine(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public IllegalLine(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public IllegalLine(String message) {
        super(message);
    }
}
