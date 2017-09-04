package amar.algorithm.search;

/**
 * Created by amarendra on 03/09/17.
 */
public abstract class SearchMatch {

    private int searchIndex;
    private int length;

    public SearchMatch(final int searchIndex, final int length) {
        this.searchIndex = searchIndex;
        this.length = length;
    }

    public int getSearchIndex() {
        return searchIndex;
    }

    public int getLength() {
        return length;
    }
}
