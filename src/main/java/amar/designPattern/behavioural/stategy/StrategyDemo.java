package amar.designPattern.behavioural.stategy;

import java.util.Date;

/**
 * Created by amarendra on 05/09/17.
 */
public class StrategyDemo {

    public static void main(final String[] args) {

        final ValidationStrategy validationStrategy = new AmexStrategy();

        final CreditCard creditCard = new CreditCard(validationStrategy);
        creditCard.setNumber("4242424242424242");
        creditCard.setCvv("123");
        creditCard.setDate(new Date().toString());

        final boolean valid = creditCard.isValid();
        System.out.println(valid);
    }

}
