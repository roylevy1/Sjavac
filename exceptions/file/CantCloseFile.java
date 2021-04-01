package oop.ex6.main.exceptions.file;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent an Exception that we got when we cant close file
 */
public class CantCloseFile extends GeneralError {
    /**
     * Constructs a new exception with as its detail message
     */
    public CantCloseFile() {
        super();
    }

    /**
     * Constructs a new exception with the specified cause.
     *
     * @param cause the cause for the exception
     */
    public CantCloseFile(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified cause and message
     *
     * @param message the detail message
     * @param cause   the cause for the exception
     */
    public CantCloseFile(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public CantCloseFile(String message) {
        super(message);
    }
}
