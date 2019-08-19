package entities;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;

public class SimilarElements {
    private ArrayList<SimilarElement> similarElements;
    public SimilarElements(Elements elements, Element element) {
        similarElements = new ArrayList<SimilarElement>();
        for (Element subElement : elements
             ) {
            float similarity = 0;
            String tag = subElement.tagName();
            Attributes subElementAttrs = subElement.attributes();

            float elementsForSimilarity = 1 + subElementAttrs.size();
            float similarElementsQty = 0;

            if(tag == element.tagName()){
                similarElementsQty++;
            }

            for (Attribute attr: subElementAttrs
                 ) {
                if(!element.attributes().get(attr.getKey()).isEmpty() && element.attributes().get(attr.getKey()).equals(attr.getValue())){
                    similarElementsQty++;
                }
            }

            similarity = similarElementsQty / elementsForSimilarity;

            similarElements.add(new SimilarElement(subElement, similarity));

        }
    }

    public SimilarElement obtainMostSimilar() {
        Collections.sort(this.similarElements, new SimilarElementsSorter());
        return similarElements.get(similarElements.size() - 1);
    }
}
