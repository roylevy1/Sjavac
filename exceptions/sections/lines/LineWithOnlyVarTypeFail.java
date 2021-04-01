package oop.ex6.main.exceptions.sections.lines;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we got something wrong in the method that handle line
 *         only variable type
 */
public class LineWithOnlyVarTypeFail extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public LineWithOnlyVarTypeFail() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public LineWithOnlyVarTypeFail(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public LineWithOnlyVarTypeFail(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public LineWithOnlyVarTypeFail(String message) {
        super(message);
    }
}
