package amar.designPattern.creational.singleton.application;

/**
 * Created by amarendra on 16/09/17.
 */
public enum StatementType {
    MINI {
        @Override
        Statement getByType() {
            return new MiniStatement();
        }
    },
    DETAILED{
        @Override
        Statement getByType() {
            return new DetailedStatement();
        }
    },
    DEFAULT{
        @Override
        Statement getByType() {
            return (final Integer integer) -> System.out.println("Printing Default Statement, integer " + integer);
        }
    };

    abstract Statement getByType();
}
