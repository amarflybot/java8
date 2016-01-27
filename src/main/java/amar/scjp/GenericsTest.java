package amar.scjp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 23/01/16.
 */
public class GenericsTest {

    public static void main(String[] args) {
        GenericsTest genericsTest = new GenericsTest();
        Stud object = new Stud();
        List<Stud> studList = new ArrayList<>();
        studList.add(object);
        //genericsTest.meth1(studList);
    }

    private void meth1(List<Object> object) {
        System.out.println("In Meth1 " + object);
    }
}

class Stud{

}
