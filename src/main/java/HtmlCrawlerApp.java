import repository.DocumentFromFileProvider;
import usecase.HtmlCrawler;

public class HtmlCrawlerApp {
    public static void main ( String [] arguments )
    {
        if(arguments.length != 3 || !validArgs(arguments)){
            System.out.println("You should provide three args with originalFilePath, similarFilePath and exact id of the element in original file");
            return;
        }

        String originalFile = arguments[0];
        String similarFile = arguments[1];
        String elementId = arguments[2];

        HtmlCrawler htmlCrawler = new HtmlCrawler(new DocumentFromFileProvider());

        System.out.println(htmlCrawler.findElementByIdFromOriginalSourceInSimilar(originalFile, similarFile, elementId));
    }

    private static boolean validArgs(String[] arguments) {
        for(int ix = 0; ix < arguments.length; ix++){
            if(arguments[ix] == null){
                return false;
            }
        }

        return true;
    }
}
