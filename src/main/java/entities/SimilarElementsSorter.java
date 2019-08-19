package entities;

import java.util.Comparator;

public class SimilarElementsSorter implements Comparator<SimilarElement> {
    @Override public int compare(SimilarElement similarElement1, SimilarElement similarElement2) {
        if(similarElement1.isMostSimilarThan(similarElement2)){
            return 1;
        }else{
            return -1;
        }
    }
}