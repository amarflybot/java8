package amar.algorithm.search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by amarendra on 03/09/17.
 */
@SuppressWarnings("ALL")
public class BMHStringSearchAlgoTest {

    public static final String stringToFind = "The heritage of the House of Morgan traces its roots to the partnership of Drexel, Morgan & Co., which in 1895 was renamed J.P. Morgan & Co. (see also: J. Pierpont Morgan). Arguably the most influential financial institution of its era, J.P. Morgan & Co. \n" +
            "financed the formation of the United States Steel Corporation, which took over the business of Andrew Carnegie and others and was the world's first billion dollar corporation. In 1895, J.P. Morgan & Co. supplied the United States government with $62 million in gold to float a bond issue and restore the treasury surplus of $100 million. In 1892, the \n" +
            "company began to finance the New York, New Haven and Hartford Railroad and led it through a series of acquisitions that made it the dominant railroad transporter in New England.\n" +
            "Built in 1914, 23 Wall Street was known as the \"House of Morgan\", and for decades the bank's headquarters was the most important address in American finance. At noon, on September 16, 1920, a terrorist bomb \n" +
            "exploded in front of the bank, injuring 400 and killing 38. Shortly before the bomb went off, a warning note was placed in a mailbox at the corner of Cedar Street and Broadway. The warning read: \"Remember we will not tolerate any longer. Free the \n" +
            "political prisoners or it will be sure death for all of you. American Anarchists Fighters.\" While there are many hypotheses regarding who was behind the bombing and why they did it, after 20 years of investigation the FBI rendered the case inactive without ever finding the perpetrators.\n" +
            "In August 1914, Henry P. Davison, a Morgan partner, traveled to the UK and made a deal with the Bank of England to make J.P. Morgan & Co. the monopoly underwriter of war bonds for the UK and France. The Bank of England became a \"fiscal agent\" of J.P. \n" +
            "Morgan & Co., and vice versa. The company also invested in the suppliers of war equipment to Britain and France. Thus, the company profited from the financing and purchasing activities of the two European governments.\n" +
            "In the 1930s, all of J.P. Morgan & Co. along with all integrated banking businesses in the United States, was required by the provisions of the Glass–Steagall Act to separate its investment banking from its commercial banking operations. J.P. Morgan & Co. \n" +
            "chose to operate as a commercial bank, because at the time commercial lending was perceived as more profitable and prestigious. Additionally, many within J.P. Morgan believed that a change in political climate would eventually allow the company to resume its securities businesses but it would be nearly impossible to reconstitute the bank if it were disassembled.\n" +
            "In 1935, after being barred from securities business for over a year, the heads of J.P. Morgan spun off its investment-banking operations. Led by J.P. Morgan partners, Henry S. Morgan (son of Jack Morgan and grandson of J. Pierpont Morgan) and Harold \n" +
            "Stanley, Morgan Stanley was founded on September 16, 1935, with $6.6 million of nonvoting preferred stock from J.P. Morgan partners. In order to bolster its position, in 1959, J.P. Morgan merged with the Guaranty Trust Company of New York to form the Morgan Guaranty Trust Company. The bank would continue to operate as Morgan Guaranty Trust until the 1980s, before beginning to \n" +
            "migrate back toward the use of the J.P. Morgan brand. In 1984, the group finally purchased the Purdue National Corporation of Lafayette Indiana, uniting a history between the two figures of Salmon Portland Chase and John Purdue. In 1988, the company once again began operating exclusively as J.P. Morgan & Co.";
    public static final String searchString = "ABCDEFGHIJKLMNOP";
    StringSearchAlgo searchAlgo;
    StringSearchAlgo naiveStringSearchAlgo;

    @Before
    public void setUp() throws Exception {
        searchAlgo = new BMHStringSearchAlgo();
        naiveStringSearchAlgo = new NaiveStringSearchAlgo();
    }

    @After
    public void tearDown() throws Exception {
        searchAlgo = null;
        naiveStringSearchAlgo = null;
    }

    @Test
    public void testBMHStringSearchAlgo() throws Exception {
        String toFind = stringToFind;
        String truth = searchString;
        Collection<SearchMatch> matches = searchAlgo.search(toFind, truth);

        //Assert.assertEquals(1, matches.size());

        matches.forEach(searchMatch -> {
            Assert.assertEquals(searchString.length(),searchMatch.getLength());
        });
    }

    @Test
    public void testNaiveStringSearchAlgo() throws Exception {
        String toFind = stringToFind;
        String truth = searchString;
        Collection<SearchMatch> matches = naiveStringSearchAlgo.search(toFind, truth);

        //Assert.assertEquals(1, matches.size());

        matches.forEach(searchMatch -> {
            Assert.assertEquals(searchString.length(),searchMatch.getLength());
        });
    }
}
