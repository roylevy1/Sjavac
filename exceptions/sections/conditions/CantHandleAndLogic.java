package oop.ex6.main.exceptions.sections.conditions;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that when we have cant handle the And operator Logic
 */
public class CantHandleAndLogic extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantHandleAndLogic() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */

    public CantHandleAndLogic(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantHandleAndLogic(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantHandleAndLogic(String message) {
        super(message);
    }
}
