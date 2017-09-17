package amar.designPattern.creational.singleton.application;

/**
 * Created by amarendra on 16/09/17.
 */
public class ATMFactoryImpl implements ATMFactory {

    //private static ATMFactory atmFactory;
    private static Integer integer;

    public static Integer getInteger() {
        return integer;
    }

    private ATMFactoryImpl() {
    }

    private ATMFactoryImpl(Integer integer){
        this.integer = integer;
    }

    private static class ATMFactoryImplHelper{
        private static ATMFactory atmFactory;
        private static ATMFactory getInstance(Integer integer){
             if (atmFactory == null) atmFactory = new ATMFactoryImpl(integer);
             return atmFactory;
        }
    }

    public static ATMFactory getInstance(Integer integer){
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
}
