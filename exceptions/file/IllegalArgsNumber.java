package oop.ex6.main.exceptions.file;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that we got illegal args number in the data we got from the user.
 */
public class IllegalArgsNumber extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public IllegalArgsNumber() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public IllegalArgsNumber(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public IllegalArgsNumber(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public IllegalArgsNumber(String message) {
        super(message);
    }
}
