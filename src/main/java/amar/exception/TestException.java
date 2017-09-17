package amar.exception;

/**
 * Created by amarendra on 14/09/17.
 */
public class TestException {

    public static void main(String[] args) {

        try{
          badMethod();
          System.out.println("A");
        } catch (RuntimeException e){
            System.out.println("B");
        } catch (Exception e) {
            System.out.println("C");
        }finally {
            System.out.println("D");
        }

        System.out.println("E");

    }

    private static void badMethod() {
        throw new RuntimeException();
    }
}
