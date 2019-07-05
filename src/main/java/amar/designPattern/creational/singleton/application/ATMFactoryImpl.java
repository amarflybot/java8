package amar.designPattern.creational.singleton.application;

/**
 * Created by amarendra on 16/09/17.
 */
public class ATMFactoryImpl implements ATMFactory {

    //private static ATMFactory atmFactory;
    private static Integer integer;

    private ATMFactoryImpl() {
    }

    private ATMFactoryImpl(final Integer integer) {
        this.integer = integer;
    }

    public static Integer getInteger() {
        return integer;
    }

    public static ATMFactory getInstance(final Integer integer) {
        /*
        // This is double locking way of implementing Singleton
        if (atmFactory == null ){
            synchronized (ATMFactoryImpl.class){
                if (atmFactory == null) {
                    System.out.println("Creating object for ATMFactoryImpl !!");
                    atmFactory = new ATMFactoryImpl();
                }
            }
        }
        return atmFactory;*/

        return ATMFactoryImplHelper.getInstance(integer);
    }

    @Override
    public void createStatements(final Statement statement) {
        statement.printStatement(getInteger());
    }

    private static class ATMFactoryImplHelper {
        private static ATMFactory atmFactory;

        private static ATMFactory getInstance(final Integer integer) {
            if (atmFactory == null) atmFactory = new ATMFactoryImpl(integer);
            return atmFactory;
        }
    }
}
