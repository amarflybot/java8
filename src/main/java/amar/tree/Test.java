package amar.tree;

import java.io.FileNotFoundException;

/**
 * Created by amarendra on 05/09/17.
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Operation operation = new OperationImpl();
        Integer division = operation.division(3, 1);

        System.out.println(division);

    }
}

class OperationImpl extends Operation {

    @Override
    public Integer division(final Integer i, final Integer j) throws Exception {
        if (j == 0) {
            throw new FileNotFoundException("");
        }
        return i;
    }
}

class Operation {

    public Integer sum(Integer i, Integer j) {
        return i + j;
    }

    public Integer division(Integer i, Integer j) throws Exception {
        if (j == 0) {
            throw new Exception("J cannot be 0");
        }
        return (i / j);
    }

}
