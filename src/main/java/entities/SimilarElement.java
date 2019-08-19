package entities;

import org.jsoup.nodes.Element;

public class SimilarElement {
    private Element element;
    private Float similarity;
    public SimilarElement(Element subElement, Float similarity) {
        this.element = subElement;
        this.similarity = similarity;
    }

    public boolean isMostSimilarThan(SimilarElement similarElement2) {
        return this.similarity > similarElement2.similarity;
    }

    public String pathToNode() {
        return pathToNode(element.parent(), element.tagName());
    }

    private String pathToNode(Element parentElement, String path){
        if(parentElement == null){
            return path.trim();
        }

        return pathToNode(parentElement.parent(), String.format(" %s > %s", parentElement.tagName(), path));
    }
}
