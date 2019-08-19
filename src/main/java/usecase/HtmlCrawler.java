package usecase;

import entities.SimilarElement;
import entities.SimilarElements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import usecase.exceptions.NotFoundElementException;

import java.util.Optional;

public class HtmlCrawler {

    private DocumentProvider documentProvider;

    public HtmlCrawler(DocumentProvider documentProvider){
        this.documentProvider = documentProvider;
    }

    public String findElementByIdFromOriginalSourceInSimilar(Document originalHtml, Document similarHtml,
            String originalElementId) {
        Optional<Element> foundedElementInOriginalSource = findElementById(originalHtml, originalElementId);
        Element element = foundedElementInOriginalSource.orElseThrow(() -> new NotFoundElementException(String.format("Not found element %s", originalElementId)));

        Elements elements = similarHtml.getAllElements();

        SimilarElements similarElements = new SimilarElements(elements, element);

        SimilarElement mostSimilar = similarElements.obtainMostSimilar();


        return mostSimilar.pathToNode();
    }

    public String findElementByIdFromOriginalSourceInSimilar(String originalFile, String similarFile,
            String originalElementId) {
        Document originalSource = documentProvider.retrieveDocument(originalFile);
        Document similarSource = documentProvider.retrieveDocument(similarFile);

        return findElementByIdFromOriginalSourceInSimilar(originalSource, similarSource, originalElementId);
    }

    private static Optional<Element> findElementById(Document sourceDocument, String targetElementId) {
            return Optional.ofNullable(sourceDocument.getElementById(targetElementId));
    }
}
