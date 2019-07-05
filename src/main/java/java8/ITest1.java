package java8;

/**
 * Created by amarendra on 28/08/17.
 */
public interface ITest1 {

    default Integer run(Integer i) {
        return 789;
    }
}
