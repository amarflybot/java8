package amar;

/**
 * @author Amarendra Kumar
 * @date 04-01-2016 AM 11:24.
 */
public class BaseClass {

    public int baseInt;

    public BaseClass() {
        System.out.println("BaseClass :: Default Constructor");
    }

    private static void method3(){
        System.out.println("Method3");
    }

    public int method4(){
        System.out.println("Method4");
        return 0;
    }

    public static int method5(){
        System.out.println("Method5");
        return 0;
    }

    void method6(){
        System.out.println("Method6");
    }

    // inner public class
    public class BaseClassInnerClass{}

    //member public enum
    public enum BaseClassMemberEnum{}
}

