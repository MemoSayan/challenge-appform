package mx.com.appfull.app.fullstack.infrastructure.repository;

/**
 * An example how to handle exceptions
 * @author Guillermo De la cruz
 * @since 2023-02/28
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}







