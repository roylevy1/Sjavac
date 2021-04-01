package oop.ex6.main.exceptions.sections.lines;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we got something wrong in the method that handle line
 *         with modifier and variable type
 */
public class LineWithModifierAndVarTypeFail extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public LineWithModifierAndVarTypeFail() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public LineWithModifierAndVarTypeFail(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public LineWithModifierAndVarTypeFail(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public LineWithModifierAndVarTypeFail(String message) {
        super(message);
    }
}
