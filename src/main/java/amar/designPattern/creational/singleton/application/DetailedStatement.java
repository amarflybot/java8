package amar.designPattern.creational.singleton.application;

/**
 * Created by amarendra on 16/09/17.
 */
public class DetailedStatement implements Statement {
    @Override
    public void printStatement(final Integer integer) {
        System.out.println("Printing Detailed Statement !!, Integer " + integer);
    }
}
