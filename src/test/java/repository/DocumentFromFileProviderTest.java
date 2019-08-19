package repository;

import org.junit.Test;
import usecase.exceptions.DocumentNotFoundException;

import static org.junit.Assert.*;

public class DocumentFromFileProviderTest {

    @Test(expected = DocumentNotFoundException.class)
    public void test_document_not_found_exception(){
        //setup:
        String fileName = "it_doesnt_matter.html";
        DocumentFromFileProvider documentFromFileProvider = new DocumentFromFileProvider();

        //when:
        documentFromFileProvider.retrieveDocument(fileName);

        //then:
        //throw exception
    }

}