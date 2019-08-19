package usecase.exceptions;

import java.util.function.Supplier;

public class NotFoundElementException extends RuntimeException {
    public NotFoundElementException(final String message) {
        super(message);
    }
}
