package repository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import usecase.DocumentProvider;
import usecase.exceptions.DocumentNotFoundException;

import java.io.File;
import java.io.IOException;

public class DocumentFromFileProvider implements DocumentProvider {

    @Override public Document retrieveDocument(String fileNameOrPath)
            throws DocumentNotFoundException {
        try{
            File sourceFile = new File(fileNameOrPath);
            return Jsoup.parse(
                    sourceFile,
                    "utf-8",
                    sourceFile.getAbsolutePath());
        }catch (Exception ioException){
            throw new DocumentNotFoundException(String.format("Couldn't find document with path:%s in file system", fileNameOrPath));
        }
    }
}
