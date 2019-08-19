import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import repository.DocumentFromFileProvider;
import usecase.HtmlCrawler;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HtmlCrawlerTest {
    private String originalSource;
    private String similarSource;
    private String originalElementId;
    private String expectedPath;

    public HtmlCrawlerTest(String originalSource, String similarSource, String originalElementId, String expectedPath){
        this.originalSource = originalSource;
        this.similarSource = similarSource;
        this.originalElementId = originalElementId;
        this.expectedPath = expectedPath;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getAllEntries() {
        return Arrays.asList(new Object[][] {
                { "./src/test/resources/originalSource.html", "./src/test/resources/similarSource1.html", "make-everything-ok-button", "#root >  html >  body >  div >  div >  div >  div >  div >  div > a" },
                { "./src/test/resources/originalSource.html", "./src/test/resources/similarSource2.html", "make-everything-ok-button", "#root >  html >  body >  div >  div >  div >  div >  div >  div >  div > a" },
                { "./src/test/resources/originalSource.html", "./src/test/resources/similarSource3.html", "make-everything-ok-button", "#root >  html >  body >  div >  div >  div >  div >  div >  div > a"},
                { "./src/test/resources/originalSource.html", "./src/test/resources/similarSource4.html", "make-everything-ok-button", "#root >  html >  body >  div >  div >  div >  div >  div >  div > a"},
        });
    }

    @Test
    public void test_given_certain_element_in_original_html_find_in_similars()
            throws IOException {
        //setup:
        Document originalHtml = loadHtml(originalSource);
        Document similarHtml = loadHtml(similarSource);

        //when:
        String pathToElementInSimilarHtml = new HtmlCrawler(new DocumentFromFileProvider()).findElementByIdFromOriginalSourceInSimilar(originalHtml, similarHtml, originalElementId);

        //then:
        Assert.assertEquals(expectedPath, pathToElementInSimilarHtml);
    }

    private Document loadHtml(String source) throws IOException {
        File sourceFile = new File(source);
        return Jsoup.parse(
                sourceFile,
                "utf-8",
                sourceFile.getAbsolutePath());
    }
}


