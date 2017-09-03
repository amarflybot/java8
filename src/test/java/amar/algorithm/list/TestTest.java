package amar.algorithm.list;


import org.junit.Assert;

/**
 * Created by amarendra on 02/09/17.
 */
public class TestTest {

    @org.junit.Test
    public void testOperate(){

        int result = Test.operate('+', '1', '2');

        System.out.println(result);

        Assert.assertEquals(3, result);

    }

    @org.junit.Test
    public void testOperate2(){

        int result = Test.operate('*', '7', '6');

        System.out.println(result);

        Assert.assertEquals(42, result);

    }

    @org.junit.Test(expected = RuntimeException.class)
    public void testOperateException(){

        int result = Test.operate('/', '1', '2');

        Assert.assertEquals(3, result);

    }
}
