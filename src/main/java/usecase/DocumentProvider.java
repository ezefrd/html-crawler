package usecase;

import org.jsoup.nodes.Document;
import usecase.exceptions.DocumentNotFoundException;

import java.io.IOException;

public interface DocumentProvider {
    Document retrieveDocument(String fileNameOrPath) throws
            DocumentNotFoundException;
}
