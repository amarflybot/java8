package amar.designPattern.creational.singleton.application;

/**
 * Created by amarendra on 16/09/17.
 */
public class ATMApplication {

    public static void main(final String[] args) {

        ATMFactoryImpl.getInstance(12).createStatements(StatementType.MINI.getByType());
        ATMFactoryImpl.getInstance(22).createStatements(StatementType.DETAILED.getByType());
        ATMFactoryImpl.getInstance(32).createStatements(new Statement() {
            @Override
            public void printStatement(final Integer integer) {
                System.out.println("Anonymous Statement from main!, integer " + integer);
            }
        });

    }
}
