package amar.reflection;

/**
 * @author Amarendra Kumar
 * @date 04-01-2016 AM 11:24.
 */
public class ConcreteClass extends BaseClass implements BaseInterface {

    public int publicInt;
    protected boolean protectedBoolean;
    Object defaultObject;
    private String privateString = "private string";

    private ConcreteClass() {
        System.out.println("ConcreteClass :: Default Constructor");
    }

    /*private ConcreteClass(int i){
        this.publicInt=i;
        System.out.println("ConcreteClass :: Parametrized Constructor");
    }*/

    @Override
    public void method1() {
        System.out.println("Method1 impl.");
    }

    @Override
    public int method2(String str) {
        System.out.println("Method2 impl.");
        return 0;
    }

    @Override
    public int method4() {
        System.out.println("Method4 overriden.");
        return 0;
    }

    public int method5(int i) {
        System.out.println("Method4 overriden. " + i);
        return 0;
    }

    //member enum
    enum ConcreteClassDefaultEnum {}

    public enum ConcreteClassPublicEnum {}

    //member interface
    public interface ConcreteClassPublicInterface {
    }

    // inner classes
    public class ConcreteClassPublicClass {
    }

    private class ConcreteClassPrivateClass {
    }

    protected class ConcreteClassProtectedClass {
    }

    class ConcreteClassDefaultClass {
    }

}
