package usecase.exceptions;

public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(final String message) {
        super(message);
    }
}
