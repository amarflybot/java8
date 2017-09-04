package amar.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 03/09/17.
 */
public class NaiveStringSearchAlgo implements StringSearchAlgo {
    
    @Override
    public List<SearchMatch> search(final String toFind, final String search) {
        int rounds = 0;
        List<SearchMatch> matchList = new ArrayList<>();
        for (int i = 0; i < toFind.length(); i++) {
            SearchMatch searchMatch = new SearchMatchImpl(i,search.length());
            for (int j = 0; j < search.length(); j++) {
                rounds++;
                if (toFind.charAt(i) != search.charAt(j)){
                    break;
                } else {
                    i++;
                    if(j == search.length() -1){
                        matchList.add(searchMatch);
                    }
                }
            }

            if (i > (toFind.length() - search.length())){
                break;
            }
        }
        System.out.println("Total rounds -> "+ rounds);
        return matchList;
    }
}
