import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HtmlCrawlerAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test_application_for_original_similar_and_elementId(){
        //setup:
        String[] arguments = new String[3];
        arguments[0] = "./src/test/resources/originalSource.html";
        arguments[1] = "./src/test/resources/similarSource1.html";
        arguments[2] = "make-everything-ok-button";

        //when:
        HtmlCrawlerApp.main(arguments);
        //then:
        assertEquals("#root >  html >  body >  div >  div >  div >  div >  div >  div > a\n", outContent.toString());
    }

    @Test
    public void test_application__with_out_required_params(){
        //setup:
        String[] arguments = new String[3];
        //when:
        HtmlCrawlerApp.main(arguments);
        //then:
        assertEquals("You should provide three args with originalFilePath, similarFilePath and exact id of the element in original file\n", outContent.toString());
    }

}