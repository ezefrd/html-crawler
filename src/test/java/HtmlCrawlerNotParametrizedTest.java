import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import repository.DocumentFromFileProvider;
import usecase.HtmlCrawler;
import usecase.exceptions.NotFoundElementException;

import java.io.File;
import java.io.IOException;

public class HtmlCrawlerNotParametrizedTest {
    @Test(expected = NotFoundElementException.class)
    public void test_given_certain_element_that_is_not_in_original_html_throw_exception()
            throws IOException {
        //setup:
        Document originalHtml = loadHtml("./src/test/resources/originalSource.html");
        Document similarHtml = loadHtml("./src/test/resources/similarSource1.html");

        //when:
        String pathToElementInSimilarHtml = new HtmlCrawler(new DocumentFromFileProvider()).findElementByIdFromOriginalSourceInSimilar(originalHtml, similarHtml, "not_found_element");

        //then:
        //exception is thrown
    }

    private Document loadHtml(String source) throws IOException {
        File sourceFile = new File(source);
        return Jsoup.parse(
                sourceFile,
                "utf-8",
                sourceFile.getAbsolutePath());
    }
}
