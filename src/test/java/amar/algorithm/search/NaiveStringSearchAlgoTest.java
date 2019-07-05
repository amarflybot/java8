package amar.algorithm.search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by amarendra on 03/09/17.
 */
public class NaiveStringSearchAlgoTest {

    StringSearchAlgo searchAlgo;

    @Before
    public void setUp() throws Exception {
        searchAlgo = new NaiveStringSearchAlgo();
    }

    @After
    public void tearDown() throws Exception {
        searchAlgo = null;
    }

    @Test
    public void test() throws Exception {

        final String toFind = "PHIL DROPPED HIS PHONE";
        final String search = "DROP";
        final Collection<SearchMatch> matches = searchAlgo.search(toFind, search);

        Assert.assertEquals(1, matches.size());

        matches.forEach(searchMatch -> {
            Assert.assertEquals(4,searchMatch.getLength());
        });

    }
}
