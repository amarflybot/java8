package amar.scjp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 23/01/16.
 */
public class GenericsTest {

    public static void main(final String[] args) {
        final GenericsTest genericsTest = new GenericsTest();
        final Stud object = new Stud();
        final List<Stud> studList = new ArrayList<>();
        studList.add(object);
        //genericsTest.meth1(studList);
    }

    private void meth1(final List<Object> object) {
        System.out.println("In Meth1 " + object);
    }
}

class Stud {

}
